package cn.com.djin.jsj.service;

import cn.com.djin.jsj.entity.Dept;

import java.util.List;

/**
 *   部门业务层接口
 */
public interface DeptService {

    //查询所有部门
    List<Dept> findAllDept() throws Exception;
}
