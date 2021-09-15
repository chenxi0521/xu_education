package com.youxue.entity;


/**
 * @author chenxi
 */
public class CourseDetail {

  private long id;
  private String name;
  private String type;
  private String url;
  private String start_data;
  private long cid;

  public CourseDetail() {
  }

  public CourseDetail(long id, String name, String type, String url, String start_data, long cid) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.url = url;
    this.start_data = start_data;
    this.cid = cid;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getStart_data() {
    return start_data;
  }

  public void setStart_data(String startData) {
    this.start_data = startData;
  }


  public long getCid() {
    return cid;
  }

  public void setCid(long cid) {
    this.cid = cid;
  }

  @Override
  public String toString() {
    return "CourseDetail{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", url='" + url + '\'' +
            ", startData='" + start_data + '\'' +
            ", cid=" + cid +
            '}';
  }
}
