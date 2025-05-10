package com.agric.myagric.pojo;


public class Cropharvest {

  private long recordId;
  private String cropName;
  private java.sql.Time harvestTime;
  private String location;
  private String method;
  private double yield;
  private String operator;
  private String remarks;


  public long getRecordId() {
    return recordId;
  }

  public void setRecordId(long recordId) {
    this.recordId = recordId;
  }


  public String getCropName() {
    return cropName;
  }

  public void setCropName(String cropName) {
    this.cropName = cropName;
  }


  public java.sql.Time getHarvestTime() {
    return harvestTime;
  }

  public void setHarvestTime(java.sql.Time harvestTime) {
    this.harvestTime = harvestTime;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }


  public double getYield() {
    return yield;
  }

  public void setYield(double yield) {
    this.yield = yield;
  }


  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

}
