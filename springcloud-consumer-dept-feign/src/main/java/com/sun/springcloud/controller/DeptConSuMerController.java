package com.sun.springcloud.controller;

import com.sun.springcloud.pojo.Dept;
import com.sun.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
 * 使用之前要保证服务者是启动的状态  消费者端口默认是8080
 * 消费者没有service层只需要去调用服务层的接口就行
 * */
@RestController
public class DeptConSuMerController {
    @Autowired
    private  DeptClientService service;
    //ribbon 的负载均衡
//    @Autowired
//    RestTemplate restTemplate;
    /*访问路径的前缀(非负载均衡的情况下)*/
//    public static final String Rest_URl_RESFIX = "http://localhost:8001/";
      /*负载军星ribbon的情况下这个应该是一个变量 通过服务名进行访问*/
//    public static final String Rest_URl_RESFIX = "http://SPRINGCLOUD-PROVIDER-DEPT/";
    /*消费者的访问路径*/
//    @GetMapping("/dept/queryAll")
    /*通过getForObject方法进行调用服务者的方法*/
    @GetMapping("/guo/dept/queryAll")
    public List<Dept> getQueryAll() {
//        /*list.class 对应的是方法的返回值类型*/    Ribbon 的负载均衡
//        return restTemplate.getForObject(Rest_URl_RESFIX + "dept/queryAll", List.class);

        /*这个是 feign 的负载均衡*/
        System.out.println("测试");

        return this.service.getQueryAll();
    }
    /*通过id 去获取 信息*/
    @GetMapping("/guo/dept/queryById")
    public Dept queryById(@RequestParam("id") long id){
        System.out.println("测试");
        return  this.service.queryDeptById(id);
    }
}
