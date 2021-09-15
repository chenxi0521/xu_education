package com.youxue.servlet; /**
 * @author chenxi
 * @date 2021/9/6 16:37
 * @description
 */

import com.youxue.entity.CourseUser;
import com.youxue.service.CourseUserService;
import com.youxue.service.impl.CourseUserServiceImpl;
import com.youxue.util.JsonUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/courseUser")
public class CourseUserServlet extends BaseServlet {

    CourseUserService cus = new CourseUserServiceImpl();

    protected void getCourseUserBySearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int rows = Integer.parseInt(req.getParameter("pageSize"));
        String search = req.getParameter("search");
        int totalRows = cus.getCourseUserTotalCountBySearch(search);
        String pageUtil = cus.getCourseUserBySearch(currentPage, rows, totalRows,search);
        PrintWriter out = resp.getWriter();
        out.write(pageUtil);
        out.close();
    }


    protected void delCourseUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("ids");
        String res = cus.delCourseUserId(ids);
        PrintWriter out = resp.getWriter();
        out.write(res);
        out.close();
    }


    protected void editCourseUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String cid = req.getParameter("cid");
        String res = cus.editCourseUserId(Integer.parseInt(id),Integer.parseInt(cid));
        PrintWriter out = resp.getWriter();
        out.write(res);
        out.close();
    }


    protected void addCourseUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String cid = req.getParameter("cid");
        cus.addCourseUser(Integer.parseInt(uid),Integer.parseInt(cid));
        resp.sendRedirect("http://127.0.0.1:5500/pages/videoDetail.html?cid="+cid);
    }


    protected void courseUserIsBuy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String cid = req.getParameter("cid");
        boolean res = cus.courseUserIsBuy(Integer.parseInt(uid),Integer.parseInt(cid));
        PrintWriter out = resp.getWriter();
        out.write(JsonUtil.toJson(res));
        out.close();
    }
}
