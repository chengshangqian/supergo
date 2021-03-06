package com.supergo.zuul.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 请求的地址中协议、域名（含子域名）、端口号与当前所在域名有任一不一样，即为跨越
 */
@Configuration
@ConditionalOnProperty(value = "cors.enabled",havingValue = "true")
public class CorsConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(CorsConfig.class);

    @Bean
    //将允许跨域的Filter配置给网关
    public CorsFilter corsFilter() {
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();

        //配置允许跨域的规则开始

        //放行哪些原始域
        config.addAllowedOrigin("*"); //* : 允许任何网站访问
        //是否发送Cookie信息
        config.setAllowCredentials(true);
        // 放行哪些原始域（头部信息）
        config.addAllowedHeader("*");
        // 放行哪些原始域（请求方式）
        config.addAllowedMethod("*");
        // 暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
        //认证需要的自定义请求头需要暴露的请求头
        //config.addExposedHeader("X-Token");

        //配置允许跨域的规则结束

        //2.添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        //所有经过网关的请求都做添加跨域头处理
        configSource.registerCorsConfiguration("/**", config);
        //configSource.registerCorsConfiguration("/api/v1/m/**", config);
        //创建过滤器
        CorsFilter corsFilter = new CorsFilter(configSource);

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("通过Zuul网关统一配置跨域请求...");
        }

        return corsFilter;
    }
}
