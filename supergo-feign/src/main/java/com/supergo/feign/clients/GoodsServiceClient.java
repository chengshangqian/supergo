package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "supergo-googs-service", fallback = GoodsServiceMock.class)
public interface GoodsServiceClient {
    @PostMapping("/goods")
    HttpResult post(@RequestHeader("Authorization") String authorization ,@RequestBody Goods goods);

    @DeleteMapping("/goods/{id}")
    HttpResult delete(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id);

    @PutMapping("/goods/{id}")
    HttpResult put(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id, @RequestBody Goods goods);

    @GetMapping("/goods/{id}")
    HttpResult get(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id);

    @PostMapping("/goods/query/{page}/{size}")
    HttpResult query(@RequestHeader("Authorization") String authorization ,
                     @PathVariable(value = "page") Integer page,
                     @PathVariable(value = "size") Integer size,
                     @RequestBody Goods goods);

    @GetMapping("/goods/documents/build")
    HttpResult buildAllSearchDocuments(@RequestHeader("Authorization") String authorization);

    @GetMapping("/goods/search")
    HttpResult getSearch(@RequestHeader("Authorization") String authorization ,
                         @RequestParam("keyword") String keyword,
                         @RequestParam(value = "filters", required = false) String filterKeyValues,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size);

    @PostMapping("/goods/search")
    HttpResult postSearch(@RequestHeader("Authorization") String authorization ,
                          @RequestParam("keyword") String keyword,
                          @RequestParam(value = "filters", required = false) String filterKeyValues,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size);

}
