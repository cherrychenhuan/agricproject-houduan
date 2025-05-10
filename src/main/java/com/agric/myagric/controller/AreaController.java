package com.agric.myagric.controller;

import com.agric.myagric.pojo.AreaVillages;
import com.agric.myagric.pojo.Areas;
import com.agric.myagric.pojo.Cropcategories;
import com.agric.myagric.pojo.Result;
import com.agric.myagric.service.AreaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(value = {"/area"},method = RequestMethod.OPTIONS)
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping("/provincelist")
    public Result<List<Areas>> provincelist(){
        List<Areas> cs = areaService.getProvinceList();
//        System.out.println(cs);
        return Result.success(cs);
    }

    @GetMapping("/arealist")
    public Result<List<Areas>> arealist(String code){
        List<Areas> cs = areaService.getAreaList(code);
        return Result.success(cs);
    }

    @GetMapping("/treearealist")
    public Result<List<Areas>> treearealist(@RequestParam("pnode")String pcode, @RequestParam("level")Integer level){
        System.out.println(pcode);
        List<Areas> cs = areaService.getTreeArealist(pcode,level);
        return Result.success(cs);
    }

    @GetMapping("/getlocation")
    public Result<List<AreaVillages>> getlocation(String code,Integer flag){
        List<AreaVillages> cs = areaService.getLocation(code,flag);
        return Result.success(cs);
    }

    @GetMapping("/getAreaInfo")
    public Result<List<AreaVillages>> getAreaInfo(String code){
        List<AreaVillages> cs = areaService.getAreaInfo(code);
        return Result.success(cs);
    }
}
