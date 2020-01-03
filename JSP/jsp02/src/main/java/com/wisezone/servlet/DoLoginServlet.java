package com.wisezone.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/doLoginServlet")
public class DoLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求体中的参数编码方式为utf-8
        req.setCharacterEncoding("utf-8");
        String loginAccount = req.getParameter("loginAccount");
        String loginPwd = req.getParameter("loginPwd");

        /*System.out.println(loginAccount);
        System.out.println(loginPwd);*/

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
            //用户名或密码失败，回到登录页，重定向
        }
    }
}
