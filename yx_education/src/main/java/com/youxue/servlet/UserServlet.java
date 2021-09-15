package com.youxue.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youxue.entity.User;
import com.youxue.service.UserService;
import com.youxue.service.impl.UserServiceImpl;
import com.youxue.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author chenxi
 * @date 2021/9/6 16:35
 * @description
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {

    UserService us = new UserServiceImpl();

    protected void createCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        HttpSession session = req.getSession();
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode);
        //生成图片
        int w = 120, h = 30;
        VerifyCodeUtils.outputImage(w, h, resp.getOutputStream(), verifyCode);
    }


    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        String verCode = (String) session.getAttribute("verCode");
        System.out.println("111111111111:"+verCode);

        String res = us.loginVerification(username, password, code, session);

        PrintWriter out = resp.getWriter();
        out.write(res);
        out.close();

    }


    protected void getLoginUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        PrintWriter out = resp.getWriter();
        out.write(JsonUtil.toJson(user));
        out.close();
    }



    protected void signOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();

        ResultUtil ru = new ResultUtil(1,"退出成功",null);

        PrintWriter out = resp.getWriter();
        out.write(JsonUtil.toJson(ru));
        out.close();
    }


    protected void getAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String allUser = us.getAllUser();

        PrintWriter out = resp.getWriter();
        out.write(allUser);
        out.close();
    }


    protected void getUsersByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int rows = Integer.parseInt(req.getParameter("pageSize"));
        int totalRows = us.getUsersTotalCount();

        String pageUtil = us.getUsersByPage(currentPage, rows, totalRows);


        PrintWriter out = resp.getWriter();
        out.write(pageUtil);
        out.close();
    }


    protected void getUsersBySearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int rows = Integer.parseInt(req.getParameter("pageSize"));
        String search = req.getParameter("search");
        int totalRows = us.getUsersTotalCountBySearch(search);

        String pageUtil = us.getUsersBySearch(currentPage, rows, totalRows,search);


        PrintWriter out = resp.getWriter();
        out.write(pageUtil);
        out.close();
    }

    protected void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = req.getParameter("data");
        User user = JsonUtil.jsonToEntity(data,User.class);
        user.setCreatetime(new Timestamp(System.currentTimeMillis()));
        String ru = us.AddUser(user);
        PrintWriter out = resp.getWriter();
        out.write(ru);
        out.close();
    }


    protected void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = req.getParameter("data");
        User user = JsonUtil.jsonToEntity(data,User.class);
        String ru = us.editUser(user);
        PrintWriter out = resp.getWriter();
        out.write(ru);
        out.close();
    }

    protected void delAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uids = req.getParameter("uids");
        String res = us.delAll(uids);
        PrintWriter out = resp.getWriter();
        out.write(res);
        out.close();
    }

    protected void getuserByPhone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String res = us.getuserByPhone(phone);
        PrintWriter out = resp.getWriter();
        out.write(res);
        out.close();

    }


    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String obj = req.getParameter("obj");
        User user = JsonUtil.jsonToEntity(obj, User.class);
        user.setName("未设置昵称");
        user.setStatus(1);
        user.setCreatetime(new Timestamp(System.currentTimeMillis()));
        user.setRole(2);
        String ru = us.AddUser(user);
        PrintWriter out = resp.getWriter();
        out.write(ru);
        out.close();

    }


    protected void getUserByUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String res = us.getUserByUsername(username);
        PrintWriter out = resp.getWriter();
        out.write(res);
        out.close();
    }


    protected void loginByPhone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String res = us.loginByPhone(phone,password);
        System.out.println(res);
        PrintWriter out = resp.getWriter();
        out.write(res);
        out.close();
    }



}
