package com.sun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*访问地址 localhost:7002*/
@SpringBootApplication
@EnableEurekaServer  /*服务端启动类*/
public class EureKaApplication_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EureKaApplication_7002.class,args);
    }
}
