<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getContextPath(); //   /phone
    application.setAttribute("basePath",basePath);
%>
<html>
    <head>
        <title>首页</title>
        <link rel="stylesheet" href="static/css/common.css">
        <script>

            window.onload=function(){

                let arrA = document.querySelectorAll("tr td a:last-child");

                for(let a of arrA){
                    a.onclick=function(event){
                        if (!confirm("确定删除吗？")){
                            return false; //组织a标签即将要开始的默认行为
                        }
                    }
                }
            }

        </script>
    </head>

    <body>
        <table>
            <caption>
                <h2>手机信息</h2>
                <a href="${basePath}/addPhone.jsp">新增手机信息</a>
            </caption>
            <thead>
                <tr>
                    <th>品牌型号</th>
                    <th>参考报价</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.handsets}" var="handset">
                    <tr>
                        <td>${handset.nameType}</td>
                        <td class="rmb">${handset.price}</td>
                        <td>
                            <a href="${basePath}/details?hsId=${handset.hsId}">详情</a>
                            <a href="${basePath}/remove?hsId=${handset.hsId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
