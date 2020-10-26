package com.supergo.authorization.controller;

import com.supergo.common.http.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth2/clientdetails")
public class OAuth2ClientDetailsController {

    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(OAuth2ClientDetailsController.class);

    @Autowired
    @Qualifier("jdbcClientDetailsService")
    public ClientRegistrationService clientRegistrationService;

    @PostMapping
    public HttpResult addClientDetails(@RequestBody BaseClientDetails clientDetails){
        clientRegistrationService.addClientDetails(clientDetails);
        return HttpResult.ok("创建客户端信息成功...");
    }

    @PutMapping
    public HttpResult updateClientDetails(@RequestBody BaseClientDetails clientDetails){
        clientRegistrationService.updateClientDetails(clientDetails);
        return HttpResult.ok("更新客户端信息成功...");
    }

    @PostMapping("/secret")
    public HttpResult updateClientSecret(@RequestParam("id") String clientId, @RequestParam("secret") String secret){
        clientRegistrationService.updateClientSecret(clientId,secret);
        return HttpResult.ok("更新客户端密码成功...");
    }

    @DeleteMapping("/{id}")
    public HttpResult removeClientDetails(@PathVariable("id") String clientId){
        clientRegistrationService.removeClientDetails(clientId);
        return HttpResult.ok("删除客户端信息成功...");
    }

    @GetMapping
    public HttpResult listClientDetails(){
        return HttpResult.ok(clientRegistrationService.listClientDetails());
    }
}
