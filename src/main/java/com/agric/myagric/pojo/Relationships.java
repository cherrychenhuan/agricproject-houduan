package com.agric.myagric.pojo;


public class Relationships {

  private long id;
  private String userId;
  private String followerId;
  private java.sql.Timestamp followTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getFollowerId() {
    return followerId;
  }

  public void setFollowerId(String followerId) {
    this.followerId = followerId;
  }


  public java.sql.Timestamp getFollowTime() {
    return followTime;
  }

  public void setFollowTime(java.sql.Timestamp followTime) {
    this.followTime = followTime;
  }

}
