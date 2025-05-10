package com.agric.myagric.pojo;

public class Soil {
    private int id;
    private String soiltype;

    public Soil(int id, String soiltype){
        this.id=id;
        this.soiltype=soiltype;
    }

    public Integer getID(){return id;}
    public void setID (int id){this.id=id;}
    public String getSoiltype(){return soiltype;}
    public void setSoiltype(String soiltype){this.soiltype=soiltype;}

}
