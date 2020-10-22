package com.supergo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
//zuul网关过滤器 =>继承zuulFilter抽象类即可
public class RequestCounterFilter extends ZuulFilter {
    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestCounterFilter.class);

    private AtomicLong requestCounter = new AtomicLong(0L);

    @Override
    /*
        返回过滤器的类型
        pre: 在路由之前执行过滤器代码
        route: 在路由过程中执行过滤器代码
        post: 在路由之后执行过滤器代码
        error: 在路由出现错误时执行过滤器代码
     */
    public String filterType() {
        return "post";
    }

    @Override
    /*
        指定当前过滤器在过滤器链中的位置,(数字越小执行的优先级越高)
     */
    public int filterOrder() {
        return 0;
    }

    @Override
    /*
     过滤器开关
     */
    public boolean shouldFilter() {
        //逻辑代码,判断是否要开启当前过滤器
        // 开启 return true;
        // 禁用 return false;
        return true;
    }

    @Override
    //过滤器代码书写位置
    public Object run() throws ZuulException {

        requestCounter.incrementAndGet();

        if(LOGGER.isDebugEnabled()){
            String messageFormat = "当前已经转发请求[{}] => {}";
            LOGGER.debug(messageFormat,requestCounter.get(),RequestContext.getCurrentContext().getRequest().getRequestURL());
        }

      /*  //不放行

        //获得当前请求上下文
        RequestContext context = RequestContext.getCurrentContext();

        //设置是否转发zuul请求
        context.setSendZuulResponse(false);
        //设置返回给Client的状态码
        context.setResponseStatusCode(HttpStatus.SC_SERVICE_UNAVAILABLE);
        //设置返回给Client的响应体
       *//* context.getResponse().setContentType("text/html;charset=utf-8");
        context.setResponseBody("<font color='red' size='5' >您还没有登录!</font>");*//*
        context.getResponse().setContentType("application/json;charset=utf-8");

        HttpResult result = new HttpResult();
        result.setCode(HttpStatus.SC_SERVICE_UNAVAILABLE);
        result.setMsg("您还没有登录!");

        //使用json工具类转换为json字符串
        String json = JSON.toJSONString(result);
        //将json发送给Client
        context.setResponseBody(json);*/

        //什么也不做 => 放行
        return null;
    }
}
