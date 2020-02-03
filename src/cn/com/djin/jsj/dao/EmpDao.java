package cn.com.djin.jsj.dao;

import cn.com.djin.jsj.entity.Emp;

import java.util.List;
import java.util.Map;

/**
 *   员工dao层接口
 */
public interface EmpDao {

    //查询所有员工数据
    List<Emp> selAllEmp() throws Exception;

    //根据主键empno查询单个员工数据
    Emp selEmpByEmpno(Integer empno) throws Exception;

    //根据工作和工资查询员工
    List<Emp> selEmpByJobAndSal(String job, Double sal) throws Exception;

    //添加员工数据
    Integer insEmp(Emp emp) throws Exception;

    //根据主键empno删除单个员工数据
    Integer delEmp(Integer empno) throws Exception;

    //根据员工编号进行修改员工其他数据
    Integer updEmp(Emp emp) throws Exception;

    //根据工资删除员工数据
    Integer delEmpBySal(Double sal) throws Exception;

    //根据员工姓名模糊收索和工资范围查询以及部门编号动态查询
    List<Emp> selEmpByPramas(Emp emp) throws Exception;

    //根据员工编号动态修改员工姓名和工资以及部门编号
    Integer updEmpByEmpno(Emp emp) throws Exception;

    //联表查询所有员工和其所在部门数据
    List<Map<String,Object>> selAllEmpAndDept() throws Exception;


}
