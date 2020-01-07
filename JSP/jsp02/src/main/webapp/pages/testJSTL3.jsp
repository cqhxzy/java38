<%@ page import="java.util.List" %>
<%@ page import="com.wisezone.vo.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/6
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%
        List<Student> list = new ArrayList<>();
        Student stu1 = new Student(1, "张三", 18, "男");
        Student stu2 = new Student(2, "李四", 18, "女");
        Student stu3 = new Student(3, "王五", 18, "男");
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        //将集合添加到page作用域

        pageContext.setAttribute("list",list);
    %>
    <style>
        table{
            width: 300px;
        }
        table,td,th{
            border: 1px solid #000;
            border-collapse: collapse;
        }

        tr.even{
            background: rgba(155,12,56,0.2);
        }
        tr.odd{
            background: rgba(0,0,0,0.2);
        }
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pageScope.list}" var="item" varStatus="status">
                <tr class="
                        <c:if test="${status.index % 2 == 0}">even</c:if>
                        <c:if test="${status.index % 2 == 1}">odd</c:if>
                        " >
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.age}</td>
                    <td>${item.gender}</td>
                    <td>
                        <a href="#">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
