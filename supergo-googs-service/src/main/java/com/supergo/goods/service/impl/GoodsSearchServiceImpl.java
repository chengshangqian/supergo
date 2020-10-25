package com.supergo.goods.service.impl;

import com.supergo.common.elasticsearch.SearchResult;
import com.supergo.goods.dao.GoodsSearchRepository;
import com.supergo.goods.mapper.GoodsQueryMapper;
import com.supergo.goods.service.GoodsSearchService;
import com.supergo.goods.service.GoodsService;
import com.supergo.pojo.Goods;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GoodsSearchServiceImpl implements GoodsSearchService {

    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsSearchServiceImpl.class);

    // 从数据库中查询商品
    @Autowired
    private GoodsQueryMapper goodsQueryMapper;

    // 从数据库中查询商品
    private GoodsService goodsService;

    // 从ES中搜索商品
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    // 保存商品到ES中，也可以用于搜索
    @Autowired
    private GoodsSearchRepository goodsSearchRepository;

    /**
     * 根据关键字搜索商品名称和副标题，按照类目三分组，并高亮、分页返回搜索结果
     *
     * @param keyword 关键字
     * @param filter  更多的查询条件（bool查询过滤条件）
     * @param page    页数
     * @param size    记录大小
     * @return
     */
    @Override
    public SearchResult search(String keyword, Map<String, String> filter, Integer page, Integer size) {

        // 对应的时Goods实体类中的属性名称（聚合名称除外）
        String goodsNameField = "goodsName"; // 产品名称字段
        String brandNameField = "brandName"; // 品牌聚合字段
        String brandNameAggs = "brandAggs"; // 品牌聚合结果名称
        String categoryNameField = "category3Name"; // 分类聚合字段（即分组字段）
        String categoryNameAggs = "categoryAggs"; // 分类聚合结果名称

        //布尔查询条件构建器
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        // 添加搜索条件和要查询的字段：默认查询产品名称字段
        boolQuery.should(QueryBuilders.multiMatchQuery(keyword, goodsNameField));

        //其它查询条件：判断是否有过滤条件
        if (filter != null && !filter.isEmpty()) {
            filter.keySet().forEach(key -> {
                boolQuery.filter(QueryBuilders.termQuery(key, filter.get(key)));
            });
        }

        //原生查询构建器：创建聚合查询条件
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                // 查询条件
                .withQuery(boolQuery)

                //分页
                .withPageable(PageRequest.of(page, size))

                //添加聚合条件
                .addAggregation(AggregationBuilders.terms(brandNameAggs).field(brandNameField))
                .addAggregation(AggregationBuilders.terms(categoryNameAggs).field(categoryNameField))

                //高亮显示
                .withHighlightFields(new HighlightBuilder.Field(goodsNameField).preTags("<em>").postTags("</em>"))

                // 构建查询对象
                .build();

        //执行查询
        SearchHits<Goods> searchHits = elasticsearchRestTemplate.search(searchQuery, Goods.class);

        // 替换高亮字段后的结果列表
        List<Goods> searchGoodsList = searchHits.get().map(searchHit -> {
            Goods goods = searchHit.getContent();

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("highlightFields : {}", searchHit.getHighlightFields());
            }

            // 替换命中高亮的内容
            List<String> goodsNameHighlightField = searchHit.getHighlightField(goodsNameField);
            if (null != goodsNameHighlightField && !goodsNameHighlightField.isEmpty()) {
                // 首个即可
                goods.setGoodsName(goodsNameHighlightField.get(0));
            }

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("goods : {}", goods);
            }

            return goods;
        }).collect(Collectors.toList());

        // 获取查询结果
        SearchResult searchResult = new SearchResult();
        searchResult.setResults(searchGoodsList);

        // 聚合查询结果
        Aggregations aggregations = searchHits.getAggregations();

        //取品牌聚合结果
        Terms brandTerms = (Terms) aggregations.get(brandNameAggs);
        List<String> brandAggsList = brandTerms.getBuckets().stream().map(brandName -> brandName.getKeyAsString()).collect(Collectors.toList());
        Map brandAggs = new HashMap();
        brandAggs.put("name", "品牌");
        brandAggs.put("field", brandNameField);
        brandAggs.put("content", brandAggsList);

        //取分类聚合结果
        Terms categoryTerms = (Terms) aggregations.get(categoryNameAggs);
        List<String> categoryAggsList = categoryTerms.getBuckets().stream().map(categoryName -> categoryName.getKeyAsString()).collect(Collectors.toList());
        Map categoryAggs = new HashMap();
        categoryAggs.put("name", "分类");
        categoryAggs.put("field", categoryNameField);
        categoryAggs.put("content", categoryAggsList);

        List aggs = new ArrayList();
        aggs.add(brandAggs);
        aggs.add(categoryAggs);

        //设置过滤条件
        searchResult.setAggs(aggs);

        return searchResult;
    }

    /**
     * 将数据库中的所有商品导入到ES中
     *
     * @return
     */
    @Override
    public void buildAllSearchDocuments() {
        // 先检查索引是否已创建，不存在则创建索引
        putSearchIndex();

        // 创建索引和商品搜索文档
        createAllSearchDocuments();
    }

    /**
     * 删除索引后重建
     */
    @Override
    public void rebuildAllSearchDocuments() {
        // 删除索引
        deleteSearchIndex();

        // 重新构建
        buildAllSearchDocuments();
    }

    /**
     * 将数据库中的所有商品导入到ES中
     *
     * @return
     */
    private void createAllSearchDocuments() {

        // 设置基本过滤条件
        Goods filter = new Goods();
        filter.setIsDelete("0");
        filter.setIsMarketable("1");

        //查询数据库中所有商品
        List<Goods> allGoods = goodsQueryMapper.query(filter);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("allGoods => {}", allGoods);
        }

        // 保存到ES中
        elasticsearchRestTemplate.save(allGoods);

        // 逐个加入到ES中
        //allGoods.forEach(goods -> goodsSearchRepository.save(goods));
    }

    @Override
    public void putSearchIndex() {
        IndexOperations ops = elasticsearchRestTemplate.indexOps(Goods.class);
        if (!ops.exists()) {
            if (ops.create()) {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("创建索引[{}]成功...", Goods.class.getSimpleName().toLowerCase());
                }
                return;
            }

            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("索引[{}]创建失败...", Goods.class.getSimpleName().toLowerCase());
            }
            return;
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("索引[{}]已存在，可直接使用已有索引...", Goods.class.getSimpleName().toLowerCase());
        }
    }

    @Override
    public void deleteSearchIndex() {
        IndexOperations ops = elasticsearchRestTemplate.indexOps(Goods.class);
        if (ops.exists()) {
            if (ops.delete()) {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("删除索引[{}]成功...", Goods.class.getSimpleName().toLowerCase());
                }
                return;
            }

            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("索引[{}]删除失败...", Goods.class.getSimpleName().toLowerCase());
            }
            return;
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("索引[{}]不存在...", Goods.class.getSimpleName().toLowerCase());
        }
    }

    @Override
    public Map<String, Object> getSearchIndex() {
        IndexOperations ops = elasticsearchRestTemplate.indexOps(Goods.class);
        Map<String, Object> searchIndexMap = new HashMap<>(2);
        searchIndexMap.put("settings", ops.getSettings());
        searchIndexMap.put("mapping", ops.getMapping());
        return searchIndexMap;
    }

    @Override
    public Goods createSearchDocument(Long id) {
        //return goodsSearchRepository.save(goodsService.findOne(id));
        return elasticsearchRestTemplate.save(goodsService.findOne(id));
    }

    @Override
    public String deleteSearchDocument(String id) {
        return elasticsearchRestTemplate.delete(id,Goods.class);
        //goodsSearchRepository.deleteById(id);
    }

    @Override
    public Goods putSearchDocument(Long id) {
        return elasticsearchRestTemplate.save(goodsService.findOne(id));
    }

    @Override
    public Goods getSearchDocument(String id) {
        return elasticsearchRestTemplate.get(id,Goods.class);
    }
}
