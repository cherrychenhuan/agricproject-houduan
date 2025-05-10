package com.agric.myagric.controller;

import com.agric.myagric.pojo.*;
import com.agric.myagric.service.RecommendService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(value = {"/recommend"},method = RequestMethod.OPTIONS)
public class RecommendController {
    @Autowired
    private RecommendService recommendService;

    @GetMapping("/gethwsddata")
    public Result<List<SoilHwsd>> getHwsdData(
            double lon,
            double lat
    ){
        List<SoilHwsd> cs=recommendService.getHwsdData(lon,lat,6);
        if(cs.size()==0){
            List<SoilHwsd> cs1=recommendService.getHwsdData(lon,lat,5);
            if(cs1.size()==0){
                List<SoilHwsd> cs2=recommendService.getHwsdData(lon,lat,4);
                if(cs2.size()==0){
                    List<SoilHwsd> cs3=recommendService.getHwsdData(lon,lat,3);
                    if(cs3.size()==0){
                        List<SoilHwsd> cs4=recommendService.getHwsdData(lon,lat,2);
                        if(cs4.size()==0){
                            List<SoilHwsd> cs5=recommendService.getHwsdData(lon,lat,1);
                            if(cs5.size()==0){
                                List<SoilHwsd> cs6=recommendService.getHwsdData(lon,lat,0);
                                return Result.success(cs6);
                            }else{
                                return Result.success(cs5);
                            }
                        }else{
                            return Result.success(cs4);
                        }
                    }else{
                        return Result.success(cs3);
                    }
                }else{
                    return Result.success(cs2);
                }
            }else{
                return Result.success(cs1);
            }
        }else{
            return Result.success(cs);
        }
    }

    @GetMapping("/getsoilcropdata")
    public Result<List<SoilCropdata>> getSoilCropdata(
            double lon,
            double lat
    ){
        List<SoilCropdata> cs=recommendService.SoilCropdata(lon,lat,6);
        if(cs.size()==0){
            List<SoilCropdata> cs1=recommendService.SoilCropdata(lon,lat,5);
            if(cs1.size()==0){
                List<SoilCropdata> cs2=recommendService.SoilCropdata(lon,lat,4);
                if(cs2.size()==0){
                    List<SoilCropdata> cs3=recommendService.SoilCropdata(lon,lat,3);
                    if(cs3.size()==0){
                        List<SoilCropdata> cs4=recommendService.SoilCropdata(lon,lat,2);
                        if(cs4.size()==0){
                            List<SoilCropdata> cs5=recommendService.SoilCropdata(lon,lat,1);
                            if(cs5.size()==0){
                                List<SoilCropdata> cs6=recommendService.SoilCropdata(lon,lat,0);
                                return Result.success(cs6);
                            }else{
                                return Result.success(cs5);
                            }
                        }else{
                            return Result.success(cs4);
                        }
                    }else{
                        return Result.success(cs3);
                    }
                }else{
                    return Result.success(cs2);
                }
            }else{
                return Result.success(cs1);
            }
        }else{
            return Result.success(cs);
        }
    }

    @GetMapping("/getsoilname")
    public Result<List<SoilCategoryFao90>> getSoilname(String id){
        List<SoilCategoryFao90> ls1=recommendService.getSoilname(id);
        return Result.success(ls1);
    }

    @GetMapping("/getclimatedata")
    public Result<List<Weatherdata>> getClimateData(
        double lon,
        double lat,
        String code,
        String byear,
        String eyear
    ) throws IOException {
        //先查看数据库中是否存在该地址的数据,得一年一年地查看
        Integer yearlength=Integer.parseInt(eyear)-Integer.parseInt(byear)+1;//年份
        String x0=byear;
        System.out.println(yearlength);
        for(int i=0;i<yearlength;i++){
            List<Weatherdata> cs1 = recommendService.getClimateData0(code,x0);
            if(cs1.size()==0) recommendService.RunPython(lon,lat,code,x0,x0);//存入数据库
            x0= String.valueOf(Integer.parseInt(x0)+1);
        }
        //循环结束，所有的数据都已经存在了数据库
        List<Weatherdata> cs2 = recommendService.getClimateData(code,byear,eyear);
        if(cs2.size()!=0){
            //调用python文件 将天气数据导入到数据库
            return Result.success(cs2);
        }else{
            return Result.error("导出失败");
        }
    }

    @GetMapping("/generateHistoryGrowData")
    public Result<List<Wofostresult>> generateHistoryGrowData(
            double lon,
            double lat,
            String areacode,
            Integer cropid,
            String year
    ) throws IOException {
        recommendService.generateHistoryGrowData(lon,lat,areacode,cropid,year);
        return Result.success();
    }

    @GetMapping("/getHistoryGrowData")
    public Result<PageBean<Wofostresult>> getHistoryGrowData(
            Integer pageNum,
            Integer pageSize,
            double lon,
            double lat,
            String areacode,
            String cropids,
            Integer byear,
            Integer eyear
    ) throws IOException {
        PageBean<Wofostresult> pb=recommendService.getHistoryGrowData(pageNum,pageSize,lon,lat,areacode,cropids,byear,eyear);
        return Result.success(pb);
    }


    @GetMapping("/getHistoryGrowDataBycropid")
    public Result<List<Wofostresult>> getHistoryGrowDataBycropid(
            String areacode,
            Integer cropid
    ) {
        List<Wofostresult> pb=recommendService.getHistoryGrowDataBycropid(areacode,cropid);
        return Result.success(pb);
    }
    @GetMapping("/getCostData")
    public Result<List<Costprofitdata>> getCostData(
            String province,
            Integer cropid
    ) {
        List<Costprofitdata> pb=recommendService.getCostData(province,cropid);
        return Result.success(pb);
    }
    @GetMapping("/getCropProductData")
    public Result<List<MaxProduct>> getCropProductData(
            String areacode,
            Integer cropid
    ) {
        List<MaxProduct> pb=recommendService.getCropProductData(areacode,cropid);
        return Result.success(pb);
    }
    @GetMapping("/getCropProductByProvince")
    public Result<List<CropProductinfo>> getCropProductByProvince(
            String province,
            Integer cropid
    ) {
        List<CropProductinfo> pb=recommendService.getCropProductByProvince(province,cropid);
        return Result.success(pb);
    }

    @GetMapping("/getRecommendIndex")
    public Result<List<Double>> getRecommendIndex(
            String areacode,
            String province,
            Integer cropid
    ) {
        List<Double> index=recommendService.getRecommendIndex(areacode,province,cropid);
        return Result.success(index);
    }

    @GetMapping("/getRecommendProject")
    public Result<String> getRecommendProject(
            double lon,
            double lat,
            String areacode,
            Integer cropid,
            String year
    ) throws IOException {
        String ls=recommendService.getRecommendProject(lon,lat,areacode,cropid,year);
        return Result.success(ls);
    }

    @GetMapping("/getRecommendRecord")
    public Result<List<RecommendArgo>> getRecommendRecord(
            String userid,
            String areacode,
            String cropname
    ) {
        List<RecommendArgo> ls=recommendService.getRecommendRecord(userid,areacode,cropname);
        return Result.success(ls);
    }

    @GetMapping("/addRecommendIndexData")
    public Result addRecommendIndexData(
            Double avgModelYield,
            Double avgProfit,
            Double avgYeild,
            Integer cropid,
            String cropname,
            Double index,
            Double star,
            Integer type,
            String userid,
            String createtime,
            String pid,
            String areacode
    ) {
        recommendService.addRecommendIndexData(avgModelYield,avgProfit,avgYeild,cropid,cropname,index,star,type,userid,createtime,pid,areacode);
        return Result.success();
    }


    @GetMapping("/addYieldData")
    public Result addYieldData(
            Integer cropid,
            String cropname,
            String provinceName,
            Integer xyear,
            Double yieldTotal,
            Double yieldUnit
    ) throws IOException {
        recommendService.addYieldData(cropid,cropname,provinceName,xyear,yieldTotal,yieldUnit);
        return Result.success();
    }

    @GetMapping("/getWeight")
    public Result<String> getWeight(
            String data
    ) throws IOException {
        String xdata=recommendService.getWeight(data);
        return Result.success(xdata);
    }
}
