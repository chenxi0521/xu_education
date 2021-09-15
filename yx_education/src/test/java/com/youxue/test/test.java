package com.youxue.test;

import com.youxue.entity.Course;
import com.youxue.entity.CourseUser;
import com.youxue.entity.User;
import com.youxue.service.CourseService;
import com.youxue.service.UserService;
import com.youxue.service.impl.CourseServiceImpl;
import com.youxue.service.impl.UserServiceImpl;
import com.youxue.util.JdbcUtil;
import com.youxue.util.PageUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

/**
 * @author chenxi
 * @date 2021/9/7 21:39
 * @description
 */
public class test {
    QueryRunner qr = JdbcUtil.getQueryRunner();

    @Test
    public void test1() {
        UserService us = new UserServiceImpl();
        int usersTotalCount = us.getUsersTotalCount();
        PageUtil pageUtil = new PageUtil(4, 3, usersTotalCount);
        System.out.println(pageUtil);


    }

    @Test
    public void test2() {

        int res = 0;
        String sql = "select count(*) from course where courseName like '%%'";

        try {
            res = (int) (long) qr.query(sql, new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(res);
    }

    @Test
    public void test3() {


        String path = "http://localhost:8080/edu_source/course/pic/01.jpg";
        File file = new File(path);
        file.delete();
    }

    @Test
    public void getCourseUserTotalCountBySearch() {
        String search = "a";
        int res = 0;
        String sql = "select count(*) from course_user where uid in(select uid from user where username like '%" + search + "%')";

        try {
            res = (int) (long) qr.query(sql, new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(res);
    }

    public List<CourseUser> getCourseUserBySearch(String search) {
        List<CourseUser> list = null;
        String sql = "select * from course_user where uid in(select uid from user where username like '%" + search + "%')";
        try {
            list = qr.query(sql, new BeanListHandler<>(CourseUser.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;


    }

    @Test
    public void test4() {


        List<CourseUser> admin = getCourseUserBySearch("admin");
        System.out.println(admin);

    }
}
