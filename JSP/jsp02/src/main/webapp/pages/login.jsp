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
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>

        $(function(){

            //表单提交事件
            $("form").submit(function(e){
                //阻止表单的默认行为，因为现在需要通过ajax提交表单
                e.preventDefault();

                //进行表单的非空验证

                var data = $("form").serialize();
                console.log(data)

                $.ajax({
                    url:'<%=contextPath%>/doLoginServletAsync',
                    type:'POST',
                    //dataType:'text/plain',//预计服务器会响应的数据的类型
                    data:data, //loginAccount=admin&loginPwd123456
                    success:function(resp){
                        $("#msg").text(resp);
                    }
                });
            });

        });

    </script>
</head>
<body>
    <div class="box">
        <form action="<%=contextPath%>/doLoginServlet" method="post">
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
