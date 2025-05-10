package com.agric.myagric.pojo;


public class Landtypes {

  private String typeId;
  private String typename;
  private long typelevel;
  private long parentNodeId;
  private long isParentFlag;
  private String ancester;
  private String description;


  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }


  public String getTypename() {
    return typename;
  }

  public void setTypename(String typename) {
    this.typename = typename;
  }


  public long getTypelevel() {
    return typelevel;
  }

  public void setTypelevel(long typelevel) {
    this.typelevel = typelevel;
  }


  public long getParentNodeId() {
    return parentNodeId;
  }

  public void setParentNodeId(long parentNodeId) {
    this.parentNodeId = parentNodeId;
  }


  public long getIsParentFlag() {
    return isParentFlag;
  }

  public void setIsParentFlag(long isParentFlag) {
    this.isParentFlag = isParentFlag;
  }


  public String getAncester() {
    return ancester;
  }

  public void setAncester(String ancester) {
    this.ancester = ancester;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
