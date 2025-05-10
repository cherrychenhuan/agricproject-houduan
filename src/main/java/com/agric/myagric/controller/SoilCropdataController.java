package com.agric.myagric.controller;

import com.agric.myagric.pojo.*;
import com.agric.myagric.service.RecommendService;
import com.agric.myagric.service.SoilCropdataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class SoilCropdataController {
    @Autowired
    private SoilCropdataService soilcropdataService;
    //保存soilcropdata
    @PostMapping("/addsoilcropdata")
    public Result<List<SoilCropdata>> addSoilcropData(@RequestBody @Validated SoilCropdata soilCropdata){
        soilcropdataService.add(soilCropdata);
        return Result.success();
    }
    @PostMapping("/updatesoilcropdata")
    public Result<List<SoilCropdata>> updateSoilcropData(@RequestBody @Validated SoilCropdata soilCropdata){
        soilcropdataService.update(soilCropdata);
        return Result.success();
    }
    @GetMapping("/getsoilCropDataList")
    public Result<PageBean<SoilCropdata>> list(
            Integer pageNum,
            Integer pageSize
    ) {
        PageBean<SoilCropdata> pb =  soilcropdataService.getAllsoilCropDataList(pageNum,pageSize);
        return Result.success(pb);
    }
    @PostMapping("/deletesoilcropdata")
    public Result DeleteSoilCropdata(Integer soilid){
//        System.out.println(id);
//        int id1=Integer.parseInt(id);
        soilcropdataService.delete(soilid);
        return Result.success();
    }

    @GetMapping("/getSoilcategoryList")
    public Result<List<SoilCategoryFao90>> getSoilcategoryList(
    ) {
        List<SoilCategoryFao90> cs =  soilcropdataService.getSoilcategoryList();
        return Result.success(cs);
    }

    @GetMapping("/getSoilFilterList")
    public Result<PageBean<SoilCropdata>> getSoilFilterList(
            Integer pageNum,
            Integer pageSize,
            String areacode,
            String soilcategory,
            Integer flag
    ) {
        PageBean<SoilCropdata> pb;
        if(flag==0){
            pb =  soilcropdataService.getSoilFilterList1(pageNum,pageSize,areacode);
        }else if(flag==1){
            pb =  soilcropdataService.getSoilFilterList2(pageNum,pageSize,soilcategory);
        }else{
            pb =  soilcropdataService.getSoilFilterList3(pageNum,pageSize,areacode,soilcategory);
        }
        return Result.success(pb);
    }

    @GetMapping("/getSoilcropAllData")
    public Result<List<SoilCropdata>> getSoilcropAllData(
    ) {
        List<SoilCropdata> cs =  soilcropdataService.getSoilcropAllData();
        return Result.success(cs);
    }

    @GetMapping("/soilGenericData")
    public Result<List<SoilCategoryGenetic>> getSoilGenericData(
    ) {
        List<SoilCategoryGenetic> cs =  soilcropdataService.getSoilGenericData();
        return Result.success(cs);
    }

    @GetMapping("/soilGenericDataDetail")
    public Result<List<SoilCategoryGDetails>> soilGenericDataDetail(Integer id
    ) {
        List<SoilCategoryGDetails> cs =  soilcropdataService.soilGenericDataDetail(id);
        return Result.success(cs);
    }

    @GetMapping("/soilFao90Data")
    public Result<List<SoilCategoryFao90>> getSoilFao90Data(
    ) {
        List<SoilCategoryFao90> cs =  soilcropdataService.getSoilFao90Data();
        return Result.success(cs);
    }
}
