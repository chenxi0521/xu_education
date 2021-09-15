package com.youxue.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author chenxi
 * @date 2021/8/27 10:39
 * @description
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        Class c = this.getClass();
        try {
            Method m = c.getDeclaredMethod(type,HttpServletRequest.class,HttpServletResponse.class);
            m.setAccessible(true);
            m.invoke(this,req,resp);
        } catch (Exception e) {

        }

    }
}
