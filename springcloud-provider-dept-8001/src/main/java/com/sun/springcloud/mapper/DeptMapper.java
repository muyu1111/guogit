package com.sun.springcloud.mapper;

import com.sun.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    /*增加一条信息*/
    boolean addDept(Dept dept);
    /*按照id查询信息*/
    public Dept queryDeptById(Long id);
    /*查找所有的信息*/
    public List<Dept> queryAll();
    /*刪除信息*/
    int deleteId(Long id);
    /*利用forEarch批量添加*/
    public int addIDs(List<String> dnames);
}
