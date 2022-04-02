package com.sun.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.springcloud.pojo.Dept;
import com.sun.springcloud.service.DeptService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/dept")
@ResponseBody
public class DeptController {
    @Autowired
    private DeptService service;

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = service.queryDeptById(id);
        if (dept == null)
            throw new RuntimeException("id=>" + id + ":信息无法找到");
        return dept;
    }

    /*备选方案*/
    public Dept hystrixGet(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("id=>\"+id+\":信息无法找到")
                .setDbSource("no found database in MySQl");
    }
}
