package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Brand;

public class BrandServiceMock implements BrandServiceClient {
    @Override
    public HttpResult post(Brand brand) {
        return null;
    }

    @Override
    public HttpResult delete(Long id) {
        return null;
    }

    @Override
    public HttpResult put(Long id, Brand brand) {
        return null;
    }

    @Override
    public HttpResult get(Long id) {
        return null;
    }

    @Override
    public HttpResult query(Integer page, Integer size, Brand brand) {
        return null;
    }
}
