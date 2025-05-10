package com.agric.myagric.pojo;


public class Weatherdata {

  private long id;
  private String areacode;
  private double lat;
  private double lon;
  private java.sql.Date date;
  private double tmax;
  private double tmin;
  private double temp;
  private double irrad;
  private double rain;
  private double wind;
  private double vap;
  private String snowdepth;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAreacode() {
    return areacode;
  }

  public void setAreacode(String areacode) {
    this.areacode = areacode;
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


  public double getTmax() {
    return tmax;
  }

  public void setTmax(double tmax) {
    this.tmax = tmax;
  }


  public double getTmin() {
    return tmin;
  }

  public void setTmin(double tmin) {
    this.tmin = tmin;
  }


  public double getTemp() {
    return temp;
  }

  public void setTemp(double temp) {
    this.temp = temp;
  }


  public double getIrrad() {
    return irrad;
  }

  public void setIrrad(double irrad) {
    this.irrad = irrad;
  }


  public double getRain() {
    return rain;
  }

  public void setRain(double rain) {
    this.rain = rain;
  }


  public double getWind() {
    return wind;
  }

  public void setWind(double wind) {
    this.wind = wind;
  }


  public double getVap() {
    return vap;
  }

  public void setVap(double vap) {
    this.vap = vap;
  }


  public String getSnowdepth() {
    return snowdepth;
  }

  public void setSnowdepth(String snowdepth) {
    this.snowdepth = snowdepth;
  }

}
