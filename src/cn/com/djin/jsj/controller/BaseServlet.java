package cn.com.djin.jsj.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *   基础控制器Servlet
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");  //处理请求乱码
        response.setContentType("text/html;charset=UTF-8");  //处理响应乱码
        //得到页面制定的功能路径方法的名字  selAllEmp
        String method = request.getParameter("method");
        try {
            //通过方法名找到子类中的具体方法  代表的为selAllEmp()
            Method methodObj =  this.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            try {
                //调用该子类中的方法
                methodObj.invoke(this,request,response);
            } catch (IllegalAccessException e) {
                System.out.println("方法调用异常");
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                System.out.println("方法无法调用");
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            System.out.println("找不到该方法");
            e.printStackTrace();
        }
    }
}
