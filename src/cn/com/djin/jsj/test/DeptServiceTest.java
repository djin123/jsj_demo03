package cn.com.djin.jsj.test;

import cn.com.djin.jsj.entity.Dept;
import cn.com.djin.jsj.service.DeptService;
import cn.com.djin.jsj.service.impl.DeptServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 *   员工业务层测试类
 */
public class DeptServiceTest {

    //员工业务层对象
    private DeptService deptService = null;

    @Before
    public void before(){
        deptService = new DeptServiceImpl();
    }

    //测试查询所有部门
    @Test
    public void test01(){
        try {
            List<Dept> depts = deptService.findAllDept();
            for (Dept dept:depts) {
                System.out.println(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
