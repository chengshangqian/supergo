package com.supergo.goods.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.goods.service.ItemService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public HttpResult get(@PathVariable("id") Integer id){
        return HttpResult.ok(itemService.findOne(id));
    }
}
