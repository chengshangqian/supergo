package com.supergo.authorization;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorizationAppTest {

    @Autowired
    @Qualifier("jdbcClientDetailsService")
    public ClientRegistrationService clientRegistrationService;

    @Test
    void addClientDetailsTest(){
        // 超级购
        BaseClientDetails baseClientDetails = new BaseClientDetails();
        baseClientDetails.setClientId("supergo");
        baseClientDetails.setClientSecret("123456");
        baseClientDetails.setAuthorizedGrantTypes(Stream.of("authorization_code","password","refresh_token","client_credentials").collect(Collectors.toList()));
        baseClientDetails.setAccessTokenValiditySeconds(3600);
        baseClientDetails.setScope(Stream.of("supergo").collect(Collectors.toList()));
        clientRegistrationService.addClientDetails(baseClientDetails);

        // 门户
//        baseClientDetails.setClientId("supergo-portal-web");
//        clientRegistrationService.addClientDetails(baseClientDetails);

        // 商品服务
//        baseClientDetails.setClientId("supergo-googs-service");
//        clientRegistrationService.addClientDetails(baseClientDetails);
    }

    @Test
    void updateClientDetailsTest(){
        // 商品服务
        BaseClientDetails baseClientDetails = new BaseClientDetails();
        baseClientDetails.setClientId("supergo-googs-service");
        baseClientDetails.setAuthorizedGrantTypes(Stream.of("authorization_code","password","refresh_token","client_credentials").collect(Collectors.toList()));
        baseClientDetails.setScope(Stream.of("supergo").collect(Collectors.toList()));
        clientRegistrationService.updateClientDetails(baseClientDetails);

        // 门户
        baseClientDetails.setClientId("supergo-portal-web");
        clientRegistrationService.updateClientDetails(baseClientDetails);
    }
}