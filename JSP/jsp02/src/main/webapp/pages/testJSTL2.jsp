<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/6
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style>
        li{
            font-weight: bold;
        }
        li.even{
            color: green;
        }
        li.odd{
            color: pink;
        }
    </style>
</head>
<body>
    <%
        int count = 10;
        pageContext.setAttribute("count",count);
    %>


    <ul>
        <c:forEach begin="0" end="${count-1}" var="i" varStatus="status">
            <li class="
                <c:if test="${i % 2 == 0}">even</c:if>
                <c:if test="${i % 2 == 1}">odd</c:if>
                ">${i}</li>
        </c:forEach>
    </ul>



</body>
</html>
