package com.supergo.feign.clients;

import com.supergo.common.http.HttpResult;
import org.springframework.stereotype.Service;

@Service
public class ItemcatServiceMock implements ItemcatServiceClient {
    @Override
    public HttpResult categories() {
        return null;
    }
}
