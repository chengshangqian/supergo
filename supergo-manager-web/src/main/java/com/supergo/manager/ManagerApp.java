package com.supergo.manager;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages ={"com.supergo.feign.clients","com.supergo.manager"}) // 加载feign熔断用的Mock类
@EnableDiscoveryClient
@EnableFeignClients({"com.supergo.feign.clients"})  // 如果feign包不当前启动文件目录下，则需要额外指定
@Hystrix
public class ManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApp.class,args);
    }
}
