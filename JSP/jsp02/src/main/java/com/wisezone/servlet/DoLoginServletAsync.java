package com.wisezone.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/doLoginServletAsync")
public class DoLoginServletAsync extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //调用业务逻辑层

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String loginAccount = req.getParameter("loginAccount");
        String loginPwd = req.getParameter("loginPwd");

        if (loginAccount.equals("admin") && loginPwd.equals("123456")) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", loginAccount);
            map.put("pwd", loginPwd);
            //向request作用域中添加属性
            req.setAttribute("map",map);


            //用户名或密码正确跳转到首页. 页面转发
            //因为页面转发发生在服务器的内部，getRequestDispatcher方法中的路径，第一个/代表着webapp目录
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        } else {
            resp.setContentType("text/plain"); //服务器向客户端响应的内容为文本
            PrintWriter writer = resp.getWriter();
            writer.write("用户名或密码错误");
            writer.flush();
            writer.close();
        }
    }
}
