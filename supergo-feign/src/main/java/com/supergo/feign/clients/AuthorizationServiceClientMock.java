package com.supergo.feign.clients;

import com.supergo.common.authorization.AccessToken;
import org.springframework.stereotype.Service;

/**
 * 熔断处理
 */
@Service
public class AuthorizationServiceClientMock implements AuthorizationServiceClient {

    @Override
    public AccessToken getJwtAccessToken(String clientDetailsAuthorization, String type, String username, String password) {
        return null;
    }
}
