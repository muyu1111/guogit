package com.example.log.controller;

import com.example.log.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "测试SwaggerAPI Annotation", tags = "Swagger测试之用户信息管理API")
@RestController
@RequestMapping("/user")
public class SwaggerController {

    @ApiIgnore    // 忽略这个API
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/swaggerGet/{name}")
    @ApiOperation(value = "接口方法说明", notes = "接口的详情描述")
    @ApiImplicitParam(name = "name", value = "请传递一个用户名参数",required = true, dataType = "String", paramType = "path")
    public String swaggerGet1(@PathVariable String name) {
        return "name="+name;
    }

    @PostMapping(value = "/swaggerPost")
    @ApiOperation(value = "新增用户", notes = "Swagger测试RESTful之POST请求测试入参一个POJO（JSON格式）")
    public User swaggerGet2(@RequestBody User user) {
        return user;
    }
    @GetMapping("/getById")
    @ApiOperation(httpMethod = "GET", value = "根据主键获取数据", response = Response.class, responseContainer = "Response", tags = {"组信息"})
    @ApiImplicitParam(name = "id", value = "主键id")
    public Long swaggerGet3(@RequestParam Long id) {
        return id*333;
    }

}