package com.youxue.dao;

import com.youxue.entity.Course;

import java.util.List;

/**
 * @author chenxi
 * @date 2021/9/6 16:28
 * @description
 */
public interface CourseDao {
    int getCourseTotalCountBySearch(String search);

    List<Course> getCourseBySearch(int index, int rows, String search);

    int delAll(String cids);

    int addCourse(Course course);

    int editCourse(Course course);

    Course getCourseById(long id);

    List<Course> getAllCourse();

    List<Course> getCoutseByCourseTypeAndCount(String courseType, String count);

    int getCourseTotalCountBycourseTypeAndSearch(String courseType, String search);;

    List<Course> getCourseByPageAndCoutseTypeAndSearch(int index, int rows, String courseType, String search);

    List<Course> getCourseByUser(int uid);
}
