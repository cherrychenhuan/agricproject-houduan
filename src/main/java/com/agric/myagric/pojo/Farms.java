package com.agric.myagric.pojo;


public class Farms {

  private long farmId;
  private String landTypeId;
  private String soilTypeId;
  private double area;
  private String location;
  private long climateType;
  private String managementUnit;


  public long getFarmId() {
    return farmId;
  }

  public void setFarmId(long farmId) {
    this.farmId = farmId;
  }


  public String getLandTypeId() {
    return landTypeId;
  }

  public void setLandTypeId(String landTypeId) {
    this.landTypeId = landTypeId;
  }


  public String getSoilTypeId() {
    return soilTypeId;
  }

  public void setSoilTypeId(String soilTypeId) {
    this.soilTypeId = soilTypeId;
  }


  public double getArea() {
    return area;
  }

  public void setArea(double area) {
    this.area = area;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public long getClimateType() {
    return climateType;
  }

  public void setClimateType(long climateType) {
    this.climateType = climateType;
  }


  public String getManagementUnit() {
    return managementUnit;
  }

  public void setManagementUnit(String managementUnit) {
    this.managementUnit = managementUnit;
  }

}
