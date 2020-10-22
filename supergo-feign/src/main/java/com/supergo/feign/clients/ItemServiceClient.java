package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "supergo-googs-service",fallback = ItemServiceMock.class)
public interface ItemServiceClient {
    @GetMapping("/items/{id}")
    HttpResult get(@PathVariable("id") Integer id);
}
