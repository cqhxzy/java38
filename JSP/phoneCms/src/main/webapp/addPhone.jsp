<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/7
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加手机</title>
    <link rel="stylesheet" href="static/css/common.css">
</head>
<body>
    <form action="${basePath}/addPhoneServlet" method="post">
        <table>
            <caption>
                <h2>新增手机</h2>
            </caption>
            <tr>
                <td>手机品牌</td>
                <td>
                    <input type="text" name="nameType" placeholder="请输入品牌" />
                </td>
            </tr>
            <tr>
                <td>参考报价</td>
                <td>
                    <input type="text" name="price" placeholder="请输入价格" />
                </td>
            </tr>
            <tr>
                <td>网络模式</td>
                <td>
                    <input type="text" name="networkModel" placeholder="请输入网络模式" />
                </td>
            </tr>
            <tr>
                <td>网络类型</td>
                <td>
                    <input type="text" name="networkType" placeholder="请输入网络类型" />
                </td>
            </tr>
            <tr>
                <td>外观设计</td>
                <td>
                    <input type="text" name="facade" placeholder="请输入外观设计" />
                </td>
            </tr>
            <tr>
                <td>屏幕尺寸</td>
                <td>
                    <input type="text" name="screenSize" placeholder="请输入屏幕尺寸" />
                </td>
            </tr>
            <tr>
                <td>屏幕类型</td>
                <td>
                    <input type="text" name="feelScreen" placeholder="请输入屏幕类型" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button>提交</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
