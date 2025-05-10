package com.agric.myagric.pojo;


public class Climatedata {

  private String id;
  private String area;
  private double lat;
  private double lon;
  private java.sql.Date date;
  private long irrad;
  private double tmin;
  private double tmax;
  private double vap;
  private double wind;
  private double rain;
  private String snowdepth;
  private String notes;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }


  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }


  public double getLon() {
    return lon;
  }

  public void setLon(double lon) {
    this.lon = lon;
  }


  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }


  public long getIrrad() {
    return irrad;
  }

  public void setIrrad(long irrad) {
    this.irrad = irrad;
  }


  public double getTmin() {
    return tmin;
  }

  public void setTmin(double tmin) {
    this.tmin = tmin;
  }


  public double getTmax() {
    return tmax;
  }

  public void setTmax(double tmax) {
    this.tmax = tmax;
  }


  public double getVap() {
    return vap;
  }

  public void setVap(double vap) {
    this.vap = vap;
  }


  public double getWind() {
    return wind;
  }

  public void setWind(double wind) {
    this.wind = wind;
  }


  public double getRain() {
    return rain;
  }

  public void setRain(double rain) {
    this.rain = rain;
  }


  public String getSnowdepth() {
    return snowdepth;
  }

  public void setSnowdepth(String snowdepth) {
    this.snowdepth = snowdepth;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
