package com.youxue.dao.impl;

import com.youxue.dao.CourseUserDao;
import com.youxue.entity.CourseUser;
import com.youxue.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author chenxi
 * @date 2021/9/6 16:29
 * @description
 */
public class CourseUserDaoImpl implements CourseUserDao{
    QueryRunner qr = JdbcUtil.getQueryRunner();

    @Override
    public int getCourseUserTotalCountBySearch(String search) {

        int res = 0;
        String sql = "select count(*) from course_user where uid in(select uid from user where username like '%"+search+"%')";

        try {
            res = (int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return res;
    }

    @Override
    public List<CourseUser> getCourseUserBySearch(int index, int rows, String search) {
        List<CourseUser> list = null;
        String sql = "select * from course_user where uid in(select uid from user where username like '%"+search+"%') limit ?,?";
        try {
            list = qr.query(sql,new BeanListHandler<>(CourseUser.class),index,rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;


    }

    @Override
    public int delCourseUserId(String ids) {
        int res = 0;
        String sql = "delete from course_user where id in("+ids+")";
        try {
            res = qr.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int editCourseUserId(int id, int cid) {
        int res = 0;
        String sql = "update course_user set cid=? where id=?";
        try {
            res = qr.update(sql,cid,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;

    }

    @Override
    public int addCourseUser(int uid, int cid) {

        int res = 0;
        String sql = "insert into course_user set cid=?,uid=?";
        try {
            res = qr.update(sql,cid,uid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int courseUserIsBuy(int uid, int cid) {
        int res = 0;
        String sql = "select count(*) from course_user where cid=? and uid=?";
        try {
                res = (int)(long)qr.query(sql,new ScalarHandler<>(),cid,uid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }
}
