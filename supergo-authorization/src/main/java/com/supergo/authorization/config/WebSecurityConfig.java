package com.supergo.authorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 授权服务应用本身的安全配置
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 对象HttpSecurity进行设置：配置认证授权规则、常见的安全漏洞等
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 认证授权规则
                .authorizeRequests(authorizeRequestsCustomizer -> authorizeRequestsCustomizer
                        .antMatchers("/actuator/**","/oauth2/clientdetails/**","/error").permitAll()
                        // 缺省所有请求需要认证
                        .anyRequest().authenticated()
                )

                // 关闭httpBasic，否则服务注册和发现刷新不了
                .httpBasic(httpSecurityHttpBasicConfigurer -> httpSecurityHttpBasicConfigurer.disable())

                // 关闭CSRF
                .csrf(csrfCustomizer -> csrfCustomizer.disable());
    }

    /**
     * AuthenticationManager管理认证授权，声明后交给OAuth2配置
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 密码编码器：认证时，用于对输入的密码进行编码，然后和数据库中的密码进行比较
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        // 长度16会很影响性能，可以使用默认10
        return new BCryptPasswordEncoder(12);
    }
}