package com.agric.myagric.mapper;

import com.agric.myagric.pojo.PageBean;
import com.agric.myagric.pojo.Weatherdata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
public interface WeatherMapper {
    @Select("select * from weatherdata where areacode=#{code} or (round(lat,2)=round(#{lat},2) and round(lon,2)=round(#{lon},2)) order by date")
    List<Weatherdata> getWeatherData(String code,Double lat,Double lon);

    @Select("select distinct year(date) as year from weatherdata where areacode=#{code} or (round(lat,2)=round(#{lat},2) and round(lon,2)=round(#{lon},2)) order by date")
    List<Integer> getYearList(String code, Double lat, Double lon);

    @Select("select * from weatherdata where (areacode=#{code} or (round(lat,2)=round(#{lat},2) and round(lon,2)=round(#{lon},2))) and (year(date) in (${yearstr}))")
    List<Weatherdata> filterWeartherData(String code, String yearstr, Double lat, Double lon);

    @Select("delete from weatherdata where (areacode=#{code} or (round(lat,2)=round(#{lat},2) and round(lon,2)=round(#{lon},2))) and (year(date) in (${yearstr}))")
    void deleteWeatherData(String yearstr, String code, Double lat, Double lon, Double lat1);
}
