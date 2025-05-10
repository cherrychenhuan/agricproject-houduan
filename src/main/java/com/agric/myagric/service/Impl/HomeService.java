package com.agric.myagric.service;

import com.agric.myagric.pojo.*;

import java.util.List;

public interface HomeService {
    List<CropProductinfo> getCropProductAll(String cropname,Integer year,Integer flag);

    List<CropProducttrend> getCropProductByProvince(String cropname, String province);

    List<CropConsume> getCropConsume(String cropname);

    List<CropWholesaleprice> getPifaPrice(String cropname, String date);

    List<AvgPriceByday> getPifaPriceTrend(String cropname, String date1, String date2);

    List<CropFuture> getPriceFuture(String cropname, String date1, String date2);

    List<Costprofitdata> getCropCost(String cropname, String year,String type);

    List<Costprofitdata> getCropCostData(String province, String cropname);
}
