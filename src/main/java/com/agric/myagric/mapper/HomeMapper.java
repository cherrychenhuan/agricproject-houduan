package com.agric.myagric.mapper;

import com.agric.myagric.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
@Configuration
public interface HomeMapper {
    @Select("select * from crop_productinfo where cropname=#{cropname} and cropid=0 and xyear=#{year}")
    List<CropProductinfo> getCropProductAll(String cropname,Integer year);

    @Select("select * from crop_producttrend where cropname=#{cropname} and provinceCode=#{province}")
    List<CropProducttrend> getCropProductByProvince(String cropname, String province);

    @Select("select * from crop_productinfo where cropname=#{cropname} and xyear=#{year} ")
    List<CropProductinfo> getCropProduct(String cropname, Integer year);

    @Select("select * from crop_consume where cropname=#{cropname}")
    List<CropConsume> getCropConsume(String cropname);

    @Select("select * from crop_wholesaleprice where cropname=#{cropname} and date=#{date}")
    List<CropWholesaleprice> getPifaPrice(String cropname, String date);

    @Select("select date,avg(price_market)as avgprice from crop_wholesaleprice where cropname=#{cropname} and date>=#{date1} and date<=#{date2} group by date order by date")
    List<AvgPriceByday> getPifaPriceTrend(String cropname, String date1, String date2);

    @Select("select * from crop_future where cropname=#{cropname} and date>=#{date1} and date<=#{date2} order by date")
    List<CropFuture> getPriceFuture(String cropname, String date1, String date2);

    @Select("select * from Costprofitdata where cropname=#{cropname} and year=#{year} and type=#{type} order by value desc")
    List<Costprofitdata> getCropCost(String cropname, String year,String type);

    @Select("select * from Costprofitdata where cropname=#{cropname} and province=#{province}")
    List<Costprofitdata> getCropCostData(String province, String cropname);
}
