package com.example.log.config;



import io.swagger.annotations.ApiOperation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2 配置
 * Created by pmdream on 2018/4/20.
 */
@Configuration
@EnableOpenApi
   // 相当于Spring配置中的<beans>
public class SwaggerConfig {
    @Bean   // 相当于Spring 配置中的<bean>
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
    // API基础信息定义（就是更新Swagger默认页面上的信息）
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档测试")
                .description("文档描述：更多问题，请联系开发者")
                .contact(new Contact("xsge123（name）", "作者网站(url)", "1511868921@qq.com(email)"))
                .version("1.0")
                .build();
    }


}