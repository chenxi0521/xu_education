package com.youxue.servlet; /**
 * @author chenxi
 * @date 2021/9/6 16:37
 * @description
 */

import com.youxue.entity.CourseDetail;
import com.youxue.service.CourseDetailService;
import com.youxue.service.impl.CourseDetailServiceImpl;
import com.youxue.util.JsonUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/courseDetail")
public class CourseDetailServlet extends BaseServlet {

        CourseDetailService cds = new CourseDetailServiceImpl();
    protected void addCourseDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String obj = req.getParameter("obj");
        CourseDetail courseDetail = JsonUtil.jsonToEntity(obj, CourseDetail.class);

        String res = cds.addCourseDetail(courseDetail);

        PrintWriter out = resp.getWriter();
        out.write(res);
        out.close();
    }

    protected void getCourseDetailById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid = Integer.parseInt(req.getParameter("cid"));
        String res = cds.getCourseDetailById(cid);

        PrintWriter out = resp.getWriter();
        out.write(res);
        out.close();
    }


}
