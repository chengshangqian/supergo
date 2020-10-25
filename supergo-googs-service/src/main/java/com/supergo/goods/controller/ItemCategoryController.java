package com.supergo.goods.controller;

import com.supergo.common.http.HttpResult;
import com.supergo.goods.service.ItemCategoryService;
import com.supergo.pojo.Itemcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @PostMapping
    public HttpResult post(@RequestBody Itemcat itemcat) {
        itemCategoryService.add(itemcat);
        return HttpResult.ok();
    }

    @DeleteMapping("/{id}")
    public HttpResult delete(@PathVariable("id") Long id) {
        itemCategoryService.deleteByIds(new Long[]{id});
        return HttpResult.ok();
    }

    @PutMapping("/{id}")
    public HttpResult put(@PathVariable("id") Long id, @RequestBody Itemcat itemCategory) {
        itemCategory.setId(id);
        itemCategoryService.add(itemCategory);
        return HttpResult.ok();
    }

    @GetMapping("/{id}")
    public HttpResult get(@PathVariable("id") Long id) {
        return HttpResult.ok(itemCategoryService.findOne(id));
    }

    @PostMapping("/query/{page}/{size}")
    public HttpResult query(@PathVariable(value = "page") Integer page,
                            @PathVariable(value = "size") Integer size,
                            @RequestBody Itemcat itemCategory) {
        return HttpResult.ok(itemCategoryService.findPage(page, size, itemCategory));
    }

    /**
     * 获取所有商品分类：用于商城门户，使用redis缓存
     *
     * @return
     */
    @GetMapping
    public HttpResult allItemCategories() {
        return HttpResult.ok(itemCategoryService.allItemCategories());
    }

    /**
     * 获取下一层商品分类 TODO allCategories已经缓存了所有的商品分类接口，这个接口是否还有必要
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}/children")
    public HttpResult childItemCategories(@PathVariable("id") Long id) {
        return HttpResult.ok(itemCategoryService.childItemCategories(id));
    }

    /**
     * 重新缓存所有商品分类：可用于更新redis中的缓存
     *
     * @return 返回最新的商品分类列表
     */
    @GetMapping(value = {"/cache", "/re-cache"})
    public HttpResult cacheAllItemCategories() {
        return HttpResult.ok(itemCategoryService.cacheAllItemCategories());
    }
}
