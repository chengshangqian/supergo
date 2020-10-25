package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Itemcat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "supergo-googs-service", fallback = ItemCategoryServiceMock.class)
public interface ItemCategoryServiceClient {
    @PostMapping
    HttpResult post(@RequestBody Itemcat itemcat);

    @DeleteMapping("/categories/{id}")
    HttpResult delete(@PathVariable("id") Long id);

    @PutMapping("/categories/{id}")
    HttpResult put(@PathVariable("id") Long id, @RequestBody Itemcat itemCategory);

    @GetMapping("/categories/{id}")
    HttpResult get(@PathVariable("id") Long id);

    @PostMapping("/categories/query/{page}/{size}")
    HttpResult query(@PathVariable(value = "page") Integer page,
                     @PathVariable(value = "size") Integer size,
                     @RequestBody Itemcat itemCategory);

    @GetMapping("/categories")
    HttpResult allItemCategories();

    @GetMapping("/categories/{id}/children")
    HttpResult childItemCategories(@PathVariable("id") Long id);

    @GetMapping(value = {"/categories/cache", "/categories/re-cache"})
    HttpResult cacheAllItemCategories();
}
