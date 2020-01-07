<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/6
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //从session作用域中获取信息
        Object loginAccount = session.getAttribute("loginAccount");
        Object total = application.getAttribute("total");
    %>
    <h2>欢迎<%=loginAccount%>！</h2>

    <p>session的最大有效时间：<%=session.getMaxInactiveInterval()%></p>
    <p>当前网站访问人数：<%=total%></p>
</body>
</html>
