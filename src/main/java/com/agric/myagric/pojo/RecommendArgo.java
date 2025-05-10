package com.agric.myagric.pojo;

public class RecommendArgo {
    private long mid;
    private long flag;
    private String managename;
    private String userid;
    private java.sql.Timestamp createtime;
    private String areacode;
    private double lon;
    private double lat;
    private long cropCalendarid;
    private long argomid;
    private long landid;
    private java.sql.Date plandate;
    private String category;
    private String cropName;
    private String varietyName;
    private java.sql.Date cropStartDate;
    private String cropStartType;
    private java.sql.Date cropEndDate;
    private String cropEndType;
    private long maxDuration;
    public long getCropCalendarid() {
        return cropCalendarid;
    }

    public void setCropCalendarid(long cropCalendarid) {
        this.cropCalendarid = cropCalendarid;
    }


    public long getArgomid() {
        return argomid;
    }

    public void setArgomid(long argomid) {
        this.argomid = argomid;
    }


    public long getLandid() {
        return landid;
    }

    public void setLandid(long landid) {
        this.landid = landid;
    }


    public java.sql.Date getPlandate() {
        return plandate;
    }

    public void setPlandate(java.sql.Date plandate) {
        this.plandate = plandate;
    }


    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }


    public java.sql.Date getCropStartDate() {
        return cropStartDate;
    }

    public void setCropStartDate(java.sql.Date cropStartDate) {
        this.cropStartDate = cropStartDate;
    }


    public String getCropStartType() {
        return cropStartType;
    }

    public void setCropStartType(String cropStartType) {
        this.cropStartType = cropStartType;
    }


    public java.sql.Date getCropEndDate() {
        return cropEndDate;
    }

    public void setCropEndDate(java.sql.Date cropEndDate) {
        this.cropEndDate = cropEndDate;
    }


    public String getCropEndType() {
        return cropEndType;
    }

    public void setCropEndType(String cropEndType) {
        this.cropEndType = cropEndType;
    }


    public long getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(long maxDuration) {
        this.maxDuration = maxDuration;
    }
    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }


    public long getFlag() {
        return flag;
    }

    public void setFlag(long flag) {
        this.flag = flag;
    }


    public String getManagename() {
        return managename;
    }

    public void setManagename(String managename) {
        this.managename = managename;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


    public java.sql.Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(java.sql.Timestamp createtime) {
        this.createtime = createtime;
    }


    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }


    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

}
