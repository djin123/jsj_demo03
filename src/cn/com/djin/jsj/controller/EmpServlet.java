package cn.com.djin.jsj.controller;

import cn.com.djin.jsj.entity.Emp;
import cn.com.djin.jsj.service.DeptService;
import cn.com.djin.jsj.service.EmpService;
import cn.com.djin.jsj.service.impl.DeptServiceImpl;
import cn.com.djin.jsj.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class EmpServlet extends BaseServlet {

    //依赖员工业务层对象
    private EmpService empService = new EmpServiceImpl();

    //依赖部门业务层对象
    private DeptService deptService = new DeptServiceImpl();

    //查询所有员工数据
    public void selAllEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1.通过控制器将用户客户端的请求发给模型层中的业务层去执行
            List<Emp> emps = empService.findAllEmp();
            //2.将执行查询所有员工的数据给控制器，由控制器将数据响应回用户客户端
            //2.1.可以将数据放在web作用域中，request作用域
            request.setAttribute("emps",emps);
            //2.2.跳转到响应页面中（转发到jsp,特殊的Servlet），并携带数据过去
            request.getRequestDispatcher("/WEB-INF/jsp/showEmp.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查询所有员工及其部门数据
    public void selAllEmpAndDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            //执行业务层查询所有员工及其部门的方法，得到执行查询数据
            List<Map<String, Object>> empAndDepts = empService.findAllEmpAndDept();
            //再将数据装入到web容器中，request容器
            request.setAttribute("empAndDepts",empAndDepts);
            //进行页面的跳转，转发
            request.getRequestDispatcher("/WEB-INF/jsp/showEmpAndDept.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //根据员工编号删除单个员工数据
    public void delEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取根据员工编号删除的请求参数
        Integer empno = Integer.valueOf(request.getParameter("empno"));
        try {
            String code = empService.removeEmpByEmpno(empno);
            //表示删除成功
            if("delSuccess".equals(code)){
                //删除完成后重定向到全查询员工及其部门数据
                response.sendRedirect("/empServlet?method=selAllEmpAndDept");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //去到添加页面
    public void saveEmpUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            //1.将部门数据查询出装入到web容器中，request作用域中
            request.setAttribute("depts",deptService.findAllDept());
            //2.转发到员工添加页面
            request.getRequestDispatcher("/WEB-INF/jsp/saveEmp.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //执行添加数据操作
    public void saveEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //新建要被添加的员工对象
        Emp emp = new Emp();
        //获取页面参数并设置到要被添加的员工对象去
        emp.setEname(request.getParameter("ename"));
        emp.setJob(request.getParameter("job"));
        emp.setMgr(Integer.valueOf(request.getParameter("mgr")));
        emp.setSal(Double.valueOf(request.getParameter("sal")));
        emp.setHiredate(new Date());
        emp.setComm(Double.valueOf(request.getParameter("comm")));
        emp.setDeptno(Integer.valueOf(request.getParameter("deptno")));
        //执行添加员工数据操作
        try {
            String code = empService.saveEmp(emp);
            if("insSuccess".equals(code)){
                //添加成功后重定向到进行员工数据的全查询
                response.sendRedirect("/empServlet?method=selAllEmpAndDept");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //去到修改页面
    public void updEmpUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取查询单个员工数据的参数
        Integer empno = Integer.valueOf(request.getParameter("empno"));
        try {
            //根据员工编号查询单个员工数据，并装入到web容器中，request作用域
            request.setAttribute("emp",empService.findEmpByEmpno(empno));
            //将当前的所有部门查询出来供用户修改时选择，装入到web容器中，request作用域
            request.setAttribute("depts",deptService.findAllDept());
            //转发到修改页面
            request.getRequestDispatcher("/WEB-INF/jsp/updEmp.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //执行修改操作
    public void updEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //新建一个要被修改的员工对象
        Emp emp = new Emp();
        //获取修改请求的参数并设置到要被修改的员工对象中去
        emp.setEmpno(Integer.valueOf(request.getParameter("empno")));
        emp.setEname(request.getParameter("ename"));
        emp.setJob(request.getParameter("job"));
        emp.setMgr(Integer.valueOf(request.getParameter("mgr")));
        emp.setSal(Double.valueOf(request.getParameter("sal")));
        emp.setHiredate(new Date());
        emp.setComm(Double.valueOf(request.getParameter("comm")));
        emp.setDeptno(Integer.valueOf(request.getParameter("deptno")));
        try {
            //执行修改员工数据
            String code = empService.updEmp(emp);
            if("updSuccess".equals(code)){
                //重定向到查询所有员工和其所在部门数据
                response.sendRedirect("/empServlet?method=selAllEmpAndDept");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
