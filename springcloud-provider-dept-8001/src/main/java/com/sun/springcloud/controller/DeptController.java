package com.sun.springcloud.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
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

@Controller
@RequestMapping("/dept")
@ResponseBody
public class DeptController {
    @Autowired
    DeptService deptService;
    @Autowired
    private DiscoveryClient client;

    @ApiOperation("添加一条信息")
    @PostMapping("/addDept")
    @ResponseBody
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @ApiOperation("根据id进行查询数据")
    @GetMapping("/queryById")
    public Dept queryById(@RequestParam("id") Long id) {
        return deptService.queryDeptById(id);
    }

    @ApiOperation("查询所有的数据")
    @GetMapping("/queryAll")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    @ApiOperation("根据ID删除数据")
    @DeleteMapping("/deelteID/{id}")
    public int deleteId(@PathVariable("id") Long id) {
        return deptService.deleteId(id);
    }

    @ApiOperation("批量添加数据")
    @PostMapping("/addIds")
    public int addDnames( @RequestBody String[] dnames) {

        List<String> list = Arrays.asList(dnames);
        return deptService.addIDs(list);
    }


    /*注册进来的微服务 获取一些信息*/
    @GetMapping("/discovery")
    public Object discovery() {
        //获取微服务列表清单
        List<String> services = client.getServices();
        System.out.println("client=> services:" + services);
        //获取具体的微服务信息，通过具体的微服务 通过 id
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost() + "," + instance.getPort()
                    + "," + instance.getServiceId() + "," + instance.getUri());
        }
        return this.client;
    }
}
