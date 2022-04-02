package com.sun.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@Accessors(chain = true) //链式写法
/*链式写法
* Dept dept = new Dept();
* dept.setDeptno(222).setDbsource(1)........
* */
public class Dept implements Serializable { //实体类序列化
    /*主键*/
    private Long deptno;
    /*部门名称*/
    private String dname;
    /*表号*/
    private String dbSource;
}
