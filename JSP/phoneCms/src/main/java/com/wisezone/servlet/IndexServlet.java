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
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //调用业务逻辑层实现查询操作
        HandSetBiz handSetBiz = new HandSetBizImpl();
        List<HandSet> handSets = handSetBiz.queryAll();

        req.setAttribute("handsets", handSets);

        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
