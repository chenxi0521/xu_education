package com.youxue.service.impl;

import com.youxue.dao.CourseDetailDao;
import com.youxue.dao.impl.CourseDetailDaoImpl;
import com.youxue.entity.CourseDetail;
import com.youxue.service.CourseDetailService;
import com.youxue.util.JsonUtil;
import com.youxue.util.ResultUtil;

import java.util.List;
import java.util.Map;

/**
 * @author chenxi
 * @date 2021/9/6 16:32
 * @description
 */
public class CourseDetailServiceImpl implements CourseDetailService {
    CourseDetailDao cdd = new CourseDetailDaoImpl();
    @Override
    public String addCourseDetail(CourseDetail courseDetail) {

        ResultUtil ru = null;
        int res = cdd.addCourseDetail(courseDetail);
        if (res == 1){
            ru = new ResultUtil(1,"成功添加"+res+"条数据",null);
        }else {
            ru = new ResultUtil(0,"添加失败",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String getCourseDetailById(int cid) {
        Map<String,List<CourseDetail>> res = cdd.getCourseDetailById(cid);
        return JsonUtil.toJson(res);
    }
}
