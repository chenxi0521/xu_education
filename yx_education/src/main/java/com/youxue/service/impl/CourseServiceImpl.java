package com.youxue.service.impl;

import com.youxue.dao.CourseDao;
import com.youxue.dao.impl.CourseDaoImpl;
import com.youxue.entity.Course;
import com.youxue.service.CourseService;
import com.youxue.util.JsonUtil;
import com.youxue.util.PageUtil;
import com.youxue.util.ResultUtil;

import java.io.File;
import java.util.List;

/**
 * @author chenxi
 * @date 2021/9/6 16:32
 * @description
 */
public class CourseServiceImpl implements CourseService {

    private CourseDao cd = new CourseDaoImpl();

    @Override
    public int getCourseTotalCountBySearch(String search) {
        int res = cd.getCourseTotalCountBySearch(search);
        return res;
    }

    @Override
    public String getCourseBySearch(int currentPage, int rows, int totalRows, String search) {
        PageUtil<Course> pageUtil = new PageUtil(currentPage,rows,totalRows);
        List<Course> courseByPage = cd.getCourseBySearch(pageUtil.getIndex(),pageUtil.getRows(),search);
        pageUtil.setList(courseByPage);
        return JsonUtil.toJson(pageUtil);
    }

    @Override
    public String delAll(String cids) {
        ResultUtil ru = null;
        int res = cd.delAll(cids);

        if (res > 0){
            ru = new ResultUtil(1,"成功删除"+res+"条数据",null);
        }else {
            ru = new ResultUtil(0,"删除失败",null);
        }

        return JsonUtil.toJson(ru);
    }

    @Override
    public String addCourse(Course course) {
        ResultUtil ru = null;
        int res = cd.addCourse(course);
        if (res == 1){
            ru = new ResultUtil(1,"成功添加"+res+"条数据",null);
        }else {
            ru = new ResultUtil(0,"添加失败",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String editCourse(Course course) {
        ResultUtil ru = null;
        Course courseById = cd.getCourseById(course.getCid());
        String path = "D:/develop/data/edu_project/edu_source/course/";
        if(!courseById.getCourseImage().equals(course.getCourseImage())){
            path = path+"pic/"+courseById.getCourseImage();
            System.out.println(path);
            File file = new File(path);
            file.delete();
        }

        if(!courseById.getCourseVideo().equals(course.getCourseVideo())){
            File file = new File(path+"vedio/"+courseById.getCourseVideo());
            file.delete();
        }

        int res = cd.editCourse(course);
        if (res == 1){
            ru = new ResultUtil(1,"成功修改"+res+"条数据",null);
        }else {
            ru = new ResultUtil(0,"修改失败",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String getAllCourse() {
        List<Course> list = cd.getAllCourse();
       return JsonUtil.toJson(list);
    }

    @Override
    public String getCoutseByCourseTypeAndCount(String courseType, String count) {
        List<Course> list = cd.getCoutseByCourseTypeAndCount(courseType,count);
        return JsonUtil.toJson(list);
    }

    @Override
    public String getCourseByPageAndCoutseTypeAndSearch(String currentPage, String pageSize, String courseType, String search) {
        PageUtil<Course> pageUtil = null;
        if (Integer.parseInt(courseType)==0){
            int courseTotalCountBySearch = cd.getCourseTotalCountBySearch(search);
            pageUtil = new PageUtil(Integer.parseInt(currentPage),Integer.parseInt(pageSize),courseTotalCountBySearch);
            List<Course> courseBySearch = cd.getCourseBySearch(pageUtil.getIndex(), pageUtil.getRows(), search);
            pageUtil.setList(courseBySearch);
        }else {
            int CourseTotalCountBycourseTypeAndSearch = cd.getCourseTotalCountBycourseTypeAndSearch(courseType,search);
            pageUtil = new PageUtil(Integer.parseInt(currentPage),Integer.parseInt(pageSize),CourseTotalCountBycourseTypeAndSearch);
            List<Course> courseBySearch = cd.getCourseByPageAndCoutseTypeAndSearch(pageUtil.getIndex(), pageUtil.getRows(),courseType,search);
            pageUtil.setList(courseBySearch);
        }
        return JsonUtil.toJson(pageUtil);
    }

    @Override
    public String getCourseById(String cid) {
        Course course = cd.getCourseById(Integer.parseInt(cid));
        return JsonUtil.toJson(course);
    }

    @Override
    public String getCourseByUser(String uid) {
        List<Course> list = cd.getCourseByUser(Integer.parseInt(uid));
        return JsonUtil.toJson(list);
    }
}
