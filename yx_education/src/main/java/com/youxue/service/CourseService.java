package com.youxue.service;

import com.youxue.entity.Course;

/**
 * @author chenxi
 * @date 2021/9/6 16:31
 * @description
 */
public interface CourseService {
    int getCourseTotalCountBySearch(String search);

    String getCourseBySearch(int currentPage, int rows, int totalRows, String search);

    String delAll(String cids);

    String addCourse(Course course);

    String editCourse(Course course);

    String getAllCourse();

    String getCoutseByCourseTypeAndCount(String courseType, String count);

    String getCourseByPageAndCoutseTypeAndSearch(String currentPage, String pageSize, String courseType, String search);

    String getCourseById(String cid);

    String getCourseByUser(String uid);
}
