package com.supergo.zuul.hystrix;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractServiceMock implements FallbackProvider {
    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractServiceMock.class);

    /**
     * 返回需要配置熔断功能的路由服务
     *
     * @return
     */
    @Override
    public String getRoute() {
        // 返回具体的serviceId，如果是所有路由服务配置熔断功能，返回字符串*即可
        return route();
    }

    public abstract String route();

    /**
     * 可以根据异常类型动态决定处理方式。
     *
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("{}服务熔断...",getRoute());
        }

        // 判断异常类型：按照实际业务进行开发
        if (cause instanceof NullPointerException) {
            List<Map<String, Object>> result = new ArrayList<>();
            Map<String, Object> data = new HashMap<>();
            data.put("message", "网关超时，请稍后重试");
            result.add(data);

            ObjectMapper mapper = new ObjectMapper();

            String msg = "";
            try {
                msg = mapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                msg = "";
            }

            return ClientHttpResponseFactory.clientHttpResponse(HttpStatus.GATEWAY_TIMEOUT,
                    msg, "application", "json", "utf-8");
        }
        // 缺省：也是早期版本的实现方式，统统只有一个处理，不够灵活
        else {
            return fallbackResponse();
        }
    }

    /**
     * fallback逻辑。在早期版本中使用。
     * Edgware版本之后，ZuulFallbackProvider接口过期，提供了新的子接口FallbackProvider
     * 子接口中提供了方法ClientHttpResponse fallbackResponse(Throwable cause)。
     * 优先调用子接口新定义的fallback处理逻辑。
     */
    public ClientHttpResponse fallbackResponse() {

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("{}服务熔断，进入缺省的处理响应...",getRoute());
        }

        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> data = new HashMap<>();
        data.put("message", "服务正忙，请稍后重试");
        result.add(data);

        ObjectMapper mapper = new ObjectMapper();

        String msg = "";
        try {
            msg = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            msg = "";
        }

        return ClientHttpResponseFactory.clientHttpResponse(HttpStatus.OK, msg,
                "application", "json", "utf-8");
    }
}
