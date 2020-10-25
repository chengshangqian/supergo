package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Goods;

public class GoodsServiceMock implements GoodsServiceClient {
    @Override
    public HttpResult post(Goods goods) {
        return null;
    }

    @Override
    public HttpResult delete(Long id) {
        return null;
    }

    @Override
    public HttpResult put(Long id, Goods goods) {
        return null;
    }

    @Override
    public HttpResult get(Long id) {
        return null;
    }

    @Override
    public HttpResult query(Integer page, Integer size, Goods goods) {
        return null;
    }

    @Override
    public HttpResult buildAllSearchDocuments() {
        return null;
    }

    @Override
    public HttpResult search(String keyword, String filterKeyValues, int page, int size) {
        return null;
    }
}
