package com.sun.springcloud.service;

import com.sun.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    /*增加一条信息*/
    boolean addDept(Dept dept);
    /*按照id查询信息*/
    public Dept queryDeptById(Long id);
    /*查找所有的信息*/
    public List<Dept> queryAll();
    /*刪除信息*/
   public int deleteId(Long id);
   /*利用forEarch批量添加*/
   public int addIDs(List<String> dnames);
}
