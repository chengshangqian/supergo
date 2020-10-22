package com.supergo.portal.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.feign.clients.ItemcatServiceClient;
import com.supergo.portal.entity.Item;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Api(tags = "商品分类")
public class PortalController {
    public static final Logger LOGGER = LoggerFactory.getLogger(PortalController.class);
    @Autowired
    private ItemcatServiceClient itemcatServiceClient;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @ApiOperation(value = "商品分类列表",notes = "获取所有商品分类列表")
    @ApiResponses(
            @ApiResponse(code=200,message = "返回JSON格式的商品分类列表信息")
    )
    @GetMapping("/itemcats")
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
    @PostMapping("/items")
    public HttpResult items(@RequestParam("keywords") String keywords) {

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("接收到搜索请求 : {}",keywords);
        }

        // 搜索字段
        String itemName = "item_name";
        String itemDesc = "item_desc";

        // 排序字段
        String itemId = "item_id";


        // 匹配查询多个字段，任意一个命中即可
        MultiMatchQueryBuilder queryBuilder  = QueryBuilders.multiMatchQuery(keywords,itemName,itemDesc);

        // 布尔查询
        /*BoolQueryBuilder boolQueryBuilder=new BoolQueryBuilder()
                .must(new MatchQueryBuilder(itemName,keywords));*/

        // 结果分页：page从0开始
        Pageable pageable = PageRequest.of(0,10, Sort.by(Sort.Direction.ASC,itemId));

        // 高亮匹配的关键字
        String preTag = "<font color=\"#dd4b39\">";//google的色值
        String postTag = "</font>";
        HighlightBuilder.Field highlightItemName = new HighlightBuilder.Field(itemName).preTags(preTag).postTags(postTag);
        HighlightBuilder.Field highlightItemDesc = new HighlightBuilder.Field(itemDesc).preTags(preTag).postTags(postTag);

        // 构建查询对象
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder) // 查询条件
                .withPageable(pageable) // 分页
                .withHighlightFields(highlightItemName,highlightItemDesc)// 高亮
                .build();

        // 发起查询
        SearchHits<Item> searchHits = elasticsearchRestTemplate.search(query, Item.class);

        // 将命中的查询结果转换为本地bean结果列表
        List<Item> items = searchHits.get().map(itemSearchHit -> {
            Item content = itemSearchHit.getContent();

            // 替换命中高亮的内容
            Map<String, List<String>> highlightFields = itemSearchHit.getHighlightFields();
            LOGGER.debug("highlightFields : {}",highlightFields);
            if(null != highlightFields && !highlightFields.isEmpty()){
                // 查询时设置的高亮field名字为item_name，但取值时为itemName
                if(highlightFields.containsKey("itemName")){
                    content.setItemName(highlightFields.get("itemName").get(0));
                }
                if(highlightFields.containsKey("itemDesc")){
                    content.setItemDesc(highlightFields.get("itemDesc").get(0));
                }
            }

            LOGGER.debug("content : {}",content);

            return content;
        }).collect(Collectors.toList());


        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("搜索关键字[{}]结果 : {}",keywords,items);
        }

        return HttpResult.ok(items);
    }
}
