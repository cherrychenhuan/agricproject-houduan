package com.agric.myagric.controller;

import com.agric.myagric.pojo.*;
import com.agric.myagric.service.AreaService;
import com.agric.myagric.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(value = {"/weather"},method = RequestMethod.OPTIONS)
public class WeatherController {
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private AreaService areaService;

    @GetMapping("/getYearList")
    public Result<List<Integer>> getYearList(
            String code,
            Double lat,
            Double lon
    ){
        List<Integer> yearList = weatherService.getYearList(code,lat,lon);
        return Result.success(yearList);
    }
    @GetMapping("/getWeatherData")
    public Result<PageBean<Weatherdata>> getWeatherData(
            Integer pageNum,
            Integer pageSize,
            String code
    ){
        Double lat=null;
        Double lon=null;
        List<AreaVillages> vs = areaService.getLocation(code,1);
        if (vs != null && !vs.isEmpty()) {
            AreaVillages areadata = vs.get(0);
            if (areadata != null) {
                lon = areadata.getLng84();
                lat = areadata.getLat84();
                System.out.println("经度：" + lon);
                System.out.println("纬度：" + lat);
            }
        }
        PageBean<Weatherdata> pb =  weatherService.getWeatherData(pageNum,pageSize,code,lat,lon);
        return Result.success(pb);
    }

    @GetMapping("/filterWeartherData")
    public Result<PageBean<Weatherdata>> getWeatherData(
            String yearstr,
            Integer pageNum,
            Integer pageSize,
            String code,
            Double lat,
            Double lon
    ){

        System.out.println(pageNum);
        System.out.println(pageSize);
        System.out.println(yearstr);
        PageBean<Weatherdata> pb =  weatherService.filterWeartherData(pageNum,pageSize,yearstr,code,lat,lon);
        return Result.success(pb);
    }

    @GetMapping("/deleteWeatherData")
    public Result deleteWeatherData(
            String code,
            Double lat,
            Double lon,
            String yearstr
    ){
        weatherService.deleteWeatherData(yearstr,code,lat,lon);
        return Result.success();
    }

    //获取预报数据
    @GetMapping("/getForecastData")
    public Result<String> getForecastData(String province,String city){
        String x=weatherService.getForecastData(province,city);
        return Result.success(x);
    }

}
