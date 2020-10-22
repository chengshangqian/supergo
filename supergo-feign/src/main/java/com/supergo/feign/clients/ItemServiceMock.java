package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceMock implements ItemServiceClient {
    @Override
    public HttpResult get(Integer id) {
        return null;
    }
}
