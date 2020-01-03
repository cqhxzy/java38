<%@ page import="java.util.Map" %>
<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" %>
<html>
<body>


<%
    //在request作用域中获取数据
    Map map = (Map) request.getAttribute("map");
%>
<h2>Hello <%=map.get("name")%></h2>
</body>
</html>
