package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Itemcat;
import org.springframework.stereotype.Service;

@Service
public class ItemCategoryServiceMock implements ItemCategoryServiceClient {

    @Override
    public HttpResult post(String authorization, Itemcat itemcat) {
        return null;
    }

    @Override
    public HttpResult delete(String authorization, Long id) {
        return null;
    }

    @Override
    public HttpResult put(String authorization, Long id, Itemcat itemCategory) {
        return null;
    }

    @Override
    public HttpResult get(String authorization, Long id) {
        return null;
    }

    @Override
    public HttpResult query(String authorization, Integer page, Integer size, Itemcat itemCategory) {
        return null;
    }

    @Override
    public HttpResult allItemCategories(String authorization) {
        return null;
    }

    @Override
    public HttpResult childItemCategories(String authorization, Long id) {
        return null;
    }

    @Override
    public HttpResult cacheAllItemCategories(String authorization) {
        return null;
    }

    @Override
    public HttpResult reCacheAllItemCategories(String authorization) {
        return null;
    }
}
