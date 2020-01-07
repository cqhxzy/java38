package com.wisezone.servlet;

import com.wisezone.vo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/helloEl")
public class TestElServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student stu1 = new Student(1, "张三", 18, "男");
        Student stu2 = new Student(2, "李四", 18, "女");
        Student stu3 = new Student(3, "王五", 18, "男");

        //在request作用域中添加name属性
        req.setAttribute("stu", stu1);
        //session作用域
        req.getSession().setAttribute("stu", stu2);
        //application作用域
        req.getServletContext().setAttribute("stu", stu3);

        //页面转发
        req.getRequestDispatcher("/pages/testEl.jsp").forward(req,resp);
    }
}
