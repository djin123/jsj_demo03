package cn.com.djin.jsj.dao;

import cn.com.djin.jsj.entity.Dept;

import java.util.List;

/**
 *   部门dao层接口
 */
public interface DeptDao {

    //查询所有部门
    List<Dept> selAllDept() throws Exception;
}
