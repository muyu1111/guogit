package com.sun.springcloud.service;


import com.sun.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
//@Component
// fallbackFactory 通过这个去指定服务降级
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @GetMapping("/dept/queryAll")
    List<Dept> getQueryAll();
    /*按照id查询信息*/
    @GetMapping("/dept/queryById")
    public Dept queryDeptById(@RequestParam("id")Long id);
}
