package com.agric.myagric.pojo;


public class CropFuture {

  private String cropid;
  private java.sql.Date date;
  private String cropname;
  private double priceHigh;
  private double priceLow;
  private double priceOpen;
  private double priceClose;


  public String getCropid() {
    return cropid;
  }

  public void setCropid(String cropid) {
    this.cropid = cropid;
  }


  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }


  public String getCropname() {
    return cropname;
  }

  public void setCropname(String cropname) {
    this.cropname = cropname;
  }


  public double getPriceHigh() {
    return priceHigh;
  }

  public void setPriceHigh(double priceHigh) {
    this.priceHigh = priceHigh;
  }


  public double getPriceLow() {
    return priceLow;
  }

  public void setPriceLow(double priceLow) {
    this.priceLow = priceLow;
  }


  public double getPriceOpen() {
    return priceOpen;
  }

  public void setPriceOpen(double priceOpen) {
    this.priceOpen = priceOpen;
  }


  public double getPriceClose() {
    return priceClose;
  }

  public void setPriceClose(double priceClose) {
    this.priceClose = priceClose;
  }

}
