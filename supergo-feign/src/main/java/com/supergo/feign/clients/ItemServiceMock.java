package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceMock implements ItemServiceClient {
    @Override
    public HttpResult post(Item item) {
        return null;
    }

    @Override
    public HttpResult delete(Long id) {
        return null;
    }

    @Override
    public HttpResult put(Long id, Item item) {
        return null;
    }

    @Override
    public HttpResult get(Long id) {
        return null;
    }

    @Override
    public HttpResult query(Integer page, Integer size, Item item) {
        return null;
    }
}
