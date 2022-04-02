package com.sun.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.sun.springcloud.mapper")
@EnableEurekaClient  //服务启动后自动注入eureka中
@EnableDiscoveryClient //服务发现
public class DeptApplication_8002 {
    public static void main(String[] args) {
        SpringApplication.run(DeptApplication_8002.class, args);
    }
}
