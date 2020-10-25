package com.supergo.goods.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.goods.service.GoodsService;
import com.supergo.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping
    public HttpResult post(@RequestBody Goods goods){
        goodsService.add(goods);
        return HttpResult.ok();
    }

    @DeleteMapping("/{id}")
    public HttpResult delete(@PathVariable("id") Long id){
        goodsService.deleteByIds(new Long[]{id});
        return HttpResult.ok();
    }

    @PutMapping("/{id}")
    public HttpResult put(@PathVariable("id") Long id,@RequestBody Goods goods){
        goods.setId(id);
        goodsService.add(goods);
        return HttpResult.ok();
    }

    @GetMapping("/{id}")
    public HttpResult get(@PathVariable("id") Long id){
        return HttpResult.ok(goodsService.findOne(id));
    }

    @PostMapping("/query/{page}/{rows}")
    public HttpResult query(@PathVariable(value = "page") Integer page,
                                 @PathVariable(value = "rows") Integer rows,
                                 @RequestBody Goods goods){
        goods.setIsDelete("0");
        goods.setIsMarketable("1");

        return HttpResult.ok(goodsService.query(page,rows,goods));
    }
}
