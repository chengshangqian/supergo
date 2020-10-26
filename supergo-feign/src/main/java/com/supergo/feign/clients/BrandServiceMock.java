package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import com.supergo.pojo.Brand;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceMock implements BrandServiceClient {

    @Override
    public HttpResult post(String authorization, Brand brand) {
        return null;
    }

    @Override
    public HttpResult delete(String authorization, Long id) {
        return null;
    }

    @Override
    public HttpResult put(String authorization, Long id, Brand brand) {
        return null;
    }

    @Override
    public HttpResult get(String authorization, Long id) {
        return null;
    }

    @Override
    public HttpResult query(String authorization, Integer page, Integer size, Brand brand) {
        return null;
    }
}
