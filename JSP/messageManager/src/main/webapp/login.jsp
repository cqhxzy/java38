<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/9
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        html,body{
            margin: 0;
            padding: 0;
            width: 100%;
            height: 100%;
        }
        table{
            margin: 0 auto;
            width: 500px;
        }
        table,td{
            border: 1px solid #000;
            border-collapse: collapse;
        }
        td span{
            font-size: 12px;
            font-weight: bold;
            color: red;
        }
        tr{
            height: 50px;
            text-align: center;
        }
        .box{
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
        }
    </style>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
        $(function(){

            $("form").submit(function(e){
                //阻止表单默认行为
                e.preventDefault();

                var flag = true;

                //非空验证
                $(":text").each(function(){ //遍历所有的文本框
                    var v = $(this).val(); //得到当前文本框的值
                    if (v == "") {
                        var text = $(this).parents("tr").find("td:first label").text();
                        $(this).next("span").text(text + "不能为空");
                        flag = false;
                    }
                });

                //表单通过验证
                if (flag) {
                    //异步登录
                    $.ajax({
                        url:'<%=request.getContextPath()%>/login',
                        type:'post',
                        dataType:'json',
                        data:$("form").serialize(),
                        success:function(resp){
                            console.log(resp);
                            if (resp.code != 200) {
                                alert(resp.msg);
                            } else {
                                window.location.href = '<%=request.getContextPath()%>/index';
                            }
                        }
                    });
                }

            });
        });
    </script>
</head>
<body>
<form>
    <div class="box">
        <table>
            <tr>
                <td colspan="2">
                    <h1>登录</h1>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="loginAccount">用户名</label>
                </td>
                <td>
                    <input type="text" name="loginAccount" id="loginAccount" placeholder="请输入用户名">
                    <span></span>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="loginPwd">密码</label>
                </td>
                <td>
                    <input type="text" name="loginPwd" id="loginPwd" placeholder="请输入密码">
                    <span></span>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button>提交</button>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
