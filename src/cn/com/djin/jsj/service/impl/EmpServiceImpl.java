package cn.com.djin.jsj.service.impl;

import cn.com.djin.jsj.dao.EmpDao;
import cn.com.djin.jsj.entity.Emp;
import cn.com.djin.jsj.service.EmpService;
import cn.com.djin.jsj.util.DaoFactory;

import java.util.List;
import java.util.Map;

/**
 *   员工业务层实现类
 */
public class EmpServiceImpl implements EmpService {

    //依赖员工dao层对象
    //private EmpDao empDao = new EmpDaoImpl();
    private EmpDao empDao = (EmpDao) DaoFactory.getDaoInstance("empDao");

    //查询所有员工数据
    @Override
    public List<Emp> findAllEmp() throws Exception {
        return empDao.selAllEmp();
    }

    //查询所有员工以及所在部门数据
    @Override
    public List<Map<String, Object>> findAllEmpAndDept() throws Exception {
        return empDao.selAllEmpAndDept();
    }

    //根据员工编号删除单个员工数据
    @Override
    public String removeEmpByEmpno(Integer empno) throws Exception {
        if(empDao.delEmp(empno)>0){
            return "delSuccess";
        }else {
            return "delFail";
        }
    }

    //添加员工数据
    @Override
    public String saveEmp(Emp emp) throws Exception {
        if(empDao.insEmp(emp)>0){
            return "insSuccess";
        }else {
            return "insFail";
        }
    }

    //修改员工数据
    @Override
    public String updEmp(Emp emp) throws Exception {
        if(empDao.updEmp(emp)>0){
            return "updSuccess";
        }else {
            return "updFail";
        }
    }

    //根据主键empno查询单个员工数据
    @Override
    public Emp findEmpByEmpno(Integer empno) throws Exception {
        return empDao.selEmpByEmpno(empno);
    }
}
