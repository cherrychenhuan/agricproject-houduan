package com.agric.myagric.pojo;


public class Recommendationrecords {

  private long recordId;
  private String userId;
  private java.sql.Timestamp recordTime;
  private String location;
  private long soilTypeId;
  private String climateType;
  private String mainCrops;


  public long getRecordId() {
    return recordId;
  }

  public void setRecordId(long recordId) {
    this.recordId = recordId;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getRecordTime() {
    return recordTime;
  }

  public void setRecordTime(java.sql.Timestamp recordTime) {
    this.recordTime = recordTime;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public long getSoilTypeId() {
    return soilTypeId;
  }

  public void setSoilTypeId(long soilTypeId) {
    this.soilTypeId = soilTypeId;
  }


  public String getClimateType() {
    return climateType;
  }

  public void setClimateType(String climateType) {
    this.climateType = climateType;
  }


  public String getMainCrops() {
    return mainCrops;
  }

  public void setMainCrops(String mainCrops) {
    this.mainCrops = mainCrops;
  }

}
