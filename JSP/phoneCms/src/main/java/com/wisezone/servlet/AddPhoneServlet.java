package com.wisezone.servlet;

import com.wisezone.biz.HandSetBiz;
import com.wisezone.biz.impl.HandSetBizImpl;
import com.wisezone.entity.HandSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addPhoneServlet")
public class AddPhoneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String nameType = req.getParameter("nameType");
        String str_price = req.getParameter("price");//比不保证数据不能为空
        double price = Double.parseDouble(str_price);
        String networkModel = req.getParameter("networkModel");
        String networkType = req.getParameter("networkType");
        String facade = req.getParameter("facade");
        String screenSize = req.getParameter("screenSize");
        String feelScreen = req.getParameter("feelScreen");

        HandSetBiz handSetBiz = new HandSetBizImpl();
        HandSet handSet = new HandSet(0, nameType, price, networkModel, networkType, facade, screenSize, feelScreen);
        int insert = handSetBiz.insert(handSet);



        //设置响应的网页的类型
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>执行结果</title>");
        writer.println("<script>");
        writer.write("alert('"+(insert>0?"添加成功":"添加失败")+"');");
        writer.println("window.location.href='" + req.getContextPath() + "/index';"); //当用户点了确定过后，跳转到首页
        writer.println("</script>");
        writer.println("</head>");
        writer.println("</html>");

        writer.flush();
        writer.close();
    }
}
