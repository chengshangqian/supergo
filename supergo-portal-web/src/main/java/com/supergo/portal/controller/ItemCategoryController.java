package com.supergo.portal.controller;

import com.supergo.common.authorization.AuthorizationUtil;
import com.supergo.common.http.HttpResult;
import com.supergo.feign.clients.ItemCategoryServiceClient;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "商品分类")
@RequestMapping("/categories")
public class ItemCategoryController {
    // 日志
    public static final Logger LOGGER = LoggerFactory.getLogger(ItemCategoryController.class);

    @Autowired
    private ItemCategoryServiceClient itemCategoryServiceClient;

    @ApiOperation(value = "商品分类列表", notes = "获取所有商品分类列表")
    @ApiResponses(
            @ApiResponse(code = 200, message = "返回JSON格式的商品分类列表信息")
    )
    @GetMapping
    public HttpResult allItemCategories(@RequestHeader("Authorization") String authorization) {
        return itemCategoryServiceClient.allItemCategories(authorization);
    }
}
