package com.agric.myagric.service;

import com.agric.myagric.pojo.*;

import java.io.IOException;
import java.util.List;

public interface RecommendService {
    void RunPython(double lon, double lat,String code,String byear,String eyear) throws IOException;

    List<Weatherdata> getClimateData(String code,String byear,String eyear);

    List<Weatherdata> getClimateData0(String code, String x0);

    List<SoilHwsd> getHwsdData(double lon, double lat,int x);

    List<SoilCropdata> SoilCropdata(double lon, double lat, int i);

    List<SoilCategoryFao90> getSoilname(String id);

    void generateHistoryGrowData(double lon, double lat, String areacode, Integer cropid, String year) throws IOException ;

    PageBean<Wofostresult> getHistoryGrowData(Integer pageNum,Integer pageSize,double lon, double lat, String areacode,String cropids,Integer byear,Integer eyear);

    List<Wofostresult> getHistoryGrowDataBycropid(String areacode, Integer cropid);

    List<Costprofitdata> getCostData(String province, Integer cropid);

    List<MaxProduct> getCropProductData(String areacode, Integer cropid);

    List<CropProductinfo> getCropProductByProvince(String province, Integer cropid);

    List<Double> getRecommendIndex(String areacode, String province, Integer cropid);

    String getRecommendProject(double lon, double lat, String areacode, Integer cropid, String year);

    List<RecommendArgo> getRecommendRecord(String userid, String areacode, String cropname);

    void addRecommendIndexData(Double avgModelYield, Double avgProfit, Double avgYeild, Integer cropid, String cropname, Double index, Double star, Integer type, String userid, String createtime, String pid, String areacode);

    void addYieldData(Integer cropid, String cropname, String provinceName, Integer xyear, Double yieldTotal, Double yieldUnit);

    String getWeight(String data);
}
