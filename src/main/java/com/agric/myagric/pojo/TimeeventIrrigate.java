package com.agric.myagric.pojo;


public class TimeeventIrrigate {

  private long timeeventid;
  private long cropCalendarid;
  private java.sql.Date date;
  private double irrigationAmount;


  public long getTimeeventid() {
    return timeeventid;
  }

  public void setTimeeventid(long timeeventid) {
    this.timeeventid = timeeventid;
  }


  public long getCropCalendarid() {
    return cropCalendarid;
  }

  public void setCropCalendarid(long cropCalendarid) {
    this.cropCalendarid = cropCalendarid;
  }


  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }


  public double getIrrigationAmount() {
    return irrigationAmount;
  }

  public void setIrrigationAmount(double irrigationAmount) {
    this.irrigationAmount = irrigationAmount;
  }

}
