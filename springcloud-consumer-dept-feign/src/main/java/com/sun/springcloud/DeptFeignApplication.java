package com.sun.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.sun.springcloud"})
//这个不需要加 ，加啦会报404
//@ComponentScan("com.sun.springcloud.service")
//访问地址http://localhost/dept/queryAll
public class DeptFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptFeignApplication.class,args);
        System.out.println("启动成功");
    }
}
