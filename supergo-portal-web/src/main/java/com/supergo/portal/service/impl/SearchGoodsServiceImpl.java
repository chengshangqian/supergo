package com.supergo.portal.service.impl;

import com.supergo.common.http.HttpResult;
import com.supergo.portal.controller.SearchGoodsController;
import com.supergo.portal.dao.SearchGoodsRepository;
import com.supergo.portal.entity.SearchGoods;
import com.supergo.portal.entity.SearchResult;
import com.supergo.portal.mapper.SearchGoodsMapper;
import com.supergo.portal.service.SearchGoodsService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SearchGoodsServiceImpl implements SearchGoodsService {
    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchGoodsController.class);

    @Autowired
    private SearchGoodsMapper searchGoodsMapper;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private SearchGoodsRepository searchGoodsRepository;

    @Override
    public SearchResult search(String keyword, Map<String, String> filter, Pageable pageable) {

        String goodsNameField = "goods_name"; // 产品名称字段
        String brandNameField = "brand_name"; // 品牌聚合字段
        String brandNameAggs = "brand_aggs"; // 品牌聚合结果名称
        String categoryNameField = "cname3"; // 分类聚合字段
        String categoryNameAggs = "category_aggs"; // 分类聚合结果名称

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
                .withPageable(pageable)

                //添加聚合条件
                .addAggregation(AggregationBuilders.terms(brandNameAggs).field(brandNameField))
                .addAggregation(AggregationBuilders.terms(categoryNameAggs).field(categoryNameField))

                //高亮显示
                .withHighlightFields(new HighlightBuilder.Field(goodsNameField).preTags("<em>").postTags("</em>"))

                // 构建查询对象
                .build();

        //执行查询
        SearchHits<SearchGoods> searchHits = elasticsearchRestTemplate.search(searchQuery, SearchGoods.class);

        // 替换高亮字段后的结果列表
        List<SearchGoods> searchGoodsList = searchHits.get().map(searchHit -> {
            SearchGoods searchGoods = searchHit.getContent();

            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("highlightFields : {}",searchHit.getHighlightFields());
            }

            // 替换命中高亮的内容
            List<String> goodsNameHighlightField = searchHit.getHighlightField(goodsNameField);
            if(null != goodsNameHighlightField && !goodsNameHighlightField.isEmpty()){
                // 首个即可
                searchGoods.setGoods_name(goodsNameHighlightField.get(0));
            }

            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("searchGoods : {}",searchGoods);
            }

            return searchGoods;
        }).collect(Collectors.toList());

        // 获取查询结果
        SearchResult searchResult = new SearchResult();
        searchResult.setResultList(searchGoodsList);

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
    public void importAllGoods() {

        //查询数据库中所有商品
        List<SearchGoods> allGoods = searchGoodsMapper.findAllGoods();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("allGoods => {}", allGoods);
        }

        // 逐个加入到ES中
        allGoods.forEach(goods -> searchGoodsRepository.save(goods));
    }
}
