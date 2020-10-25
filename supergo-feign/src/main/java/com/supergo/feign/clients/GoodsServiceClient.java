package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "supergo-googs-service", fallback = GoodsServiceMock.class)
public interface GoodsServiceClient {
    @PostMapping("/goods")
    HttpResult post(@RequestBody Goods goods);

    @DeleteMapping("/goods/{id}")
    HttpResult delete(@PathVariable("id") Long id);

    @PutMapping("/goods/{id}")
    HttpResult put(@PathVariable("id") Long id, @RequestBody Goods goods);

    @GetMapping("/goods/{id}")
    HttpResult get(@PathVariable("id") Long id);

    @PostMapping("/goods/query/{page}/{size}")
    HttpResult query(@PathVariable(value = "page") Integer page,
                     @PathVariable(value = "size") Integer size,
                     @RequestBody Goods goods);

    @GetMapping("/goods/documents/build")
    HttpResult buildAllSearchDocuments();

    @RequestMapping(value = "/goods/search", method = {RequestMethod.GET, RequestMethod.POST})
    HttpResult search(@RequestParam("keyword") String keyword,
                             @RequestParam(value = "filters", required = false) String filterKeyValues,
                             @RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size);

}
