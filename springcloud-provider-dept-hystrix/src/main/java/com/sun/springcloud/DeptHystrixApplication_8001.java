package com.sun.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.sun.springcloud.mapper")
@EnableEurekaClient  //服务启动后自动注入eureka中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //添加熔断的支持  CircuitBreaker  断路器
public class DeptHystrixApplication_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptHystrixApplication_8001.class, args);
    }
}
