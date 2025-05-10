package com.agric.myagric.pojo;


public class Seeds {

  private long seedId;
  private long varietyId;
  private String seedName;
  private String seedSource;
  private double seedPurity;
  private double germinationRate;
  private double sowingRate;
  private String cultivationTechniques;
  private String harvestingMethods;
  private String notes;


  public long getSeedId() {
    return seedId;
  }

  public void setSeedId(long seedId) {
    this.seedId = seedId;
  }


  public long getVarietyId() {
    return varietyId;
  }

  public void setVarietyId(long varietyId) {
    this.varietyId = varietyId;
  }


  public String getSeedName() {
    return seedName;
  }

  public void setSeedName(String seedName) {
    this.seedName = seedName;
  }


  public String getSeedSource() {
    return seedSource;
  }

  public void setSeedSource(String seedSource) {
    this.seedSource = seedSource;
  }


  public double getSeedPurity() {
    return seedPurity;
  }

  public void setSeedPurity(double seedPurity) {
    this.seedPurity = seedPurity;
  }


  public double getGerminationRate() {
    return germinationRate;
  }

  public void setGerminationRate(double germinationRate) {
    this.germinationRate = germinationRate;
  }


  public double getSowingRate() {
    return sowingRate;
  }

  public void setSowingRate(double sowingRate) {
    this.sowingRate = sowingRate;
  }


  public String getCultivationTechniques() {
    return cultivationTechniques;
  }

  public void setCultivationTechniques(String cultivationTechniques) {
    this.cultivationTechniques = cultivationTechniques;
  }


  public String getHarvestingMethods() {
    return harvestingMethods;
  }

  public void setHarvestingMethods(String harvestingMethods) {
    this.harvestingMethods = harvestingMethods;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
