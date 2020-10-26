package com.supergo.portal.controller;

import com.supergo.common.authorization.AccessToken;
import com.supergo.common.http.HttpResult;
import com.supergo.portal.service.AuthorizationService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@SessionAttributes({"Portal-Access-Token"})
public class AuthorizationController {
    @Autowired
    private AuthorizationService authorizationService;

    /**
     * 用户认证：本地登录后，调用安全认证服务对登录用户进行认证授权，之后方可调用其它API资源
     *
     * @param username 用户账号
     * @param password 用户密码
     * @return 返回封装了认证用户信息的Http结果对象
     */
    @ApiOperation(value = "用户认证", notes = "账号密码认证授权接口，认证成功，将返回jwt访问令牌等认证信息")
    @ApiImplicitParams({
            @ApiImplicitParam( name = "username", value = "用户账号", required = true),
            @ApiImplicitParam( name = "password", value = "用户密码", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功，返回封装了认证用户信息的Http结果对象")
    })
    @PostMapping("/authorize")
    public HttpResult authorize(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        AccessToken accessToken = authorizationService.authorize(username, password);
        // 放入session
        model.addAttribute("Portal-Access-Token",accessToken);
        return HttpResult.ok(accessToken);
    }
}
