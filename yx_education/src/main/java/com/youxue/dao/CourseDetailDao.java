package com.youxue.dao;

import com.youxue.entity.CourseDetail;

import java.util.List;
import java.util.Map;

/**
 * @author chenxi
 * @date 2021/9/6 16:28
 * @description
 */
public interface CourseDetailDao {
    int addCourseDetail(CourseDetail courseDetail);

    Map<String,List<CourseDetail>> getCourseDetailById(int cid);
}
