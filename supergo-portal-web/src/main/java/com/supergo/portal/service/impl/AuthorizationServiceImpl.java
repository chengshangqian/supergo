package com.supergo.portal.service.impl;

import com.supergo.common.authorization.AccessToken;
import com.supergo.common.authorization.AuthorizationUtil;
import com.supergo.feign.clients.AuthorizationServiceClient;
import com.supergo.portal.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@RefreshScope // 刷新配置
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private AuthorizationServiceClient authorizationServiceClient;

    @Value("${app.security.oauth2.client-id}")
    private String clientId;

    @Value("${app.security.oauth2.client-secret}")
    private String clientSecret;

    @Value("${app.security.oauth2.authorization-type}")
    private String authorizationType;

    @Value("${app.security.oauth2.grant-type}")
    private String grantType;

    @Override
    public AccessToken authorize(String username, String password) {

        // 如果用户存在，将请求授权服务器，为登录的用户申请用户服务授权（jwt访问令牌）
        String clientDetails = String.format("%s:%s",clientId,clientSecret);
        String clientDetailsToken = Base64.getEncoder().encodeToString(clientDetails.getBytes(StandardCharsets.UTF_8));
        String clientDetailsAuthorization = AuthorizationUtil.authorization(clientDetailsToken,authorizationType); // 将用户服务授权信息封装为认证请求头部

        // 获取jwt访问令牌
        AccessToken accessToken = authorizationServiceClient.getJwtAccessToken(clientDetailsAuthorization,grantType,username,password);

        // 获取失败或服务不可用（熔断）
        if(accessToken == null){
            throw new RuntimeException("授权服务器异常...");
        }

        return accessToken;
    }
}
