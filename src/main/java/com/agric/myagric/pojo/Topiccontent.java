package com.agric.myagric.pojo;


public class Topiccontent {

  private long topicId;
  private String commentUserId;
  private java.sql.Timestamp commentTime;
  private String commentText;


  public long getTopicId() {
    return topicId;
  }

  public void setTopicId(long topicId) {
    this.topicId = topicId;
  }


  public String getCommentUserId() {
    return commentUserId;
  }

  public void setCommentUserId(String commentUserId) {
    this.commentUserId = commentUserId;
  }


  public java.sql.Timestamp getCommentTime() {
    return commentTime;
  }

  public void setCommentTime(java.sql.Timestamp commentTime) {
    this.commentTime = commentTime;
  }


  public String getCommentText() {
    return commentText;
  }

  public void setCommentText(String commentText) {
    this.commentText = commentText;
  }

}
