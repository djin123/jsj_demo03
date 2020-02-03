package cn.com.djin.jsj.test;

import cn.com.djin.jsj.dao.EmpDao;
import cn.com.djin.jsj.dao.impl.EmpDaoImpl;
import cn.com.djin.jsj.entity.Emp;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 *   员工dao层测试类
 */
public class EmpDaoTest {

    //定义员工dao层对象
    private EmpDao empDao = null;

    //每一次测试之前创建dao层对象
    @Before
    public void before(){
      //  empDao = (EmpDao) DaoFactory.getDaoInstance("empDao");
        empDao = new EmpDaoImpl();
    }

    //测试得到dao层对象
    @Test
    public void test01(){
        System.out.println(empDao);
    }

    //测试查询所有员工数据
    @Test
    public void test02(){
        try {
            List<Emp> emps = empDao.selAllEmp();
            for (Emp emp:emps){
                System.out.println(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
