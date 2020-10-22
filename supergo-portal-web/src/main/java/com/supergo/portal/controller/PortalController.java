package com.supergo.portal.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.feign.clients.ItemcatServiceClient;
import com.supergo.portal.dao.ItemRepository;
import com.supergo.portal.entity.Item;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "商品分类")
public class PortalController {
    @Autowired
    private ItemcatServiceClient itemcatServiceClient;

    @Autowired
    private ItemRepository itemRepository;

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
    @GetMapping("/items")
    public HttpResult items(@RequestParam("keywords") String keywords) {
        // TODO
        Iterable<Item> items = itemRepository.findByItemNameLikeOrItemDescLike(keywords);
        return HttpResult.ok(items);
    }
}
