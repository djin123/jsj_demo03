package cn.com.djin.jsj.service;

import cn.com.djin.jsj.entity.Emp;

import java.util.List;
import java.util.Map;

/**
 *   员工业务层接口
 */
public interface EmpService {

    //查询所有员工数据
    List<Emp> findAllEmp() throws Exception;

    //查询所有员工以及所在部门数据
    List<Map<String,Object>> findAllEmpAndDept() throws Exception;

    //根据员工编号删除单个员工数据
    String removeEmpByEmpno(Integer empno) throws Exception;

    //添加员工数据
    String saveEmp(Emp emp) throws Exception;

    //修改员工数据
    String updEmp(Emp emp) throws Exception;

    //根据主键empno查询单个员工数据
    Emp findEmpByEmpno(Integer empno) throws Exception;

}
