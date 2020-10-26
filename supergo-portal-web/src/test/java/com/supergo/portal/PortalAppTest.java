package com.supergo.portal;

import com.supergo.common.authorization.AccessToken;
import com.supergo.common.authorization.AuthorizationUtil;
import com.supergo.common.http.HttpResult;
import com.supergo.feign.clients.GoodsServiceClient;
import com.supergo.portal.service.AuthorizationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PortalAppTest {

    // 打印日志
    private static final Logger LOGGER = LoggerFactory.getLogger(PortalAppTest.class);

    @Autowired
    private GoodsServiceClient goodsServiceClient;

    @Autowired
    private AuthorizationService authorizationService;

    private AccessToken userAccessToken;

    /**
     * 先获取访问令牌
     */
    @BeforeEach
    void authorize(){
        String username = "user_3";
        String password = "123456";
        userAccessToken = authorizationService.authorize(username, password);
    }

    @Test
    void findGoodsById(){
        // 登录后才能访问
        String accessToken = userAccessToken.getAccess_token();
        String authorization = AuthorizationUtil.bearerAuthorization(accessToken);
        Long id = 149187842868044L;
        HttpResult result = goodsServiceClient.get(authorization,id);
        LOGGER.debug("result => {}",result);
    }
}