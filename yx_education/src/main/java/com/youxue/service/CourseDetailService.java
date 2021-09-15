package com.youxue.service;

import com.youxue.entity.CourseDetail;

/**
 * @author chenxi
 * @date 2021/9/6 16:30
 * @description
 */
public interface CourseDetailService {
    String addCourseDetail(CourseDetail courseDetail);

    String getCourseDetailById(int cid);
}
