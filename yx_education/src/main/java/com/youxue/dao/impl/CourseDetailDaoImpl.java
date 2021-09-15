package com.youxue.dao.impl;

import com.youxue.dao.CourseDetailDao;
import com.youxue.entity.CourseDetail;
import com.youxue.service.CourseDetailService;
import com.youxue.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenxi
 * @date 2021/9/6 16:29
 * @description
 */
public class CourseDetailDaoImpl implements CourseDetailDao {

    QueryRunner qr = JdbcUtil.getQueryRunner();
    @Override
    public int addCourseDetail(CourseDetail courseDetail) {
        int res = 0;
        String sql = "insert into coursedetail set name=?,type=?,url=?,start_data=?,cid=?";
        try {
            res = qr.update(sql,courseDetail.getName(),courseDetail.getType(),courseDetail.getUrl(),courseDetail.getStart_data(),courseDetail.getCid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  res;

    }

    @Override
    public Map<String,List<CourseDetail>> getCourseDetailById(int cid) {
        Map<String,List<CourseDetail>> map = new HashMap<>();
        String sql1 = "select distinct type from coursedetail where cid=?";
        String sql2 = "select * from coursedetail where cid=? and type=?";
        try {
            List<String> key = qr.query(sql1,new ColumnListHandler<>(),cid);
            for (String s : key) {
                List<CourseDetail> list = qr.query(sql2,new BeanListHandler<>(CourseDetail.class),cid,s);
                map.put(s,list);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return map;
    }
}
