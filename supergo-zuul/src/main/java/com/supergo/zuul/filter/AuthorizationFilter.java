package com.supergo.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.supergo.common.http.HttpResult;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 认证请求头部信息校验拦截: 登录验证
 */
@Component
public class AuthorizationFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        //获得当前请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        String servletPath = context.getRequest().getServletPath();

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("接收到请求 => {}",servletPath);
        }

        // api文档和应用监控的除外
        if(servletPath.contains("/v3/api-docs") || servletPath.contains("/actuator/")){
            return null;
        }

        // 管理后台和门户进行权限请求头验证
        if(servletPath.startsWith("/api/v1/m/") || servletPath.startsWith("/api/v1/p/")){

            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("开始检查认证请求头...");
            }

            // 获取认证请求头
            String authorization = context.getRequest().getHeader("Authorization");

            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("authorization => {}",authorization);
            }

            // 如果存在认证授权请求头信息,则放行
            if(!StringUtils.isEmpty(authorization)){
                if (LOGGER.isDebugEnabled()){
                    LOGGER.debug("已发现认证请求头authorization => {},继续执行路由...",authorization);
                }
                return null;
            }

            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("缺少认证请求头authorization,将停止执行路由...");
            }

            //设置是否转发zuul请求
            context.setSendZuulResponse(false);
            //设置返回给Client的响应体
            context.getResponse().setContentType("application/json;charset=utf-8");
            HttpResult result = new HttpResult();
            result.setCode(HttpStatus.SC_SERVICE_UNAVAILABLE);
            result.setMessage("您还没有登录...");

            //使用json工具类转换为json字符串
            String json = JSON.toJSONString(result);
            //将json发送给Client
            context.setResponseBody(json);
        }

        return null;
    }
}