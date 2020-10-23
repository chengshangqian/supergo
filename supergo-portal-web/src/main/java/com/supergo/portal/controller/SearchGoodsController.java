package com.supergo.portal.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.portal.entity.SearchResult;
import com.supergo.portal.service.SearchGoodsService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(tags = "商品搜索")
@RequestMapping("/goods")
public class SearchGoodsController {
    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchGoodsController.class);

    @Autowired
    private SearchGoodsService searchGoodsService;

    @ApiOperation(value="导入商品信息到ES",notes = "将数据库中的商品初始化到ES中，为后续搜索建立查询基础")
    @GetMapping("/import")
    public void importAllGoods(){
        searchGoodsService.importAllGoods();
    }

    @ApiOperation(value="搜索商品",notes = "根据关键字搜索商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="keyword",value = "搜索关键字"),
            @ApiImplicitParam(name="filter",value = "ES布尔查询过滤器",required = false),
            @ApiImplicitParam(name="page",value = "分页页数",defaultValue = "0"),
            @ApiImplicitParam(name="size",value = "分页大小",defaultValue = "10")
    })
    @PostMapping("/search")
    public HttpResult search(@RequestParam("keyword") String keyword,
                             @RequestParam(value = "filter",required = false) Map<String,String> filter,
                             @RequestParam(value = "page",defaultValue = "0") int page,
                             @RequestParam(value = "size",defaultValue = "10") int size){
        return HttpResult.ok(searchGoodsService.search(keyword,filter,PageRequest.of(page,size)));
    }

    @ApiOperation(value="搜索关联商品",notes = "根据关键字搜索商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="keyword",value = "搜索关键字")
    })
    @GetMapping("/search")
    public HttpResult search(@RequestParam("keyword") String keyword){
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("搜索关键字: {}", keyword);
        }
        return HttpResult.ok(searchGoodsService.search(keyword,null,PageRequest.of(0,10)));
    }
}
