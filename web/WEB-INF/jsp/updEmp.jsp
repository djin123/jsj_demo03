<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/3 0003
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>员工修改页面</title>
</head>
<body>
    <div align="center">
        <h1>员工修改页面</h1>
        <table width="500px" height="550px" border="1px" cellspacing="0">
            <form action="/empServlet?method=updEmp" method="post">
                <input name="empno" value="${emp.empno}" type="hidden"/>
                <tbody align="center">
                    <tr>
                        <td>员工姓名</td>
                        <td><input type="text" name="ename" value="${emp.ename}"/></td>
                    </tr>
                    <tr>
                        <td>工作</td>
                        <td><input type="text" name="job" value="${emp.job}"/></td>
                    </tr>
                    <tr>
                        <td>上司编号</td>
                        <td><input type="text" name="mgr" value="${emp.mgr}"/></td>
                    </tr>
                    <tr>
                        <td>工资</td>
                        <td><input type="text" name="sal" value="${emp.sal}"/></td>
                    </tr>
                    <tr>
                        <td>奖金</td>
                        <td><input type="text" name="comm" value="${emp.comm}"/></td>
                    </tr>
                    <tr>
                        <td>部门</td>
                        <td><select name="deptno">
                               <c:forEach items="${depts}" var="dept">
                                   <!--回显员工原来部门  emp.deptno == dept.deptno-->
                                   <c:choose>
                                       <c:when test="${emp.deptno==dept.deptno}">
                                           <option value="${dept.deptno}" selected>${dept.dname}</option>
                                       </c:when>
                                       <c:otherwise>
                                           <option value="${dept.deptno}">${dept.dname}</option>
                                       </c:otherwise>
                                   </c:choose>
                               </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="submit" value="修改"/>
                        </td>
                    </tr>
                </tbody>
            </form>
        </table>

    </div>
</body>
</html>
