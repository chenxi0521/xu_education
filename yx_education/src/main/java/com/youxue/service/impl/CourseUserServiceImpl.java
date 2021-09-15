package com.youxue.service.impl;

import com.youxue.dao.CourseDao;
import com.youxue.dao.CourseUserDao;
import com.youxue.dao.UserDao;
import com.youxue.dao.impl.CourseDaoImpl;
import com.youxue.dao.impl.CourseUserDaoImpl;
import com.youxue.dao.impl.UserDaoImpl;
import com.youxue.entity.Course;
import com.youxue.entity.CourseUser;
import com.youxue.entity.User;
import com.youxue.service.CourseUserService;
import com.youxue.util.JsonUtil;
import com.youxue.util.PageUtil;
import com.youxue.util.ResultUtil;

import java.util.List;

/**
 * @author chenxi
 * @date 2021/9/6 16:32
 * @description
 */
public class CourseUserServiceImpl implements CourseUserService {

    CourseUserDao cud = new CourseUserDaoImpl();
    UserDao ud = new UserDaoImpl();
    CourseDao cd = new CourseDaoImpl();

    @Override
    public int getCourseUserTotalCountBySearch(String search) {
        return cud.getCourseUserTotalCountBySearch(search);
    }

    @Override
    public String getCourseUserBySearch(int currentPage, int rows, int totalRows, String search) {
        PageUtil<CourseUser> pageUtil = new PageUtil(currentPage,rows,totalRows);
        List<CourseUser> list = cud.getCourseUserBySearch(pageUtil.getIndex(),pageUtil.getRows(),search);
        for (CourseUser courseUser : list) {
            User user = ud.getUserById(courseUser.getUid());
            Course course = cd.getCourseById(courseUser.getCid());
            courseUser.setUser(user);
            courseUser.setCourse(course);
        }

        pageUtil.setList(list);
        return JsonUtil.toJson(pageUtil);
    }

    @Override
    public String delCourseUserId(String ids) {

        ResultUtil ru = null;
        int res = cud.delCourseUserId(ids);
        if (res != 0){
            ru = new ResultUtil(1,"成功删除"+res+"条数据",null);
        }else {
            ru = new ResultUtil(0,"删除失败",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String editCourseUserId(int id, int cid) {
        ResultUtil ru = null;
        int res = cud.editCourseUserId(id,cid);
        if (res != 0){
            ru = new ResultUtil(1,"成功修改"+res+"条数据",null);
        }else {
            ru = new ResultUtil(0,"修改失败",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public int addCourseUser(int uid, int cid) {
        return cud.addCourseUser(uid,cid);
    }

    @Override
    public boolean courseUserIsBuy(int uid, int cid) {
        return cud.courseUserIsBuy(uid,cid)==1?true:false;
    }
}
