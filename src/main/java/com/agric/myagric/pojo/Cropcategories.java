package com.agric.myagric.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Cropcategories {
  @NotNull
  private int id;
  @NotNull
  private String cropname;
  private String englishname;

  @NotNull
  private String category;
  private String family;
  private String genus;
  private String phenotype;
  private String cultivationType;
  private String distribution;
  private String cropusage;
  private String remark;

  private Integer imgNum; //初始化的时候一定要用Integer 如果数据库中有一个字段名为 my_value，对应的实体类属性应该是 myValue，而不是 my_value。Spring Boot 的 JPA 通常会在查询时自动进行这种映射。

  public Integer getImgNum() {
    return imgNum;
  }

  public void setImgNum(Integer imgNum) {
    this.imgNum = imgNum;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getCropname() {
    return cropname;
  }

  public void setCropname(String cropname) {
    this.cropname = cropname;
  }

  public String getEnglishname() {
    return englishname;
  }

  public void setEnglishname(String englishname) {
    this.englishname = englishname;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  public String getFamily() {
    return family;
  }

  public void setFamily(String family) {
    this.family = family;
  }


  public String getGenus() {
    return genus;
  }

  public void setGenus(String genus) {
    this.genus = genus;
  }

  public String getPhenotype() {
    return phenotype;
  }

  public void setPhenotype(String phenotype) {
    this.phenotype = phenotype;
  }

  public String getCultivationType() {
    return cultivationType;
  }

  public void setCultivationType(String cultivationType) {
    this.cultivationType = cultivationType;
  }


  public String getDistribution() {
    return distribution;
  }

  public void setDistribution(String distribution) {
    this.distribution = distribution;
  }


  public String getCropusage() {
    return cropusage;
  }

  public void setCropusage(String cropusage) {
    this.cropusage = cropusage;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
