package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Itemcat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "supergo-googs-service", fallback = ItemCategoryServiceMock.class)
public interface ItemCategoryServiceClient {
    @PostMapping
    HttpResult post(@RequestHeader("Authorization") String authorization ,@RequestBody Itemcat itemcat);

    @DeleteMapping("/categories/{id}")
    HttpResult delete(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id);

    @PutMapping("/categories/{id}")
    HttpResult put(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id, @RequestBody Itemcat itemCategory);

    @GetMapping("/categories/{id}")
    HttpResult get(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id);

    @PostMapping("/categories/query/{page}/{size}")
    HttpResult query(@RequestHeader("Authorization") String authorization ,
                     @PathVariable(value = "page") Integer page,
                     @PathVariable(value = "size") Integer size,
                     @RequestBody Itemcat itemCategory);

    @GetMapping("/categories")
    HttpResult allItemCategories(@RequestHeader("Authorization") String authorization);

    @GetMapping("/categories/{id}/children")
    HttpResult childItemCategories(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id);

    @GetMapping("/categories/cache")
    HttpResult cacheAllItemCategories(@RequestHeader("Authorization") String authorization);

    @GetMapping("/categories/re-cache")
    HttpResult reCacheAllItemCategories(@RequestHeader("Authorization") String authorization);
}
