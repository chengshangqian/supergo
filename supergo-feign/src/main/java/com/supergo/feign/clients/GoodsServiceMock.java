package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Goods;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceMock implements GoodsServiceClient {

    @Override
    public HttpResult post(String authorization, Goods goods) {
        return null;
    }

    @Override
    public HttpResult delete(String authorization, Long id) {
        return null;
    }

    @Override
    public HttpResult put(String authorization, Long id, Goods goods) {
        return null;
    }

    @Override
    public HttpResult get(String authorization, Long id) {
        return null;
    }

    @Override
    public HttpResult query(String authorization, Integer page, Integer size, Goods goods) {
        return null;
    }

    @Override
    public HttpResult buildAllSearchDocuments(String authorization) {
        return null;
    }

    @Override
    public HttpResult getSearch(String authorization, String keyword, String filterKeyValues, int page, int size) {
        return null;
    }

    @Override
    public HttpResult postSearch(String authorization, String keyword, String filterKeyValues, int page, int size) {
        return null;
    }
}
