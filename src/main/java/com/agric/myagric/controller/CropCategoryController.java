package com.agric.myagric.controller;
import com.agric.myagric.pojo.*;
import com.agric.myagric.service.CropCategoryService;
import com.agric.myagric.service.UserService;

import com.agric.myagric.utils.JwtUtil;
import com.agric.myagric.utils.Md5Util;
import com.agric.myagric.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.agric.myagric.service.ArgomanageService;
@RestController
@AllArgsConstructor

@RequestMapping(value = {"/cropinfo"},method = RequestMethod.OPTIONS)
@CrossOrigin
public class CropCategoryController {
    @Autowired
    private CropCategoryService cropCategoryService;
    @Autowired
    private ArgomanageService argomanageService;
    //获取分类列表
    //根据查询条件来
    //如果没有筛选条件，查询flag就是0
    @GetMapping("/cropcategoryalllist")
    public Result<List<Cropcategories>> list(){
        List<Cropcategories> cs = cropCategoryService.getAllData();
//        System.out.println(cs);
        return Result.success(cs);

    }
    @GetMapping("/cropcategorylist")
    public Result<PageBean<Cropcategories>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String value,  //@requestParam注解表示这是非必须参数
            @RequestParam(required = false) Integer flag
    ) {
        PageBean<Cropcategories> pb =  cropCategoryService.list(pageNum,pageSize);
        return Result.success(pb);
    }
    //增加分类
    @PostMapping("/addcategory")
    public Result AddCategory(@RequestBody @Validated Cropcategories cropcategory){
        System.out.println("Received Cropcategories object: " + cropcategory.toString());
        cropcategory.setImgNum(cropcategory.getImgNum() != null ? cropcategory.getImgNum() : 0);
        cropCategoryService.add(cropcategory);
        return Result.success();
    }

    //增加生态类型
    @PostMapping("/addEcotype")
    public Result addEcotype(@RequestBody @Validated CropEcotypes cropEcotypes){
        cropCategoryService.addEcotype(cropEcotypes);
        return Result.success();
    }
    //增加品种
    @PostMapping("/addVariety")
    public Result addVariety(@RequestBody @Validated CropVarities cropVarities){
        cropCategoryService.addVariety(cropVarities);
        return Result.success();
    }
    @PostMapping("/addGenericType")
    public Result addGenericType(@RequestBody @Validated CropGenerictypes cropGenerictypes){
        cropCategoryService.addGenericType(cropGenerictypes);
        return Result.success();
    }

    @PostMapping("/updateEcotype")
    public Result updateEcotype(@RequestBody @Validated CropEcotypes cropEcotypes){
//        System.out.println("Received Cropcategories object: " + cropcategory.toString());
        cropCategoryService.updateEcotype(cropEcotypes);
        return Result.success();
    }
    @PostMapping("/updateGenericType")
    public Result updateGenericType(@RequestBody @Validated CropGenerictypes cropGenerictypes){
//        System.out.println("Received Cropcategories object: " + cropcategory.toString());
        cropCategoryService.updateGenericType(cropGenerictypes);
        return Result.success();
    }
    @PostMapping("/deleteEcotype")
    public Result deleteEcotype(Integer ecotypeid){
//        log.info("Received deleteEcotype request for ecotypeid: {}", ecotypeid);
        cropCategoryService.deleteEcotype(ecotypeid);
        return Result.success();
    }
    @PostMapping("/deleteVariety")
    public Result deleteVariety(Integer varietyid){
        cropCategoryService.deleteVariety(varietyid);
        return Result.success();
    }
    @PostMapping("/deleteGenericType")
    public Result deleteGenericType(@RequestBody Map<String, String> requestData){
        String genericid = requestData.get("genericid");
        System.out.println("当前"+genericid);
        cropCategoryService.deleteGenericType(genericid);
        return Result.success();
    }

    @PostMapping("/updateVariety")
    public Result updateVariety(@RequestBody @Validated CropVarities cropVarities){
//        System.out.println("Received Cropcategories object: " + cropcategory.toString())
        cropCategoryService.updateVariety(cropVarities);
        return Result.success();
    }

    //删除分类
    @PostMapping("/deletecategory")
    public Result DeleteCategory(Integer id){
//        System.out.println(id);
//        int id1=Integer.parseInt(id);
        cropCategoryService.delete(id);
        return Result.success();
    }

    //自动生成新增作物的ID
    @GetMapping("/getNewID")
    public Result getNewID(String category){
        Integer id = cropCategoryService.getNewID(category);

        return Result.success(id);
    }

    //自动生成生态类型编码
    @GetMapping("/getNewEcotypeID")
    public Result getNewEcotypeID(Integer cropid){
        Integer ecotypeid = cropCategoryService.getNewEcotypeID(cropid);
        return Result.success(ecotypeid);
    }
    @GetMapping("/getNewGenericID")
    public Result getNewGenericID(Integer id){
        Integer genericID = cropCategoryService.getNewGenericID(id);
        return Result.success(genericID);
    }
    //自动生成品种编码
    @GetMapping("/getNewVarietyID")
    public Result getNewVarietyID(String ecotype,Integer ecotypeid){
        Integer varietyID = cropCategoryService.getNewVarietyID(ecotype,ecotypeid);
        return Result.success(varietyID);
    }

    //科属选择器联动
    @GetMapping("/getGenusList")
    public Result getGenusList(String family){
        List<String> glist = cropCategoryService.getGenusList(family);
        return Result.success(glist);
    }

    //光标定位，获取特定行的行数
    @GetMapping("/getRowNum")
    public Result getRowNum(Integer id){
        Integer rownum = cropCategoryService.getRowNum(id);
        return Result.success(rownum);
    }

    //更改分类
    @PostMapping("/updatecategory")
    public Result UpdateCategory(@RequestBody @Validated Cropcategories cropcategory){
//        System.out.println("11-----------"+cropcategory.getCategory());
        cropCategoryService.update(cropcategory);
        return Result.success();
    }

    //过滤
    @GetMapping("/getSearchFilterList")
    public Result<PageBean<Cropcategories>> getSearchFilterList(Integer pageNum,
                                                                Integer pageSize,
                                                                String value){
        PageBean<Cropcategories> pb =  cropCategoryService.getSearchFilterList(pageNum,pageSize,value);
        return Result.success(pb);
    }

    //获取树形结构的数据
    @GetMapping("/getCropList")
    public Result<List<Cropcategories>> getCropList(){
        List<Cropcategories> ls=cropCategoryService.getCropList();
        return Result.success(ls);
    }

    @GetMapping("/getEcotypeList")
    public Result<List<CropEcotypes>> getEcotypeList(Integer cropid){
        List<CropEcotypes> ls=cropCategoryService.getEcotypeList(cropid);
        return Result.success(ls);
    }
    @GetMapping("/getCropVarietyList")
    public Result<List<CropVarities>> getCropVarietyList(String ecotype){
        List<CropVarities> ls=cropCategoryService.getCropVarietyList(ecotype);
        return Result.success(ls);
    }

    @GetMapping("/getCropBycategory")
    public Result<List<Cropcategories>> getCropBycategory(String category){
        List<Cropcategories> ls=cropCategoryService.getCropBycategory(category);
        return Result.success(ls);
    }

//    @GetMapping("/gengericBycrop")
//    public Result<List<CropGenerictypes>> gengericBycrop(Integer cropid){
//        List<CropGenerictypes> ls=cropCategoryService.gengericBycrop(cropid);
//        return Result.success(ls);
//    }

    @GetMapping("/getGenerictypeData")
    public Result<List<CropGenerictypes>> getGenerictypeData(Integer cropid){
        List<CropGenerictypes> ls=cropCategoryService.getGenerictypeData(cropid);
        return Result.success(ls);
    }

    @GetMapping("/getVarietyData")
    public Result<List<CropVarities>> getVarietyData(String ecotype){
        List<CropVarities> ls=cropCategoryService.getCropVarietyList(ecotype);
        return Result.success(ls);
    }
    @GetMapping("/argomanagelist")
    public Result<List<Agromanagement>> getArgomanagelist(Integer flag){
        List<Agromanagement> cs = argomanageService.getArgomanagelist();
//        System.out.println(cs);
        return Result.success(cs);
    }






}
