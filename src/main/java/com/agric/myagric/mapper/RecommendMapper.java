package com.agric.myagric.mapper;


import com.agric.myagric.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
@Configuration
public interface RecommendMapper {
    @Select("select * from weatherdata where areacode=#{code} and year(date)>=#{byear} and year(date)<=#{eyear}")
    List<Weatherdata> getClimateData(String code,String byear,String eyear);

    @Select("select * from weatherdata where areacode=#{code} and year(date)=#{x0}")
    List<Weatherdata> getClimateData0(String code, String x0);

    @Select("select * from soil_hwsd  where round(lng_84,#{x})=round(#{lon},#{x}) and round(lat_84,#{x})=round(#{lat},#{x})")
    List<SoilHwsd> getHwsdData(double lon, double lat,int x);

    @Select("select * from soil_cropdata where round(lon,#{x})=round(#{lon},#{x}) and round(lat,#{x})=round(#{lat},#{x})")
    List<SoilCropdata> getSoilCropdata(double lon, double lat, int x);

    @Select("select * from soil_category_fao90 where symbol=#{id}")
    List<SoilCategoryFao90> getSoilname(String id);

    @Select("select * from wofostresult where lon=#{lon} and lat=#{lat} and areacode=#{areacode} and year(day)>=#{byear} and year(day)<=#{eyear} and #{cropids} like concat('%',cropid,'%')")
    List<Wofostresult> getHistoryGrowData(double lon, double lat, String areacode,String cropids,Integer byear,Integer eyear);

    @Select("select * from wofostresult where areacode=#{areacode} and cropid=#{cropid}")
    List<Wofostresult> getHistoryGrowDataBycropid(String areacode, Integer cropid);

    @Select("select * from Costprofitdata where province=#{province} and cropid=#{cropid}")
    List<Costprofitdata> getCostData(String province, Integer cropid);

    @Select("select year(day) as xyear,max(twso) as mtwso from wofostresult where areacode=#{areacode} and cropid=#{cropid} group by year(day)")
    List<MaxProduct> getCropProductData(String areacode, Integer cropid);

    @Select("select * from crop_productinfo where provinceName=#{province} and cropid=#{cropid}")
    List<CropProductinfo> getCropProductByProvince(String province, Integer cropid);

    @Select("select avg(value) as avgprofit from costprofitdata where cropid=#{cropid} and province=#{province} and type='profit'")
    Double getAvgprofit(String province, Integer cropid);

    @Select("select avg(yieldUnit) as avgyeild from crop_productinfo where provinceName=#{province} and cropid=#{cropid}")
    Double getAvgyeild(String province, Integer cropid);


    @Select("with tmp as(select year(day) as xyear,max(twso) as mtwso from wofostresult where areacode=#{areacode} and cropid=#{cropid} group by year(day)) select avg(mtwso) as avgModelYield from tmp")
    Double getAvgModelYeild(String areacode, Integer cropid);

    @Select("select * from wofostresult where areacode=#{areacode} and cropid=#{cropid} and year(day)=#{year}")
    List<Wofostresult> getHistoryGrowDataByYear(double lon, double lat, String areacode, Integer cropid, String year);

    @Select("select * from agromanagement a join cropcalendar b on a.mid=b.argomid where flag=1 and userid=#{userid} and areacode=#{areacode} and crop_name=#{cropname}")
    List<RecommendArgo> getRecommendRecord(String userid, String areacode, String cropname);

    @Insert("insert into recommendindex(avgModelYield,avgProfit,avgYield,cropid,cropname,xindex,star,xtype,userid,createtime,pid,areacode) values(#{avgModelYield},#{avgProfit},#{avgYeild},#{cropid},#{cropname},#{index},#{star},#{type},#{userid},#{createtime},#{pid},#{areacode})")
    void addRecommendIndexData(Double avgModelYield, Double avgProfit, Double avgYeild, Integer cropid, String cropname, Double index, Double star, Integer type, String userid, String createtime, String pid, String areacode);

    @Select("select avg(value) as avgprofit from costprofitdata where cropid=#{cropid} and province=#{province} and type='cost'")
    Double getAvgcost(String province, Integer cropid);

    @Insert("insert into crop_productinfo(provinceName,cropid,cropname,xyear,yieldTotal,yieldUnit) values(#{provinceName},#{cropid},#{cropname},#{xyear},#{yieldTotal},#{yieldUnit})")
    void addYieldData(Integer cropid, String cropname, String provinceName, Integer xyear, Double yieldTotal, Double yieldUnit);
}
