package com.youxue.entity;


/**
 * @author chenxi
 */
public class CourseUser {

  private long id;
  private long cid;
  private long uid;
  private Course course;
  private User user;

  public CourseUser() {
  }

  public CourseUser(long id, long cid, long uid) {
    this.id = id;
    this.cid = cid;
    this.uid = uid;
  }

  public CourseUser(long id, long cid, long uid, Course course, User user) {
    this.id = id;
    this.cid = cid;
    this.uid = uid;
    this.course = course;
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCid() {
    return cid;
  }

  public void setCid(long cid) {
    this.cid = cid;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "CourseUser{" +
            "id=" + id +
            ", cid=" + cid +
            ", uid=" + uid +
            ", course=" + course +
            ", user=" + user +
            '}';
  }
}
