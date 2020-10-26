package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Brand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "supergo-googs-service", fallback = BrandServiceMock.class)
public interface BrandServiceClient {
    @PostMapping("/brands")
    HttpResult post(@RequestHeader("Authorization") String authorization ,@RequestBody Brand brand);

    @DeleteMapping("/brands/{id}")
    HttpResult delete(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id);

    @PutMapping("/brands/{id}")
    HttpResult put(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id, @RequestBody Brand brand);

    @GetMapping("/brands/{id}")
    HttpResult get(@RequestHeader("Authorization") String authorization ,@PathVariable("id") Long id);

    @PostMapping("/brands/query/{page}/{size}")
    HttpResult query(@RequestHeader("Authorization") String authorization ,
                     @PathVariable(value = "page") Integer page,
                     @PathVariable(value = "size") Integer size,
                     @RequestBody Brand brand);
}
