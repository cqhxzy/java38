<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/6
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <ul>
        <%
            //模拟学生报数，将每个学生的报数信息填写到jsp页面中
            for (int i = 0; i < 10; i++) {
        %>
            <li class="<%if (i % 2 == 0){%>even<%}else{%>odd<%}%>" >第<%=i + 1%>个学生报数</li>
        <%
            }
        %>
    </ul>

</body>
</html>
