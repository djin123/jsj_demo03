package cn.com.djin.jsj.service.impl;

import cn.com.djin.jsj.dao.DeptDao;
import cn.com.djin.jsj.entity.Dept;
import cn.com.djin.jsj.service.DeptService;
import cn.com.djin.jsj.util.DaoFactory;

import java.util.List;

/**
 *   部门业务层实现类
 */
public class DeptServiceImpl implements DeptService {

    //依赖部门dao层对象
    private DeptDao deptDao = (DeptDao) DaoFactory.getDaoInstance("deptDao");

    @Override
    public List<Dept> findAllDept() throws Exception {
        return deptDao.selAllDept();
    }
}
