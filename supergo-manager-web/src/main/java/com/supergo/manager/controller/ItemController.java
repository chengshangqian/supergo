package com.supergo.manager.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.feign.clients.ItemServiceClient;
import com.supergo.pojo.Item;
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
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemServiceClient itemServiceClient;

    @ApiOperation(value="创建商品",notes = "创建一个新的商品")
    @ApiImplicitParams(
            @ApiImplicitParam(name="item",value = "JSON格式的商品对象信息，通过POST方法在请求体中提交",required = true)
    )
    @ApiResponses(
            @ApiResponse(code=200,message = "返回操作状态信息")
    )
    @PostMapping
    public HttpResult post(@RequestBody Item item,@RequestHeader("Authorization") String authorization){
        return itemServiceClient.post(authorization,item);
    }

    @ApiOperation(value="删除商品",notes = "根据商品id删除商品")
    @ApiImplicitParams(
            @ApiImplicitParam(name="id",value = "商品id",required = true)
    )
    @ApiResponses(
            @ApiResponse(code=200,message = "返回操作状态信息")
    )
    @DeleteMapping("/{id}")
    public HttpResult delete(@PathVariable("id") Long id,@RequestHeader("Authorization") String authorization){
        return itemServiceClient.delete(authorization,id);
    }

    @ApiOperation(value="更新商品",notes = "根据商品id更新商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "商品id",required = true),
            @ApiImplicitParam(name="item",value = "JSON格式的商品对象信息，通过PUT方法在请求体中提交",required = true)
    })
    @ApiResponses(
            @ApiResponse(code=200,message = "返回操作状态信息")
    )
    @PutMapping("/{id}")
    public HttpResult put(@PathVariable("id") Long id, @RequestBody Item item,@RequestHeader("Authorization") String authorization){
        return itemServiceClient.put(authorization,id,item);
    }

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
    @GetMapping("/{id}")
    public HttpResult get(@PathVariable("id") Long id, @RequestHeader("Authorization") String authorization) {
        return itemServiceClient.get(authorization,id);
    }

    @PostMapping("/query/{page}/{size}")
    public HttpResult query(@PathVariable(value = "page") Integer page,
                            @PathVariable(value = "size") Integer size,
                            @RequestBody Item item,
                            @RequestHeader("Authorization") String authorization){
        return itemServiceClient.query(authorization,page,size,item);
    }
}
