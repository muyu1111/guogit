package com.sun.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    /*配置负载均衡 restTemplate*/
    /*
    * AvailabilityFilteringRule:先过滤掉，跳闸的服务  对剩下的进行轮询操作
    * RoundRobinRule：轮询操作
    * RandomRule:随机
    * RetryRule：会先按照轮询获取服务  如果服务获取失败 则会在指定的时间内进行重试
    * */
    @Bean
    @LoadBalanced  //ribbon
    public RestTemplate getRestTmplate (){
        return new RestTemplate();
    }
}
