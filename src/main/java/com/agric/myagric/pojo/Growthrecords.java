package com.agric.myagric.pojo;


public class Growthrecords {

  private String recordId;
  private long plantId;
  private long varietyId;
  private String cropName;
  private java.sql.Date plantTime;
  private String farm;
  private String growthStage;
  private String growthStatus;
  private String diseaseStatus;
  private String yieldStatus;
  private String remarks;


  public String getRecordId() {
    return recordId;
  }

  public void setRecordId(String recordId) {
    this.recordId = recordId;
  }


  public long getPlantId() {
    return plantId;
  }

  public void setPlantId(long plantId) {
    this.plantId = plantId;
  }


  public long getVarietyId() {
    return varietyId;
  }

  public void setVarietyId(long varietyId) {
    this.varietyId = varietyId;
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


  public String getFarm() {
    return farm;
  }

  public void setFarm(String farm) {
    this.farm = farm;
  }


  public String getGrowthStage() {
    return growthStage;
  }

  public void setGrowthStage(String growthStage) {
    this.growthStage = growthStage;
  }


  public String getGrowthStatus() {
    return growthStatus;
  }

  public void setGrowthStatus(String growthStatus) {
    this.growthStatus = growthStatus;
  }


  public String getDiseaseStatus() {
    return diseaseStatus;
  }

  public void setDiseaseStatus(String diseaseStatus) {
    this.diseaseStatus = diseaseStatus;
  }


  public String getYieldStatus() {
    return yieldStatus;
  }

  public void setYieldStatus(String yieldStatus) {
    this.yieldStatus = yieldStatus;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

}
