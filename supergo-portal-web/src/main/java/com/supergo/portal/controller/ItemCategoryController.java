package com.supergo.portal.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.feign.clients.ItemcatServiceClient;
import com.supergo.portal.entity.Goods;
import io.swagger.annotations.*;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Api(tags = "商品分类")
@RequestMapping("/items")
public class ItemCategoryController {
    public static final Logger LOGGER = LoggerFactory.getLogger(ItemCategoryController.class);

    @Autowired
    private ItemcatServiceClient itemcatServiceClient;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @ApiOperation(value = "商品分类列表",notes = "获取所有商品分类列表")
    @ApiResponses(
            @ApiResponse(code=200,message = "返回JSON格式的商品分类列表信息")
    )
    @GetMapping("/categories")
    public HttpResult categories() {
        return itemcatServiceClient.categories();
    }

    @ApiOperation(value="搜索关键字关联商品",notes = "根据输入的关键字查找关联的商品列表")
    @ApiImplicitParams(
            @ApiImplicitParam(name="keywords",value = "搜索关键字",required = true)
    )
    @ApiResponses(
            @ApiResponse(code=200,message = "返回JSON格式的商品对象信息")
    )
    @PostMapping("/search")
    public HttpResult goodsSearch(@RequestParam("keywords") String keywords) {

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("接收到搜索请求 : {}",keywords);
        }

        // 搜索字段
        String goodsName = "goods_name";
        String goodsDesc = "goods_desc";

        // 排序字段
        String goodsId = "goods_id";


        // 匹配查询多个字段，任意一个命中即可
        MultiMatchQueryBuilder queryBuilder  = QueryBuilders.multiMatchQuery(keywords,goodsName,goodsDesc);

        // 布尔查询
        /*BoolQueryBuilder boolQueryBuilder=new BoolQueryBuilder()
                .must(new MatchQueryBuilder(goodsName,keywords));*/

        // 结果分页：page从0开始
        Pageable pageable = PageRequest.of(0,10, Sort.by(Sort.Direction.ASC,goodsId));

        // 高亮匹配的关键字
        String preTag = "<font color=\"#dd4b39\">";//google的色值
        String postTag = "</font>";
        HighlightBuilder.Field highlightGoodsName = new HighlightBuilder.Field(goodsName).preTags(preTag).postTags(postTag);
        HighlightBuilder.Field highlightGoodsDesc = new HighlightBuilder.Field(goodsDesc).preTags(preTag).postTags(postTag);

        // 构建查询对象
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder) // 查询条件
                .withPageable(pageable) // 分页
                .withHighlightFields(highlightGoodsName,highlightGoodsDesc)// 高亮
                .build();

        // 发起查询
        SearchHits<Goods> searchHits = elasticsearchRestTemplate.search(query, Goods.class);

        // 将命中的查询结果转换为本地bean结果列表
        List<Goods> goodss = searchHits.get().map(goodsSearchHit -> {
            Goods content = goodsSearchHit.getContent();

            // 替换命中高亮的内容
            Map<String, List<String>> highlightFields = goodsSearchHit.getHighlightFields();

            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("highlightFields : {}",highlightFields);
            }

            if(null != highlightFields && !highlightFields.isEmpty()){
                // 查询时设置的高亮field名字为goods_name，但取值时为goodsName
                if(highlightFields.containsKey("goodsName")){
                    content.setGoodsName(highlightFields.get("goodsName").get(0));
                }
                if(highlightFields.containsKey("goodsDesc")){
                    content.setGoodsDesc(highlightFields.get("goodsDesc").get(0));
                }
            }

            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("content : {}",content);
            }

            return content;
        }).collect(Collectors.toList());


        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("搜索关键字[{}]结果 : {}",keywords,goodss);
        }

        return HttpResult.ok(goodss);
    }
}
