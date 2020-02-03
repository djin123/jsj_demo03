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
    <title>添加员工页面</title>
</head>
<body>
    <div align="center">
        <h1>员工添加页面</h1>
        <table width="500px" height="550px" border="1px" cellspacing="0">
            <form action="/empServlet?method=saveEmp" method="post">
                <tbody align="center">
                    <tr>
                        <td>员工姓名</td>
                        <td><input type="text" name="ename" placeholder="请输入员工姓名"/></td>
                    </tr>
                    <tr>
                        <td>工作</td>
                        <td><input type="text" name="job" placeholder="请输入员工工作"/></td>
                    </tr>
                    <tr>
                        <td>上司编号</td>
                        <td><input type="text" name="mgr" placeholder="请输入上司编号"/></td>
                    </tr>
                    <tr>
                        <td>工资</td>
                        <td><input type="text" name="sal" placeholder="请输入员工工资"/></td>
                    </tr>
                    <tr>
                        <td>奖金</td>
                        <td><input type="text" name="comm" placeholder="请输入员工奖金"/></td>
                    </tr>
                    <tr>
                        <td>部门</td>
                        <td><select name="deptno">
                               <option value="10">--请选择部门--</option>
                               <c:forEach items="${depts}" var="dept">
                                   <option value="${dept.deptno}">${dept.dname}</option>
                               </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="submit" value="添加"/>
                        </td>
                    </tr>
                </tbody>
            </form>
        </table>

    </div>
</body>
</html>
