package com.wisezone.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login2")
public class DoLoginServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求体中的编码方式
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String loginAccount = req.getParameter("loginAccount");
        String loginPwd = req.getParameter("loginPwd");

        if (loginAccount.equals("admin") && loginPwd.equals("123")) {

            //将用户名保存到session
            HttpSession session = req.getSession();
            //向session作用域中保存用户信息
            session.setAttribute("loginAccount",loginAccount);

            //向application中添加一个访问人数
            ServletContext application = req.getServletContext(); //本质上就是jsp中的application对象

            Object o = application.getAttribute("total"); //int
            if (o == null) {
                 o = Integer.parseInt(application.getInitParameter("total"));//int
            }

            int total = (int) o;
            total += 1; //更新全局的total
            application.setAttribute("total",total);


            //int total = Integer.parseInt(application.getInitParameter("total"));
           // total += 1;


            resp.sendRedirect(req.getContextPath() + "/index2.jsp");
        }
    }
}
