package com.agric.myagric.pojo;


public class Cropcalendar {

  private long cropCalendarid;
  private long argomid;
  private long landid;
  private java.sql.Date plandate;
  private String category;
  private String cropName;
  private String varietyName;
  private java.sql.Date cropStartDate;
  private String cropStartType;
  private java.sql.Date cropEndDate;
  private String cropEndType;
  private long maxDuration;


  public long getCropCalendarid() {
    return cropCalendarid;
  }

  public void setCropCalendarid(long cropCalendarid) {
    this.cropCalendarid = cropCalendarid;
  }


  public long getArgomid() {
    return argomid;
  }

  public void setArgomid(long argomid) {
    this.argomid = argomid;
  }


  public long getLandid() {
    return landid;
  }

  public void setLandid(long landid) {
    this.landid = landid;
  }


  public java.sql.Date getPlandate() {
    return plandate;
  }

  public void setPlandate(java.sql.Date plandate) {
    this.plandate = plandate;
  }


  public String getCropName() {
    return cropName;
  }

  public void setCropName(String cropName) {
    this.cropName = cropName;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
  public String getVarietyName() {
    return varietyName;
  }

  public void setVarietyName(String varietyName) {
    this.varietyName = varietyName;
  }


  public java.sql.Date getCropStartDate() {
    return cropStartDate;
  }

  public void setCropStartDate(java.sql.Date cropStartDate) {
    this.cropStartDate = cropStartDate;
  }


  public String getCropStartType() {
    return cropStartType;
  }

  public void setCropStartType(String cropStartType) {
    this.cropStartType = cropStartType;
  }


  public java.sql.Date getCropEndDate() {
    return cropEndDate;
  }

  public void setCropEndDate(java.sql.Date cropEndDate) {
    this.cropEndDate = cropEndDate;
  }


  public String getCropEndType() {
    return cropEndType;
  }

  public void setCropEndType(String cropEndType) {
    this.cropEndType = cropEndType;
  }


  public long getMaxDuration() {
    return maxDuration;
  }

  public void setMaxDuration(long maxDuration) {
    this.maxDuration = maxDuration;
  }

}
