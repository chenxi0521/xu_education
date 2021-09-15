package com.youxue.servlet; /**
 * @author chenxi
 * @date 2021/9/6 16:36
 * @description
 */

import com.youxue.entity.Course;
import com.youxue.service.CourseService;
import com.youxue.service.impl.CourseServiceImpl;
import com.youxue.util.JsonUtil;
import com.youxue.util.ResultUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.UUID;

@MultipartConfig
@WebServlet("/course")
public class CourseServlet extends BaseServlet {

    private CourseService cs = new CourseServiceImpl();

    protected void getCourseBySearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int rows = Integer.parseInt(req.getParameter("pageSize"));
        String search = req.getParameter("search");
        int totalRows = cs.getCourseTotalCountBySearch(search);
        String pageUtil = cs.getCourseBySearch(currentPage, rows, totalRows,search);
        PrintWriter out = resp.getWriter();
        out.write(pageUtil);
        out.close();
    }


    protected void delAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cids = req.getParameter("cids");
        String ru =  cs.delAll(cids);
        PrintWriter out = resp.getWriter();
        out.write(ru);
        out.close();
    }

    protected void upload(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        String fileName = UUID.randomUUID() + part.getSubmittedFileName();
        String contentType = part.getContentType();
        String path = "D:/develop/data/edu_project/edu_source/course/";
        ResultUtil ru = null;
        if (contentType.contains("jpeg") || contentType.contains("jpg") || contentType.contains("png") ||contentType.contains("gif")){
            path = path +"pic";
            ru = new ResultUtil(1,"图片上传成功",fileName);

        }else {
            path = path +"video";
            ru = new ResultUtil(2,"视频上传成功",fileName);
        }

        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        part.write(path + "/"+ fileName);

        PrintWriter out = resp.getWriter();
        out.write(JsonUtil.toJson(ru));
        out.close();
    }

    protected void removeFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
        String path = "D:/develop/data/edu_project/edu_source/course/";
        ResultUtil ru = null;
        if (fileName.contains("jpeg") || fileName.contains("jpg") || fileName.contains("png") ||fileName.contains("gif")){
            path = path +"pic";
            ru = new ResultUtil(1,"图片删除成功",null);

        }else {
            path = path +"video";
            ru = new ResultUtil(2,"视频删除成功",null);
        }

        File file = new File(path+"/"+fileName);
        file.delete();
        PrintWriter out = resp.getWriter();
        out.write(JsonUtil.toJson(ru));
        out.close();
    }


    protected void addCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String obj = req.getParameter("obj");
        Course course = JsonUtil.jsonToEntity(obj, Course.class);
        course.setCreateTime(new Timestamp(System.currentTimeMillis()));

        String ru = cs.addCourse(course);
        PrintWriter out = resp.getWriter();
        out.write(ru);
        out.close();
    }

    protected void editCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String obj = req.getParameter("obj");
        Course course = JsonUtil.jsonToEntity(obj, Course.class);
        course.setCreateTime(new Timestamp(System.currentTimeMillis()));

        String ru = cs.editCourse(course);
        PrintWriter out = resp.getWriter();
        out.write(ru);
        out.close();
    }

    protected void getAllCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String res = cs.getAllCourse();
        PrintWriter out = resp.getWriter();
        out.write(res);
        out.close();
    }

    protected void getCoutseByCourseTypeAndCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseType = req.getParameter("courseType");
        String count = req.getParameter("count");
        String res =cs.getCoutseByCourseTypeAndCount(courseType,count);
        PrintWriter out = resp.getWriter();
        out.write(res);
        out.close();
    }

    protected void getCourseByPageAndCoutseTypeAndSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        String courseType = req.getParameter("courseType");
        String search = req.getParameter("search");
        String res = cs.getCourseByPageAndCoutseTypeAndSearch(currentPage,pageSize,courseType,search);
        PrintWriter out = resp.getWriter();
        out.write(res);
        out.close();

    }

    protected void getCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        String ru = cs.getCourseById(cid);
        PrintWriter out = resp.getWriter();
        out.write(ru);
        out.close();
    }


    protected void getCourseByUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String ru = cs.getCourseByUser(uid);
        PrintWriter out = resp.getWriter();
        out.write(ru);
        out.close();
    }
}
