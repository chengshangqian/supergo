package com.supergo.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
@MapperScan({"com.supergo.mapper"})
//@EnableCaching //开启本地应用缓存
public class GoodsServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(GoodsServiceApp.class, args);
    }
}
