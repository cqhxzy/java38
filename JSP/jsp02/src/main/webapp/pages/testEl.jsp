<%@ page import="com.wisezone.vo.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/6
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <%
        Student stu3 = new Student(4, "赵柳", 18, "女");
        pageContext.setAttribute("stu", stu3);
    %>
</head>
<body>
    <h2>page作用域：<%=pageContext.getAttribute("stu")%></h2>
    <h2>request作用域：<%=request.getAttribute("stu")%></h2>
    <h2>session作用域：<%=session.getAttribute("stu")%></h2>
    <h2>application作用域：<%=application.getAttribute("stu")%></h2>

    <h2>通过EL表达式获取四个作用域中的数据</h2>

    <h2>${stu}</h2>
    <h2>通过EL表达式获取page作用域中的对象信息</h2>
    <ul>
        <li>id：${pageScope.stu.id}</li>
        <li>id：${pageScope.stu.name}</li>
        <li>id：${pageScope.stu.age}</li>
        <li>id：${pageScope.stu.gender}</li>
    </ul>
    <h2>通过EL表达式获取request作用域中的对象信息</h2>
    <ul>
        <li>id：${requestScope.stu.id}</li>
        <li>id：${requestScope.stu.name}</li>
        <li>id：${requestScope.stu.age}</li>
        <li>id：${requestScope.stu.gender}</li>
    </ul>
    <h2>通过EL表达式获取session作用域中的对象信息</h2>
    <ul>
        <li>id：${sessionScope.stu.id}</li>
        <li>id：${sessionScope.stu.name}</li>
        <li>id：${sessionScope.stu.age}</li>
        <li>id：${sessionScope.stu.gender}</li>
    </ul>
    <h2>通过EL表达式获取application作用域中的对象信息</h2>
    <ul>
        <li>id：${applicationScope.stu.id}</li>
        <li>id：${applicationScope.stu.name}</li>
        <li>id：${applicationScope.stu.age}</li>
        <li>id：${applicationScope.stu.gender}</li>
    </ul>
</body>
</html>
