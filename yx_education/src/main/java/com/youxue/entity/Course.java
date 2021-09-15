package com.youxue.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * @author chenxi
 */

public class Course {

  private long cid;
  private String courseName;
  private String descs;
  private long courseType;
  private String courseImage;
  private String courseVideo;
  private double coursePrice;
  private long status;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private java.sql.Timestamp createTime;


  public Course() {
  }

  public Course(long cid, String courseName, String descs, long courseType, String courseImage, String courseVideo, double coursePrice, long status, Timestamp createTime) {
    this.cid = cid;
    this.courseName = courseName;
    this.descs = descs;
    this.courseType = courseType;
    this.courseImage = courseImage;
    this.courseVideo = courseVideo;
    this.coursePrice = coursePrice;
    this.status = status;
    this.createTime = createTime;
  }

  public long getCid() {
    return cid;
  }

  public void setCid(long cid) {
    this.cid = cid;
  }


  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }


  public String getDescs() {
    return descs;
  }

  public void setDescs(String descs) {
    this.descs = descs;
  }


  public long getCourseType() {
    return courseType;
  }

  public void setCourseType(long courseType) {
    this.courseType = courseType;
  }


  public String getCourseImage() {
    return courseImage;
  }

  public void setCourseImage(String courseImage) {
    this.courseImage = courseImage;
  }


  public String getCourseVideo() {
    return courseVideo;
  }

  public void setCourseVideo(String courseVideo) {
    this.courseVideo = courseVideo;
  }


  public double getCoursePrice() {
    return coursePrice;
  }

  public void setCoursePrice(double coursePrice) {
    this.coursePrice = coursePrice;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "Course{" +
            "cid=" + cid +
            ", courseName='" + courseName + '\'' +
            ", descs='" + descs + '\'' +
            ", courseType=" + courseType +
            ", courseImage='" + courseImage + '\'' +
            ", courseVideo='" + courseVideo + '\'' +
            ", coursePrice=" + coursePrice +
            ", status=" + status +
            ", createTime=" + createTime +
            '}';
  }
}
