package com.wisezone.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("--------------------servlet得到用户的请求----------------------");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("-------------MyServlet被销毁，执行destroy方法--------------------");
    }

    /**
     * servlet类被初始化的方法
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        System.out.println("-------------MyServlet被初始化，执行init方法---------------------------");
        String encoding = config.getInitParameter("encoding");
        System.out.println(config.getServletName() + "得到初始化参数encoding：" + encoding);
    }
}
