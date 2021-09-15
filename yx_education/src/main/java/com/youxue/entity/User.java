package com.youxue.entity;


import java.sql.Timestamp;

/**
 * @author chenxi
 */
public class User {

  private long uid;
  private String name;
  private String phone;
  private long age;
  private long sex;
  private String username;
  private String password;
  private long status;
  private java.sql.Timestamp createtime;
  private long role;
  private String picture;

  public User() {
  }

  public User(long uid, String name, String phone, long age, long sex, String username, String password, long status, Timestamp createtime, long role, String picture) {
    this.uid = uid;
    this.name = name;
    this.phone = phone;
    this.age = age;
    this.sex = sex;
    this.username = username;
    this.password = password;
    this.status = status;
    this.createtime = createtime;
    this.role = role;
    this.picture = picture;
  }

  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public long getSex() {
    return sex;
  }

  public void setSex(long sex) {
    this.sex = sex;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public long getRole() {
    return role;
  }

  public void setRole(long role) {
    this.role = role;
  }


  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  @Override
  public String toString() {
    return "User{" +
            "uid=" + uid +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", age=" + age +
            ", sex=" + sex +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", status=" + status +
            ", createtime=" + createtime +
            ", role=" + role +
            ", picture='" + picture + '\'' +
            '}';
  }
}
