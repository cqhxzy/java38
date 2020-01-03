package com.wisezone.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/req_servlet")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();//得到发布的项目名。
        System.out.println(req.getPathInfo());
        String queryString = req.getQueryString();
        System.out.println("得到url中的参数部分：" + queryString);
        System.out.println("客户端请求的url地址：" + 	req.getRequestURI());
        System.out.println("" + req.getServletPath());
        System.out.println(req.getRemoteAddr());

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println("得到用户请求中的参数name：" + name);
        System.out.println("得到用户请求中的参数pwd：" + pwd);
    }
}
