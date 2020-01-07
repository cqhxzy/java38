<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/7
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机详情</title>
    <style>

        table{
            margin: 0 auto;
            width: 300px;
            text-align: center;
        }
        tr{
            height: 50px;
        }
    </style>
</head>
<body>
    <table>
        <caption>
            <h2>${handset.nameType}</h2>
        </caption>
        <tr>
            <td>参考报价</td>
            <td>
                ${handset.price}
            </td>
        </tr>
        <tr>
            <td>网络模式</td>
            <td>
                ${handset.networkMode}
            </td>
        </tr>
        <tr>
            <td>网络类型</td>
            <td>
                ${handset.networkType}
            </td>
        </tr>
        <tr>
            <td>外观设计</td>
            <td>
                ${handset.facade}
            </td>
        </tr>
        <tr>
            <td>主屏尺寸</td>
            <td>
                ${handset.screenSize}
            </td>
        </tr>
        <tr>
            <td>触摸屏</td>
            <td>
                ${handset.feelScreen}
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <%--<a href="javascript:history.go(-1);">返回</a>--%>
                <a href="${basePath}">返回</a>
            </td>
        </tr>
    </table>
</body>
</html>
