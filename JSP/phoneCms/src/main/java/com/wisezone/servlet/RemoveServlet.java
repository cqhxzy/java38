package com.wisezone.servlet;

import com.wisezone.biz.HandSetBiz;
import com.wisezone.biz.impl.HandSetBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/remove")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String strId = req.getParameter("hsId");
        int hsId = Integer.parseInt(strId);

        HandSetBiz handSetBiz = new HandSetBizImpl();
        int deleteById = handSetBiz.deleteById(hsId);

        //设置响应的网页的类型
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>执行结果</title>");
        writer.println("<script>");
        writer.write("alert('"+(deleteById>0?"删除成功":"删除失败")+"');");
        writer.println("window.location.href='" + req.getContextPath() + "/index';"); //当用户点了确定过后，跳转到首页
        writer.println("</script>");
        writer.println("</head>");
        writer.println("</html>");

        writer.flush();
        writer.close();

    }
}
