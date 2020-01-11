package com.wisezone.servlet;

import com.wisezone.biz.MessageBiz;
import com.wisezone.biz.impl.MessageBizImpl;
import com.wisezone.util.PageUtil;
import com.wisezone.vo.MessageVo;

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
        resp.setCharacterEncoding("utf-8");
        //使用分页查询
        PageUtil pageUtil = new PageUtil();

        //获取页码
        String pageIndex = req.getParameter("pageIndex");
        if (pageIndex != null) {
            pageUtil.setPageIndex(Integer.parseInt(pageIndex));
        }

        //调用message的业务逻辑层
        MessageBiz messageBiz = new MessageBizImpl();
        //List<MessageVo> messageVos = messageBiz.queryAllMes();

        //将集合添加到request作用域
        //req.setAttribute("list", messageVos);



        messageBiz.page(pageUtil);

        req.setAttribute("page",pageUtil);

        //页面转发
        req.getRequestDispatcher("/page.jsp").forward(req,resp);
    }
}
