package com.wisezone.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "hello",urlPatterns = {"/hello"},initParams = {@WebInitParam(name = "nickName",value="nick")})
public class HelloServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //super.service(req, res);
        System.out.println("--------------------HelloServlet得到用户的请求----------------------");
        System.out.println(this);

        HttpServletResponse response = (HttpServletResponse) res;
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(this.toString());
        response.getWriter().write("<br />");
        response.getWriter().write("当前线程：" + Thread.currentThread().getName());


        response.getWriter().flush();
        response.getWriter().close();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("-------------HelloServlet被销毁，执行destroy方法--------------------");
    }

    /**
     * servlet类被初始化的方法
     * @throws ServletException
     */
    /*@Override
    public void init() throws ServletException {
        super.init();
        System.out.println("-------------HelloServlet被初始化，执行init方法---------------------------");
    }*/

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("-------------HelloServlet被初始化，执行init方法---------------------------");
        /*Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) { //输出所有的属性名
            String s = initParameterNames.nextElement();
            System.out.println(s);
        }*/

        String nickName = config.getInitParameter("nickName");
        System.out.println("得到初始化参数nickName：" + nickName);
    }

}
