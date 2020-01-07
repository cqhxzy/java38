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

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String str_id = req.getParameter("hsId");
        int hsId = Integer.parseInt(str_id); //得到id

        HandSetBiz handSetBiz = new HandSetBizImpl();

        HandSet handSet = handSetBiz.findById(hsId);

        req.setAttribute("handset", handSet);
        req.getRequestDispatcher("/details.jsp").forward(req,resp);
    }
}
