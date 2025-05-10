package com.agric.myagric.pojo;


public class Agromanagement {

  private long mid;
  private long flag;
  private String managename;
  private String userid;
  private String createtime;
  private String areacode;
  private double lon;
  private double lat;


  public long getMid() {
    return mid;
  }

  public void setMid(long mid) {
    this.mid = mid;
  }


  public long getFlag() {
    return flag;
  }

  public void setFlag(long flag) {
    this.flag = flag;
  }


  public String getManagename() {
    return managename;
  }

  public void setManagename(String managename) {
    this.managename = managename;
  }


  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }


  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }


  public String getAreacode() {
    return areacode;
  }

  public void setAreacode(String areacode) {
    this.areacode = areacode;
  }


  public double getLon() {
    return lon;
  }

  public void setLon(double lon) {
    this.lon = lon;
  }


  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }

}
