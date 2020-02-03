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
<body>
    <div align="center">
        <h1>员工显示页面</h1>
        <a href="#">添加</a>
        <table width="800px" border="1px" cellspacing="0">
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
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${emps}" var="emp">
                    <!--此时遍历List集合中的每一个元素都为Emp员工对象-->
                    <tr align="center">
                        <td>${emp.empno}</td>
                        <td>${emp.ename}</td>
                        <td>${emp.job}</td>
                        <td>${emp.mgr}</td>
                        <td>${emp.sal}</td>
                        <td><fmt:formatDate value="${emp.hiredate}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
                        <td>${emp.comm}</td>
                        <td>${emp.deptno}</td>
                        <td><a href="#">删除</a>&nbsp;&nbsp;
                            <a href="#">修改</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
