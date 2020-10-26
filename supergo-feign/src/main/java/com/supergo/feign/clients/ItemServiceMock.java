package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceMock implements ItemServiceClient {

    @Override
    public HttpResult post(String authorization, Item item) {
        return null;
    }

    @Override
    public HttpResult delete(String authorization, Long id) {
        return null;
    }

    @Override
    public HttpResult put(String authorization, Long id, Item item) {
        return null;
    }

    @Override
    public HttpResult get(String authorization, Long id) {
        return null;
    }

    @Override
    public HttpResult query(String authorization, Integer page, Integer size, Item item) {
        return null;
    }
}
