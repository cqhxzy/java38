package com.wisezone.servlet;

import com.alibaba.fastjson.JSONObject;
import com.wisezone.biz.AuthorBiz;
import com.wisezone.biz.impl.AuthorBizImpl;
import com.wisezone.vo.AuthorVo;
import com.wisezone.vo.DataVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");


        String loginAccount = req.getParameter("loginAccount");
        String loginPwd = req.getParameter("loginPwd");

        AuthorBiz authorBiz = new AuthorBizImpl();
        AuthorVo login = authorBiz.login(loginAccount, loginPwd);

        /*
        *
        * {
        *   "author":{"id":1001,"loginAccount":"123123","authorName"}
        * }
        * */

//        StringBuilder builder = new StringBuilder();
//        builder.append("{")
//                .append("\"author\":{")
//                .append("\"id\":" + login.getId() + ",")
//                .append("\"loginAccount\":" + login.getLoginAccount() + ",")
//                .append("\"authorName\":" + login.getAuthor())
//                .append("}")
//                .append("}");

        DataVo vo = new DataVo();
        if (login == null) {
            vo.setCode(DataVo.ERROR);
            vo.setMsg("用户名或密码错误");
            logger.info("用户名或密码错误",loginAccount,loginPwd);
        } else{
            req.getSession().setAttribute("user",login);

            vo.setCode(DataVo.SUCCESS);
            vo.setMsg("登录成功");
            vo.setData(login);
            logger.info("登录的json：",login);
        }


        //设置响应的contentType
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //writer.write(builder.toString());
        writer.write(JSONObject.toJSONString(vo));
        writer.flush();
        writer.close();

    }
}
