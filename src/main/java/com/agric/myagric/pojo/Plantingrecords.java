package com.agric.myagric.pojo;


public class Plantingrecords {

  private long plantId;
  private long planId;
  private long cropId;
  private String cropName;
  private java.sql.Date plantTime;
  private long farmId;
  private double plantQuantity;
  private String plantPeople;


  public long getPlantId() {
    return plantId;
  }

  public void setPlantId(long plantId) {
    this.plantId = plantId;
  }


  public long getPlanId() {
    return planId;
  }

  public void setPlanId(long planId) {
    this.planId = planId;
  }


  public long getCropId() {
    return cropId;
  }

  public void setCropId(long cropId) {
    this.cropId = cropId;
  }


  public String getCropName() {
    return cropName;
  }

  public void setCropName(String cropName) {
    this.cropName = cropName;
  }


  public java.sql.Date getPlantTime() {
    return plantTime;
  }

  public void setPlantTime(java.sql.Date plantTime) {
    this.plantTime = plantTime;
  }


  public long getFarmId() {
    return farmId;
  }

  public void setFarmId(long farmId) {
    this.farmId = farmId;
  }


  public double getPlantQuantity() {
    return plantQuantity;
  }

  public void setPlantQuantity(double plantQuantity) {
    this.plantQuantity = plantQuantity;
  }


  public String getPlantPeople() {
    return plantPeople;
  }

  public void setPlantPeople(String plantPeople) {
    this.plantPeople = plantPeople;
  }

}
