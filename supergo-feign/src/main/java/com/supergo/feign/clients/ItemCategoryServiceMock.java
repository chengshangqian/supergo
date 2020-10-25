package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Itemcat;
import org.springframework.stereotype.Service;

@Service
public class ItemCategoryServiceMock implements ItemCategoryServiceClient {

    @Override
    public HttpResult post(Itemcat itemcat) {
        return null;
    }

    @Override
    public HttpResult delete(Long id) {
        return null;
    }

    @Override
    public HttpResult put(Long id, Itemcat itemCategory) {
        return null;
    }

    @Override
    public HttpResult get(Long id) {
        return null;
    }

    @Override
    public HttpResult query(Integer page, Integer size, Itemcat itemCategory) {
        return null;
    }

    @Override
    public HttpResult allItemCategories() {
        return null;
    }

    @Override
    public HttpResult childItemCategories(Long id) {
        return null;
    }

    @Override
    public HttpResult cacheAllItemCategories() {
        return null;
    }
}
