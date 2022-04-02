package com.sun.springcloud.service.impl;

import com.sun.springcloud.mapper.DeptMapper;
import com.sun.springcloud.pojo.Dept;
import com.sun.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    public Dept queryDeptById(Long id) {
        return deptMapper.queryDeptById(id);
    }

    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }

    @Override
    public int deleteId(Long id) {
        return deptMapper.deleteId(id);
    }

    @Override
    public int addIDs(List<String> dnames) {
        return deptMapper.addIDs(dnames);
    }
}
