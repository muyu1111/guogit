package com.sun.springcloud.controller;

import com.sun.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/*
 * 使用之前要保证服务者是启动的状态  消费者端口默认是8080
 * 消费者没有service层只需要去调用服务层的接口就行
 * */
@RestController
public class DeptConSuMerController {
    @Autowired
    RestTemplate restTemplate;
    /*访问路径的前缀(非负载均衡的情况下)*/
//    public static final String Rest_URl_RESFIX = "http://localhost:8001/";
      /*负载军星ribbon的情况下这个应该是一个变量 通过服务名进行访问*/
    public static final String Rest_URl_RESFIX = "http://SPRINGCLOUD-PROVIDER-DEPT/";
    /*消费者的访问路径*/
    @GetMapping("/guo/dept/queryAll")
    /*通过getForObject方法进行调用服务者的方法*/
    public List<Dept> getQueryAll() {
        /*list.class 对应的是方法的返回值类型*/
        return restTemplate.getForObject(Rest_URl_RESFIX + "dept/queryAll", List.class);
    }
    //有参形的
//    @GetMapping("/guo/dept/queryById/{id}")
//    public Dept queryById(@PathVariable("id") Long id) {
//        return restTemplate.getForObject(Rest_URl_RESFIX + "/dept/queryById/{id}",Dept.class,id);
//    }
//    @GetMapping("/guo/dept/queryById/{id}")
//    public Dept queryById(@PathVariable("id") Long id) {
//        return restTemplate.getForObject(Rest_URl_RESFIX + "/dept/queryById/{id}"+id,Dept.class);
//    }
    @GetMapping("/guo/dept/queryById")
    public Dept queryById(@RequestParam("id") Long id) {
        return restTemplate.getForObject(Rest_URl_RESFIX + "/dept/queryById/?id="+id,Dept.class);
    }



    @RequestMapping("/guo/dept/addIds")
    public int addDnames(@RequestBody String[] dnames) {
        return restTemplate.postForObject(Rest_URl_RESFIX + "/dept/addIds",dnames,int.class);
    }

    @RequestMapping("/guo/dept/addDept")
    public boolean addDept(@RequestBody Dept dept) {
        return restTemplate.postForObject(Rest_URl_RESFIX + "/dept/addDept",dept,Boolean.class);
    }

    @RequestMapping("/guo/deelteID/{id}")
    public int deleteId(@PathVariable("id") Long id) {
        restTemplate.delete(Rest_URl_RESFIX + "/dept/deelteID/{id}",id);
        return 1;
    }

}
