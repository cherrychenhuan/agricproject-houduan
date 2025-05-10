package com.agric.myagric.pojo;



public class Comments {

  private long commentid;
  private String userid;
  private long topicid;
  private String content;
  private String commenttime;


  public long getCommentid() {
    return commentid;
  }

  public void setCommentid(long commentid) {
    this.commentid = commentid;
  }


  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }


  public long getTopicid() {
    return topicid;
  }

  public void setTopicid(long topicid) {
    this.topicid = topicid;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getCommenttime() {
    return commenttime;
  }

  public void setCommenttime(String commenttime) {
    this.commenttime = commenttime;
  }

}
