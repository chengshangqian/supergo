package com.supergo.manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Api(tags = "首页")
public class IndexController {
    /**
     * 首页：测试
     *
     * @return 欢迎信息
     */
    @ApiOperation(value="欢迎首页",notes = "商城欢迎首页")
    @RequestMapping({"","index","index.html","index.htm","index.do"})
    public String index(){
        return "Welcome to SuperGo!";
    }
}
