package com.supergo.manager.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.feign.clients.ItemServiceClient;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// 允许跨域请求
//@CrossOrigin(
//        value = {"http://localhost", "http://127.0.0.1"},
//        maxAge = 1800,
//        allowedHeaders = "*",
//        methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.HEAD,
//                RequestMethod.OPTIONS, RequestMethod.PATCH, RequestMethod.POST,
//                RequestMethod.PUT,RequestMethod.TRACE})
@Api(tags = "商品管理(SKU)")
public class ManagerController {

    @Autowired
    private ItemServiceClient itemServiceClient;

    // 允许跨域请求
//    @CrossOrigin(
//        value = {"http://localhost", "http://127.0.0.1"},
//        maxAge = 1800,
//        allowedHeaders = "*",
//        methods = {RequestMethod.GET})
    @ApiOperation(value="商品详情",notes = "根据商品id获取商品详情")
    @ApiImplicitParams(
            @ApiImplicitParam(name="id",value = "商品id",required = true)
    )
    @ApiResponses(
            @ApiResponse(code=200,message = "返回JSON格式的商品对象信息")
    )
    @GetMapping("/items/{id}")
    public HttpResult get(@PathVariable("id") Integer id) {
        return itemServiceClient.get(id);
    }
}
