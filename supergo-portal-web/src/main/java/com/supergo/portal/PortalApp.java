package com.supergo.portal;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages ={"com.supergo.feign.clients","com.supergo.portal"}) // 加载feign熔断用的Mock类
@EnableDiscoveryClient
@EnableFeignClients({"com.supergo.feign.clients"})  // 如果feign包不当前启动文件目录下，则需要额外指定
@Hystrix
@MapperScan("com.supergo.portal.mapper")
public class PortalApp {
    public static void main(String[] args) {
        SpringApplication.run(PortalApp.class,args);
    }
}
