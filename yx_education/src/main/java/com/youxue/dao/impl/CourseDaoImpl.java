package com.youxue.dao.impl;

import com.youxue.dao.CourseDao;
import com.youxue.entity.Course;
import com.youxue.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author chenxi
 * @date 2021/9/6 16:29
 * @description
 */
public class CourseDaoImpl implements CourseDao {

    private QueryRunner qr = JdbcUtil.getQueryRunner();

    @Override
    public int getCourseTotalCountBySearch(String search) {
        int res = 0;
        String sql = "select count(*) from course where courseName like '%"+search+"%'";

        try {
            res = (int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Course> getCourseBySearch(int index, int rows, String search) {
        List<Course> list = null;
        String sql = "select * from course where courseName like '%"+search+"%' limit ?,?";
        try {
            list = qr.query(sql,new BeanListHandler<>(Course.class),index,rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int delAll(String cids) {
        int res = 0;
        String sql = "delete from course where cid in("+cids+")";
        try {
            res = qr.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  res;
    }

    @Override
    public int addCourse(Course course) {
        int res = 0;
        String sql = "insert into  course set courseName=?,descs=?,courseType=?,courseImage=?,courseVideo=?,coursePrice=?,status=?,createTime=?";
        try {
            res = qr.update(sql,course.getCourseName(),course.getDescs(),course.getCourseType(),course.getCourseImage(),course.getCourseVideo(),course.getCoursePrice(),course.getStatus(),course.getCreateTime());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  res;
    }

    @Override
    public int editCourse(Course course) {
        int res = 0;
        String sql = "update course set courseName=?,descs=?,courseType=?,courseImage=?,courseVideo=?,coursePrice=?,status=?,createTime=? where cid=?";
        try {
            res = qr.update(sql,course.getCourseName(),course.getDescs(),course.getCourseType(),course.getCourseImage(),course.getCourseVideo(),course.getCoursePrice(),course.getStatus(),course.getCreateTime(), course.getCid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  res;
    }

    @Override
    public Course getCourseById(long id) {
        Course course = null;
        String sql = "select * from course where cid=?";
        try {
            course = qr.query(sql,new BeanHandler<>(Course.class),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return course;
    }

    @Override
    public List<Course> getAllCourse() {
        List<Course> list = null;
        String sql = "select * from course";
        try {
            list = qr.query(sql,new BeanListHandler<>(Course.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Course> getCoutseByCourseTypeAndCount(String courseType, String count) {
        List<Course> list = null;
        String sql = "select * from course where courseType=?  limit ?";
        try {
            list = qr.query(sql,new BeanListHandler<>(Course.class),courseType,Integer.parseInt(count));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int getCourseTotalCountBycourseTypeAndSearch(String courseType, String search) {
        int res = 0;
        String sql = "select count(*) from course where courseType=? and courseName like '%"+search+"%'";

        try {
            res = (int)(long)qr.query(sql,new ScalarHandler(),courseType);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Course> getCourseByPageAndCoutseTypeAndSearch(int index, int rows, String courseType, String search) {
        List<Course> list = null;
        String sql = "select * from course where courseType=? and courseName like '%"+search+"%' limit ?,?";
        try {
            list = qr.query(sql,new BeanListHandler<>(Course.class),courseType,index,rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Course> getCourseByUser(int uid) {
        List<Course> list = null;
        String sql = "select * from course where exists(select cid from course_user where cid=course.cid  and uid=?)";
        try {
            list = qr.query(sql,new BeanListHandler<>(Course.class),uid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
