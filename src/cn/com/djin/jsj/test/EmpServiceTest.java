package cn.com.djin.jsj.test;

import cn.com.djin.jsj.entity.Emp;
import cn.com.djin.jsj.service.EmpService;
import cn.com.djin.jsj.service.impl.EmpServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *   员工业务层测试类
 */
public class EmpServiceTest {

    //员工业务层对象
    private EmpService empService = null;

    @Before
    public void before(){
        empService = new EmpServiceImpl();
    }

    //测试查询所有员工
    @Test
    public void test01(){
        try {
            List<Emp>  emps = empService.findAllEmp();
            for (Emp emp:emps) {
                System.out.println(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //测试查询所有员工及其部门数据
    @Test
    public void test02(){
        try {
            //查询所有员工及其部门数据
            List<Map<String, Object>> empAndDepts = empService.findAllEmpAndDept();
            //对数据进行遍历
            for (Map<String,Object> empAndDept:empAndDepts) {
                //遍历Map集合
                Set<String> keySet = empAndDept.keySet();
                for (String key:keySet) {
                    System.out.print("key:"+key+" "+"value:"+empAndDept.get(key)+"  ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //测试删除单个员工
    @Test
    public void test03(){
        try {
            //执行删除操作
            String code = empService.removeEmpByEmpno(1011);
            //打印操作情况
            System.out.println(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //测试添加员工
    @Test
    public void test04(){
        //新建要被添加的员工
        Emp emp = new Emp();
        emp.setEname("赵六");
        emp.setJob("经理");
        emp.setMgr(1004);
        emp.setHiredate(new Date());
        emp.setSal(18900d);
        emp.setComm(1900d);
        emp.setDeptno(10);
        try {
            //执行添加
            String code = empService.saveEmp(emp);
            //打印操作结果
            System.out.println(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //测试员工业务层修改
    @Test
    public void test05(){
        //新建一个修改的员工对象
        Emp emp = new Emp();
        emp.setEmpno(1017);
        emp.setEname("小黑");
        emp.setSal(3300d);
        emp.setJob("司机");
        emp.setHiredate(new Date());
        emp.setMgr(1009);
        emp.setComm(900d);
        emp.setDeptno(30);
        try {
            //执行修改
            String code = empService.updEmp(emp);
            System.out.println(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
