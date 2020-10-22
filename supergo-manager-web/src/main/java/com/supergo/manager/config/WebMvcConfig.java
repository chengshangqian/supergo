package com.supergo.manager.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 测试：通过实现WebMvcConfigurer接口的配置文件WebMvcConfig添加跨域配置..
 */
//@Configuration
//@ConditionalOnMissingBean(type="org.springframework.web.filter.CorsFilter")
public class WebMvcConfig implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebMvcConfig.class);

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("http://localhost","http://127.0.0.1","https://www.baidu.com");

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("通过实现WebMvcConfigurer接口的配置文件WebMvcConfig添加跨域配置..");
        }
    }
}
