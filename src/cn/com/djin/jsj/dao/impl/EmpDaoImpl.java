package cn.com.djin.jsj.dao.impl;

import cn.com.djin.jsj.dao.EmpDao;
import cn.com.djin.jsj.entity.Emp;
import cn.com.djin.jsj.util.JdbcDataSourseUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.util.List;
import java.util.Map;

/**
 *   员工dao层实现类
 */
public class EmpDaoImpl implements EmpDao {

    //引入QueryRunner对象，需要数据库连接池对象去构建
    private QueryRunner queryRunner = new QueryRunner(JdbcDataSourseUtil.getDataSource());

    //查询所有员工数据
    @Override
    public List<Emp> selAllEmp() throws Exception {
        return queryRunner.query("select * from emp", new BeanListHandler<Emp>(Emp.class));
    }

    //根据empno查询单个员工数据
    @Override
    public Emp selEmpByEmpno(Integer empno) throws Exception {
        return queryRunner.query("select * from emp where empno=?",new BeanHandler<Emp>(Emp.class),empno);
    }

    //根据员工工作和工资查询员工数据
    @Override
    public List<Emp> selEmpByJobAndSal(String job, Double sal) throws Exception {
        return queryRunner.query("select * from emp where job=? and sal=?",new BeanListHandler<Emp>(Emp.class),job,sal);
    }

    //添加员工数据
    @Override
    public Integer insEmp(Emp emp) throws Exception {
        return queryRunner.update("insert into emp(ename,job,mgr,hiredate,sal,comm,deptno) values (?,?,?,?,?,?,?)",
                emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno());
    }

    //根据员工编号删除单个员工数据
    @Override
    public Integer delEmp(Integer empno) throws Exception {
        return queryRunner.update("delete from emp where empno=?",empno);
    }

    //根据员工编号修改其工作和工资
    @Override
    public Integer updEmp(Emp emp) throws Exception {
        return queryRunner.update("update emp set ename=?,job=?,mgr=?,sal=?,hiredate=?,comm=?,deptno=? where empno=?",emp.getEname(),emp.getJob(),emp.getMgr(),emp.getSal(),emp.getHiredate(),emp.getComm(),emp.getDeptno(),emp.getEmpno());
    }

    //根据工资删除员工数据
    @Override
    public Integer delEmpBySal(Double sal) throws Exception {
        return queryRunner.update("delete from emp where sal=?",sal);
    }

    //根据员工姓名模糊收索和工资范围查询以及部门编号动态查询
    @Override
    public List<Emp> selEmpByPramas(Emp emp) throws Exception {
        StringBuffer sb = new StringBuffer("select * from emp where 1=1");
        //1.判断要查询的条件,判断的条件都不能为第一个条件
        //1-1判断查询员工姓名，模糊查询
        if(emp.getEname()!=null&&emp.getEname()!=""){
            sb.append(" and ename like '%"+emp.getEname()+"%'");
        }
        //1-2判断查询员工工资范围，当前工资到其4000以上(要进行条件拼接)
        if(emp.getSal()!=null&&emp.getSal()!=0){
            Double newSal = emp.getSal()+4000;
            sb.append(" and sal >= "+emp.getSal()+" and sal <= "+newSal);
        }
        if(emp.getDeptno()!=null&&emp.getDeptno()!=0){
            sb.append(" and deptno="+emp.getDeptno());
        }
        return queryRunner.query(sb.toString(),new BeanListHandler<Emp>(Emp.class));
    }

    //根据员工编号动态修改员工姓名和工资以及部门编号
    @Override
    public Integer updEmpByEmpno(Emp emp) throws Exception {
        //1-1.准备要被执行的sql语句
        //    StringBuffer sb = new StringBuffer("update emp set empno="+emp.getEmpno());
        StringBuffer sb = new StringBuffer("update emp set");
        //2.判断要修改的内容
        //2-1判断修改员工姓名
        if(emp.getEname()!=null&&emp.getEname()!=""){
            sb.append(",ename='"+emp.getEname()+"'");
        }
        //2-2判断修改员工工资
        if(emp.getSal()!=null&&emp.getSal()!=0){
            sb.append(",sal="+emp.getSal());
        }
        //2-3判断修改员工部门编号
        if(emp.getDeptno()!=null&&emp.getDeptno()!=0){
            sb.append(",deptno="+emp.getDeptno());
        }
        //2-4拼接修改的条件
        sb.append(" where empno="+emp.getEmpno());
        //得到第一个","的下标
        int index = sb.indexOf(",");
        int i = 0;
        if(index!=-1){
            //将第一个逗号去掉
            sb.replace(index,index+1," ");
            i = queryRunner.update(sb.toString());
        }
        return i;
    }

    //联表查询所有员工和其所在部门数据
    @Override
    public List<Map<String,Object>> selAllEmpAndDept() throws Exception {
        return queryRunner.query("SELECT e.*,d.dname,d.loc from emp e LEFT JOIN dept d on e.deptno=d.deptno order by e.empno desc",new MapListHandler());
    }
}
