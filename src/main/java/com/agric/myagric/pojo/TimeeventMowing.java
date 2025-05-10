package com.agric.myagric.pojo;


public class TimeeventMowing {

  private long timeeventid;
  private long cropCalendarid;
  private java.sql.Date date;
  private double biomassRemaining;


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


  public double getBiomassRemaining() {
    return biomassRemaining;
  }

  public void setBiomassRemaining(double biomassRemaining) {
    this.biomassRemaining = biomassRemaining;
  }

}
