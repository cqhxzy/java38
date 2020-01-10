<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <style>
        html,body,p{
            margin: 0;
            padding: 0;
        }
        .container{
            width: 800px;
            margin: 0 auto;
        }

        article{
            border-bottom: 3px solid #000;
        }
        article:first-of-type{
            border-top: 3px solid #000;
        }
        article p span{
            font-weight: bold;
        }
        article p span.mes_content{
            display: block;
        }
        article p:last-of-type{
            text-align: right;
        }
        h1{
            text-align: center;
            margin: 0;
        }

        section>nav{
            position: relative;
            height: 50px;
            margin-top: 20px;
        }
        section>nav a {
            display: block;
            position: absolute;
            right: 0;
            bottom: 0;
        }

        .footer{
            display: flex;
            justify-content: center;
        }

        ul{
            margin: 0;
            padding: 0;
            list-style: none;
        }
        .footer ul{
            display: flex;
            margin: 15px auto;
            max-width: 150px;
        }
        a{
            text-decoration: none;
            color: #4772a3;
        }
        ul li{
            margin-right: 10px;
        }
        ul a{
            display: block;
            width: 20px;
            line-height: 20px;
            border: 1px solid #4772a3;
            text-align: center;
        }
        li.currentPage a{
            color: #000;
            font-weight: bold;
            border: none;
            cursor: not-allowed;
        }
    </style>
</head>
<body>
<div class="container">
    <section>
        <nav>
            <h1>留言板</h1>
            <c:if test="${sessionScope.user != null}">
                欢迎${sessionScope.user.author}!<a href="#">发表留言</a>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <a href="/message/login.jsp">登录</a>
            </c:if>
        </nav>
        <c:forEach items="${page.data}" var="m">
            <article>
                <p>
                    <span>留言标题：</span>
                        ${m.topic}
                </p>
                <p>
                    <span class="mes_content">留言内容</span>
                        ${m.content}
                </p>
                <p>
                    <span>发表日期：</span>${m.mesDate} <span>${m.author}</span>
                </p>
            </article>
        </c:forEach>

        <div class="footer">
            <ul>
                <c:forEach items="${page.nav}" var="num" >
                    <c:if test="${num == page.pageIndex}">
                        <li class="currentPage">
                            <a>${num}</a>
                        </li>
                    </c:if>
                    <c:if test="${num != page.pageIndex}">
                        <li>
                            <a href="<%=request.getContextPath()%>/index?pageIndex=${num}">${num}</a>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </section>
</div>
</body>
</html>
