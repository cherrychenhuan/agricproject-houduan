package com.agric.myagric.pojo;


public class Cropfertilization {

  private long recordId;
  private String cropName;
  private java.sql.Date plantingDate;
  private java.sql.Time fertilizationTime;
  private String fertilizationLocation;
  private String fertilizationMethod;
  private double fertilizationQuantity;
  private String fertilizerType;
  private String operator;
  private String remarks;


  public long getRecordId() {
    return recordId;
  }

  public void setRecordId(long recordId) {
    this.recordId = recordId;
  }


  public String getCropName() {
    return cropName;
  }

  public void setCropName(String cropName) {
    this.cropName = cropName;
  }


  public java.sql.Date getPlantingDate() {
    return plantingDate;
  }

  public void setPlantingDate(java.sql.Date plantingDate) {
    this.plantingDate = plantingDate;
  }


  public java.sql.Time getFertilizationTime() {
    return fertilizationTime;
  }

  public void setFertilizationTime(java.sql.Time fertilizationTime) {
    this.fertilizationTime = fertilizationTime;
  }


  public String getFertilizationLocation() {
    return fertilizationLocation;
  }

  public void setFertilizationLocation(String fertilizationLocation) {
    this.fertilizationLocation = fertilizationLocation;
  }


  public String getFertilizationMethod() {
    return fertilizationMethod;
  }

  public void setFertilizationMethod(String fertilizationMethod) {
    this.fertilizationMethod = fertilizationMethod;
  }


  public double getFertilizationQuantity() {
    return fertilizationQuantity;
  }

  public void setFertilizationQuantity(double fertilizationQuantity) {
    this.fertilizationQuantity = fertilizationQuantity;
  }


  public String getFertilizerType() {
    return fertilizerType;
  }

  public void setFertilizerType(String fertilizerType) {
    this.fertilizerType = fertilizerType;
  }


  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

}
