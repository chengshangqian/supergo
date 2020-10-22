package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "supergo-googs-service",fallback = ItemcatServiceMock.class)
public interface ItemcatServiceClient {
    @GetMapping("/itemcats")
    HttpResult categories();
}
