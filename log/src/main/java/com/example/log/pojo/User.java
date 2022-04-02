package com.example.log.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户信息实体类")
@Data
public class User {

    @ApiModelProperty(value = "用户名",dataType="String",name="username",example="xsge")
    private String username;
    @ApiModelProperty(value = "账户密码",dataType="String",name="password",example="123456")
    private String password;

}