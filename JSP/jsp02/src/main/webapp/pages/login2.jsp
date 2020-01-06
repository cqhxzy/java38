<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/3
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();//得到项目的发布名称,jsp02
%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div class="box">
    <form action="<%=contextPath%>/login2" method="post">
        <div>
            <label>
                用户名：
                <input type="text" name="loginAccount" placeholder="请输入用户名" />
            </label>
        </div>
        <div>
            <label>
                密码：
                <input type="password" name="loginPwd" placeholder="请输入密码" />
            </label>
        </div>
        <div id="msg"></div>
        <div>
            <button>提交</button>
        </div>
    </form>
</div>
</body>
</html>
