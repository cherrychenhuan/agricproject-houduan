package com.agric.myagric.pojo;

public class StateeventMowing {

  private long stateeventid;
  private long cropCalendarid;
  private String eventState;
  private String zeroCondition;
  private double statenum;
  private double biomassRemaining;


  public long getStateeventid() {
    return stateeventid;
  }

  public void setStateeventid(long stateeventid) {
    this.stateeventid = stateeventid;
  }


  public long getCropCalendarid() {
    return cropCalendarid;
  }

  public void setCropCalendarid(long cropCalendarid) {
    this.cropCalendarid = cropCalendarid;
  }


  public String getEventState() {
    return eventState;
  }

  public void setEventState(String eventState) {
    this.eventState = eventState;
  }


  public String getZeroCondition() {
    return zeroCondition;
  }

  public void setZeroCondition(String zeroCondition) {
    this.zeroCondition = zeroCondition;
  }


  public double getStatenum() {
    return statenum;
  }

  public void setStatenum(double statenum) {
    this.statenum = statenum;
  }


  public double getBiomassRemaining() {
    return biomassRemaining;
  }

  public void setBiomassRemaining(double biomassRemaining) {
    this.biomassRemaining = biomassRemaining;
  }

}
