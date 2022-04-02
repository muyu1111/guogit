package com.sun.springcloud.service;


import com.sun.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/*失败回调的*/
/*降级*/
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public List<Dept> getQueryAll() {
                return null;
            }

            @Override
            public Dept queryDeptById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("id=>\"+id+\":信息无法找到，客户端提供降级服务，这个服务现在已经关闭了")
                        .setDbSource("no found database in MySQl");
            }
        };
    }
}
