package cn.com.djin.jsj.dao.impl;

import cn.com.djin.jsj.dao.DeptDao;
import cn.com.djin.jsj.entity.Dept;
import cn.com.djin.jsj.util.JdbcDataSourseUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class DeptDaoImpl implements DeptDao {

    //引入QueryRunner对象，需要数据库连接池对象去构建
    private QueryRunner queryRunner = new QueryRunner(JdbcDataSourseUtil.getDataSource());

    @Override
    public List<Dept> selAllDept() throws Exception {
        return queryRunner.query("select * from dept",new BeanListHandler<Dept>(Dept.class));
    }
}
