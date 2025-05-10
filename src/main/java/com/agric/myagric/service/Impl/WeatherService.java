package com.agric.myagric.service;

import com.agric.myagric.pojo.PageBean;
import com.agric.myagric.pojo.Result;
import com.agric.myagric.pojo.Weatherdata;

import java.util.List;

public interface WeatherService {

    PageBean<Weatherdata> getWeatherData(Integer pageNum, Integer pageSize, String code,Double lat,Double lon);

    List<Integer> getYearList(String code, Double lat, Double lon);

    PageBean<Weatherdata> filterWeartherData(Integer pageNum, Integer pageSize, String yearstr, String code, Double lat, Double lon);

    void deleteWeatherData(String yearstr, String code, Double lat, Double lon);

   String getForecastData(String province,String city);
}
