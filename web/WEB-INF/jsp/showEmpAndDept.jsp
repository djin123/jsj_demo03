<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/2 0002
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>显示</title>
</head>
<style>
    tr:nth-child(odd){
        background-color: gainsboro;
    }
</style>
<body>
    <div align="center">
        <h1>员工部门显示页面</h1>
        <a href="/empServlet?method=saveEmpUI">添加</a>
        <table width="1100px" border="1px" cellspacing="0">
            <thead>
                <tr>
                    <th>员工编号</th>
                    <th>姓名</th>
                    <th>工作</th>
                    <th>上司编号</th>
                    <th>工资</th>
                    <th>入职时间</th>
                    <th>奖金</th>
                    <th>部门编号</th>
                    <th>部门名称</th>
                    <th>部门地址</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${empAndDepts}" var="empAndDept">
                    <!--此时遍历List集合中的每一个元素都为Map集合对象-->
                    <tr align="center">
                        <!--当取出Map集合对象的属性时可以empAndDept['empno']，也可以用empAndDept.job-->
                        <td>${empAndDept['empno']}</td>
                        <td>${empAndDept['ename']}</td>
                        <td>${empAndDept.job}</td>
                        <td>${empAndDept.mgr}</td>
                        <td>${empAndDept.sal}</td>
                        <td><fmt:formatDate value="${empAndDept.hiredate}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
                        <td>${empAndDept.comm}</td>
                        <td>${empAndDept.deptno}</td>
                        <td>${empAndDept.dname}</td>
                        <td>${empAndDept.loc}</td>
                        <td><a href="/empServlet?method=delEmp&empno=${empAndDept['empno']}">删除</a>&nbsp;&nbsp;
                            <a href="/empServlet?method=updEmpUI&empno=${empAndDept['empno']}">修改</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
