package com.youxue.service;

/**
 * @author chenxi
 * @date 2021/9/6 16:30
 * @description
 */
public interface CourseUserService {
    int getCourseUserTotalCountBySearch(String search);

    String getCourseUserBySearch(int currentPage, int rows, int totalRows, String search);

    String delCourseUserId(String ids);

    String editCourseUserId(int id, int cid);

    int addCourseUser(int uid, int cid);

    boolean courseUserIsBuy(int uid, int cid);
}
