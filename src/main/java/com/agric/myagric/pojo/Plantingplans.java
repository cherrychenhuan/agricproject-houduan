package com.agric.myagric.pojo;


public class Plantingplans {

  private long planId;
  private long cropId;
  private String cropName;
  private java.sql.Date plantTime;
  private java.sql.Date plannedHarvestTime;
  private long farmId;
  private String plantMethod;
  private double quantity;
  private String fertilizer;
  private String pesticide;
  private String irrigationWay;
  private String recorder;


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


  public java.sql.Date getPlannedHarvestTime() {
    return plannedHarvestTime;
  }

  public void setPlannedHarvestTime(java.sql.Date plannedHarvestTime) {
    this.plannedHarvestTime = plannedHarvestTime;
  }


  public long getFarmId() {
    return farmId;
  }

  public void setFarmId(long farmId) {
    this.farmId = farmId;
  }


  public String getPlantMethod() {
    return plantMethod;
  }

  public void setPlantMethod(String plantMethod) {
    this.plantMethod = plantMethod;
  }


  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }


  public String getFertilizer() {
    return fertilizer;
  }

  public void setFertilizer(String fertilizer) {
    this.fertilizer = fertilizer;
  }


  public String getPesticide() {
    return pesticide;
  }

  public void setPesticide(String pesticide) {
    this.pesticide = pesticide;
  }


  public String getIrrigationWay() {
    return irrigationWay;
  }

  public void setIrrigationWay(String irrigationWay) {
    this.irrigationWay = irrigationWay;
  }


  public String getRecorder() {
    return recorder;
  }

  public void setRecorder(String recorder) {
    this.recorder = recorder;
  }

}
