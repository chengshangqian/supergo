package com.supergo.portal.controller;

import com.supergo.common.authorization.AuthorizationUtil;
import com.supergo.common.http.HttpResult;
import com.supergo.feign.clients.GoodsServiceClient;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "商品搜索")
@RequestMapping("/goods")
public class GoodsSearchController {
    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsSearchController.class);

    @Autowired
    private GoodsServiceClient goodsServiceClient;

    @ApiOperation(value = "导入商品信息到ES", notes = "将数据库中的商品初始化到ES中，为后续搜索建立查询基础")
    @GetMapping("/documents/build")
    public HttpResult buildAllSearchDocuments(@RequestHeader("Authorization") String authorization) {
        return goodsServiceClient.buildAllSearchDocuments(authorization);
    }

    @ApiOperation(value = "搜索商品", notes = "根据关键字和过滤条件搜索商品列表",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "搜索关键字"),
            @ApiImplicitParam(name = "filters", value = "查询过滤条件，将被转化为ES的布尔查询过滤条件", required = false),
            @ApiImplicitParam(name = "page", value = "分页页数", defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "分页大小", defaultValue = "10")
    })
    @GetMapping("/search")
    public HttpResult getSearch(@RequestParam("keyword") String keyword,
                             @RequestParam(value = "filters", required = false) String filters,
                             @RequestParam(value = "page", defaultValue = "0") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                                @RequestHeader("Authorization") String authorization) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("搜索关键字keyword: {}", keyword);
            LOGGER.debug("搜索过滤条件filters: {}", filters);
            LOGGER.debug("搜索结果页数page: {}", page);
            LOGGER.debug("搜索结果页大小size: {}", size);
        }

        return HttpResult.ok(goodsServiceClient.getSearch(authorization, keyword, filters, page, size));
    }

    @ApiOperation(value = "搜索商品", notes = "根据关键字和过滤条件搜索商品列表",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "搜索关键字"),
            @ApiImplicitParam(name = "filters", value = "查询过滤条件，将被转化为ES的布尔查询过滤条件", required = false),
            @ApiImplicitParam(name = "page", value = "分页页数", defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "分页大小", defaultValue = "10")
    })
    @PostMapping("/search")
    public HttpResult postSearch(@RequestParam("keyword") String keyword,
                             @RequestParam(value = "filters", required = false) String filters,
                             @RequestParam(value = "page", defaultValue = "0") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                                 @RequestHeader("Authorization") String authorization) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("搜索关键字keyword: {}", keyword);
            LOGGER.debug("搜索过滤条件filters: {}", filters);
            LOGGER.debug("搜索结果页数page: {}", page);
            LOGGER.debug("搜索结果页大小size: {}", size);
        }

        return HttpResult.ok(goodsServiceClient.postSearch(authorization, keyword, filters, page, size));
    }

    @ApiOperation(value = "商品详情", notes = "根据商品id获取商品详情",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id")
    })
    @GetMapping("/{id}")
    public HttpResult get(@PathVariable("id") Long id, @RequestHeader("Authorization") String authorization){

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("authorization: {}", authorization);
        }

        return HttpResult.ok(goodsServiceClient.get(authorization,id));
    }
}
