package com.supergo.goods.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.goods.service.ItemService;
import com.supergo.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public HttpResult post(@RequestBody Item item) {
        itemService.add(item);
        return HttpResult.ok();
    }

    @DeleteMapping("/{id}")
    public HttpResult delete(@PathVariable("id") Long id) {
        itemService.deleteByIds(new Long[]{id});
        return HttpResult.ok();
    }

    @PutMapping("/{id}")
    public HttpResult put(@PathVariable("id") Long id, @RequestBody Item item) {
        item.setId(id);
        itemService.add(item);
        return HttpResult.ok();
    }

    @GetMapping("/{id}")
    public HttpResult get(@PathVariable("id") Long id) {
        return HttpResult.ok(itemService.findOne(id));
    }

    @PostMapping("/query/{page}/{size}")
    public HttpResult query(@PathVariable(value = "page") Integer page,
                            @PathVariable(value = "size") Integer size,
                            @RequestBody Item item) {
        return HttpResult.ok(itemService.findPage(page, size, item));
    }
}
