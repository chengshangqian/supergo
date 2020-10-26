package com.supergo.feign.clients;

import com.supergo.common.authorization.AccessToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 安全服务认证授权接口：作为授权服务器，同时提供认证服务
 */
@FeignClient(value = "supergo-authorization",fallback = AuthorizationServiceClientMock.class)
public interface AuthorizationServiceClient {
    /**
     * 申请授权：申请访问令牌
     *
     * @param clientDetailsAuthorization Authorization头部，携带的是被保护资源即用户服务(user-service)客户端在安全认证授权服务器上
     *                                       注册的认证信息，包括client_id和client_secret等,使用Http Basic认证方式
     *
     * @param type 授权类型
     * @param username 用户账号
     * @param password 用户密码
     * @return 访问令牌
     */
    @PostMapping("/oauth/token")
    AccessToken getJwtAccessToken(@RequestHeader("Authorization") String clientDetailsAuthorization
            , @RequestParam("grant_type") String type
            , @RequestParam("username") String username
            , @RequestParam("password") String password);
}
