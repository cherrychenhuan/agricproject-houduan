package com.agric.myagric.controller;

import com.agric.myagric.pojo.*;
import com.agric.myagric.service.HomeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(value = {"/home"},method = RequestMethod.OPTIONS)
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("/getCropProductAll")
    public Result<List<CropProductinfo>> getCropProductAll(
            String cropname,
            Integer year,
            Integer flag
    ) {
        List<CropProductinfo> pb=homeService.getCropProductAll(cropname,year,flag);
        return Result.success(pb);
    }

    @GetMapping("/getCropProductByProvince")
    public Result<List<CropProducttrend>> getCropProductByProvince(
            String cropname,
            String province
    ) {
        List<CropProducttrend> pb=homeService.getCropProductByProvince(cropname,province);
        return Result.success(pb);
    }

    @GetMapping("/getCropConsume")
    public Result<List<CropConsume>> getCropConsume(
            String cropname
    ) {
        List<CropConsume> pb=homeService.getCropConsume(cropname);
        return Result.success(pb);
    }
    @GetMapping("/getPifaPrice")
    public Result<List<CropWholesaleprice>> getPifaPrice(
            String cropname,
            String date
    ) {
        List<CropWholesaleprice> pb=homeService.getPifaPrice(cropname,date);
        return Result.success(pb);
    }

    @GetMapping("/getPifaPriceTrend")
    public Result<List<AvgPriceByday>> getPifaPriceTrend(
            String cropname,
            String date1,
            String date2
    ) {
        List<AvgPriceByday> pb=homeService.getPifaPriceTrend(cropname,date1,date2);
        return Result.success(pb);
    }
    @GetMapping("/getPriceFuture")
    public Result<List<CropFuture>> getPriceFuture(
            String cropname,
            String date1,
            String date2
    ) {
        List<CropFuture> pb=homeService.getPriceFuture(cropname,date1,date2);
        return Result.success(pb);
    }
    @GetMapping("/getCropCost")
    public Result<List<Costprofitdata>> getCropCost(
            String cropname,
            String year,
            String type
    ) {
        List<Costprofitdata> pb=homeService.getCropCost(cropname,year,type);
        return Result.success(pb);
    }

    @GetMapping("/getCropCostData")
    public Result<List<Costprofitdata>> getCropCostData(
            String province,
            String cropname
    ) {
        List<Costprofitdata> pb=homeService.getCropCostData(province,cropname);
        return Result.success(pb);
    }


}
