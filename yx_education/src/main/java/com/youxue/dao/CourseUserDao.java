package com.youxue.dao;

import com.youxue.entity.CourseUser;

import java.util.List;

/**
 * @author chenxi
 * @date 2021/9/6 16:27
 * @description
 */
public interface CourseUserDao {
    int getCourseUserTotalCountBySearch(String search);

    List<CourseUser> getCourseUserBySearch(int index, int rows, String search);

    int delCourseUserId(String ids);

    int editCourseUserId(int id, int cid);

    int addCourseUser(int uid, int cid);

    int courseUserIsBuy(int uid, int cid);
}
