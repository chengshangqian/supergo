package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "supergo-googs-service", fallback = ItemServiceMock.class)
public interface ItemServiceClient {
    @PostMapping("/items")
    HttpResult post(@RequestHeader("Authorization") String authorization ,@RequestBody Item item);

    @DeleteMapping("/items/{id}")
    HttpResult delete(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id);

    @PutMapping("/items/{id}")
    HttpResult put(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id, @RequestBody Item item);

    @GetMapping("/items/{id}")
    HttpResult get(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id);

    @PostMapping("/items/query/{page}/{size}")
    HttpResult query(@RequestHeader("Authorization") String authorization ,
                     @PathVariable(value = "page") Integer page,
                     @PathVariable(value = "size") Integer size,
                     @RequestBody Item item);
}
