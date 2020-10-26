package com.supergo.goods.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer // 开启资源服务器
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启全局方法安全认证配置
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // 定义资源id
        resources.resourceId("supergo-googs-service").tokenStore(tokenStore);
    }

    /**
     * 对象HttpSecurity进行设置：配置认证授权规则、常见的安全漏洞等
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                // 认证授权规则
                .authorizeRequests(authorizeRequestsCustomizer -> authorizeRequestsCustomizer
                        //.anyRequest().permitAll()
                        // 应用监控不需要认证
                        .antMatchers("/actuator/**").permitAll()
                        // 其它请求需要认证
                        .anyRequest().authenticated()
                )

                // 关闭CSRF
                .csrf(csrfCustomizer -> csrfCustomizer.disable());
    }

    /**
     * 密码编码器：认证时，用于对输入的密码进行编码，然后和数据库中的密码进行比较
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 长度16会很影响性能，可以使用默认10
        return new BCryptPasswordEncoder(12);
    }
}
