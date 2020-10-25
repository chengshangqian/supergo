package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Brand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "supergo-googs-service", fallback = BrandServiceMock.class)
public interface BrandServiceClient {
    @PostMapping("/brands")
    HttpResult post(@RequestBody Brand brand);

    @DeleteMapping("/brands/{id}")
    HttpResult delete(@PathVariable("id") Long id);

    @PutMapping("/brands/{id}")
    HttpResult put(@PathVariable("id") Long id, @RequestBody Brand brand);

    @GetMapping("/brands/{id}")
    HttpResult get(@PathVariable("id") Long id);

    @PostMapping("/brands/query/{page}/{size}")
    HttpResult query(@PathVariable(value = "page") Integer page,
                     @PathVariable(value = "size") Integer size,
                     @RequestBody Brand brand);
}
