package com.agric.myagric.pojo;

public class CropProductinfo {

  private String provinceCode;
  private String provinceName;
  private long cropid;
  private String cropname;
  private long xyear;
  private double areaSeed;
  private double yieldTotal;
  private double yieldUnit;


  public String getProvinceCode() {
    return provinceCode;
  }

  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode;
  }


  public String getProvinceName() {
    return provinceName;
  }

  public void setProvinceName(String provinceName) {
    this.provinceName = provinceName;
  }


  public long getCropid() {
    return cropid;
  }

  public void setCropid(long cropid) {
    this.cropid = cropid;
  }


  public String getCropname() {
    return cropname;
  }

  public void setCropname(String cropname) {
    this.cropname = cropname;
  }


  public long getXyear() {
    return xyear;
  }

  public void setXyear(long xyear) {
    this.xyear = xyear;
  }


  public double getAreaSeed() {
    return areaSeed;
  }

  public void setAreaSeed(double areaSeed) {
    this.areaSeed = areaSeed;
  }


  public double getYieldTotal() {
    return yieldTotal;
  }

  public void setYieldTotal(double yieldTotal) {
    this.yieldTotal = yieldTotal;
  }


  public double getYieldUnit() {
    return yieldUnit;
  }

  public void setYieldUnit(double yieldUnit) {
    this.yieldUnit = yieldUnit;
  }

}
