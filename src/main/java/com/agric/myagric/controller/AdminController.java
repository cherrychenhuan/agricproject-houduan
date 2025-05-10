package com.agric.myagric.controller;

import com.agric.myagric.pojo.*;
import com.agric.myagric.service.AdminService;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(value = {"/admin"},method = RequestMethod.OPTIONS)
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/getUserList")
    public Result<PageBean<User>> getUserList(Integer pageNum,
                                              Integer pageSize){
        PageBean<User> pb=adminService.getUserList(pageNum,pageSize);
//        System.out.println(cs);
        return Result.success(pb);
    }

    @GetMapping("/getTopicData")
    public Result<PageBean<Topics>> getTopicData(Integer pageNum,
                                              Integer pageSize){
        PageBean<Topics> pb=adminService.getTopicData(pageNum,pageSize);
//        System.out.println(cs);
        return Result.success(pb);
    }
    @GetMapping("/getKnowledgeData")
    public Result<PageBean<Knowledges>> getKnowledgeData(Integer pageNum,
                                                 Integer pageSize){
        PageBean<Knowledges> pb=adminService.getKnowledgeData(pageNum,pageSize);
//        System.out.println(cs);
        return Result.success(pb);
    }

    @GetMapping("/getIdVerifyList")
    public Result<PageBean<UserIdverifydata>> getIdVerifyList(Integer pageNum,
                                              Integer pageSize,Integer flag){
        PageBean<UserIdverifydata> pb=adminService.getIdVerifyList(pageNum,pageSize,flag);
//        System.out.println(cs);
        return Result.success(pb);
    }
    @GetMapping("/getCompanyVerifyList")
    public Result<PageBean<UserCompanyverifydata>> getCompanyVerifyList(Integer pageNum,
                                                              Integer pageSize,Integer flag){
        PageBean<UserCompanyverifydata> pb=adminService.getCompanyVerifyList(pageNum,pageSize,flag);
//        System.out.println(cs);
        return Result.success(pb);
    }
    @GetMapping("/getHwsdList")
    public Result<PageBean<SoilHwsd>> getHwsdList(Integer pageNum,Integer pageSize){
        PageBean<SoilHwsd> pb=adminService.getHwsdList(pageNum,pageSize);
//        System.out.println(cs);
        return Result.success(pb);
    }
    @PostMapping("/addUser")
    public Result<User> addUser(@RequestBody @Validated User user){
        User u = adminService.addUser(user);
        return Result.success(u);
    }

    @GetMapping("/getAllusers")
    public Result<List<User>> getAllusers(){
        List<User> pb=adminService.getAllusers();
//        System.out.println(cs);
        return Result.success(pb);
    }

    @GetMapping("/userFilter")
    public Result<PageBean<User>> userFilter(Integer pageNum,
                                         Integer pageSize,
                                         String value){
        PageBean<User> pb=adminService.userFilter(pageNum,pageSize,value);
//        System.out.println(cs);
        return Result.success(pb);
    }

    @GetMapping("/updateVerifyIDData")
    public Result updateVerifyIDData(Integer verifyid,String examinetime,String examineadmin,String verifystate,String remark) {
        adminService.updateVerifyIDData(verifyid,examinetime,examineadmin,verifystate,remark);
//        System.out.println(cs);
        return Result.success();
    }
    @GetMapping("/updateVerifyCompany")
    public Result updateVerifyCompany(Integer verifyid,String examinetime,String examineadmin,String verifystate,String remark)
    {
        System.out.println(verifystate);
        adminService.updateVerifyCompany(verifyid,examinetime,examineadmin,verifystate,remark);

        return Result.success();
    }

    @GetMapping("/updateTopic")
    public Result updateTopic(Integer topicId,String tittle,String creatorId,String createTime,String content)
    {

        adminService.updateTopic(topicId,tittle,creatorId,createTime,content);

        return Result.success();
    }

    @GetMapping("/updateKnowledge")
    public Result updateKnowledge(Integer id,String tittle,String editor,String createtime,String content){
        adminService.updateKnowledge(id,tittle,editor,createtime,content);

        return Result.success();
    }

    @GetMapping("/addKnowledge")
    public Result addKnowledge(String tittle,String editor,String createtime,String content)
    {

        adminService.addKnowledge(tittle,editor,createtime,content);

        return Result.success();
    }
    @GetMapping("/updateComment")
    public Result updateComment(Integer commentid,String content,String commenttime)
    {
        adminService.updateComment(commentid,content,commenttime);

        return Result.success();
    }
    @GetMapping("/deleteTopic")
    public Result deleteTopic(Integer topicid) {
        adminService.deleteTopic(topicid);
        return Result.success();
    }

    @GetMapping("/deleteKnowledge")
    public Result deleteKnowledge(Integer id) {
        adminService.deleteKnowledge(id);
        return Result.success();
    }
    @GetMapping("/deleteComment")
    public Result deleteComment(Integer commentid) {
        adminService.deleteComment(commentid);
        return Result.success();
    }
    @GetMapping("/getFilterVerifyIDData")
    public Result<PageBean<UserIdverifydata>> getFilterVerifyIDData(Integer pageNum,
                                                              Integer pageSize,String idtime1, String idtime2,Integer flag){
        PageBean<UserIdverifydata> pb=adminService.getFilterVerifyIDData(pageNum,pageSize,idtime1,idtime2,flag);
//        System.out.println(cs);
        return Result.success(pb);
    }
    @GetMapping("/getFilterVerifyCompanyData")
    public Result<PageBean<UserCompanyverifydata>> getFilterVerifyCompanyData(Integer pageNum,
                                                                    Integer pageSize,String idtime1, String idtime2,Integer flag){
        PageBean<UserCompanyverifydata> pb=adminService.getFilterVerifyCompanyData(pageNum,pageSize,idtime1,idtime2,flag);
//        System.out.println(cs);
        return Result.success(pb);
    }

    @PostMapping("/updateHwsd")
    public Result updateHwsd(@RequestBody @Validated SoilHwsd soilHwsd){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.updateHwsd(soilHwsd);
        return Result.success();
    }

    @PostMapping("/addProductData")
    public Result<String> addProductData(@RequestBody @Validated CropProductinfo cropProductinfo){
//        System.out.println("11-----------"+cropcategory.getCategory());
        List<CropProductinfo> ls1=adminService.getifProductData(cropProductinfo);
        if(ls1.size()>0) return Result.success("已经存在");
        else{
            adminService.addProductData(cropProductinfo);
            return Result.success();
        }
    }

    @PostMapping("/addPriceData")
    public Result<String> addPriceData(@RequestBody @Validated CropWholesaleprice cropWholesaleprice){
//        System.out.println("11-----------"+cropcategory.getCategory());
        List<CropWholesaleprice> ls1=adminService.getifPriceData(cropWholesaleprice);
        if(ls1.size()>0) return Result.success("已经存在");
        else{
            adminService.addPriceData(cropWholesaleprice);
            return Result.success();
        }
    }
    @PostMapping("/addProfitData")
    public Result<String> addProfitData(@RequestBody @Validated Costprofitdata costprofitdata){
//        System.out.println("11-----------"+cropcategory.getCategory());
        List<Costprofitdata> ls1=adminService.getifProfitData(costprofitdata);
        if(ls1.size()>0) return Result.success("已经存在");
        else{
            adminService.addProfitData(costprofitdata);
            return Result.success();
        }
    }

    @PostMapping("/deleteProductInfo")
    public Result deleteProductInfo(@RequestBody @Validated CropProductinfo cropProductinfo){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.deleteProductInfo(cropProductinfo);
            return Result.success();
    }
    @PostMapping("/deletePriceInfo")
    public Result deletePriceInfo(@RequestBody @Validated CropWholesaleprice cropWholesaleprice){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.deletePriceInfo(cropWholesaleprice);
        return Result.success();
    }

    @PostMapping("/deleteProfitInfo")
    public Result deleteProfitInfo(@RequestBody @Validated Costprofitdata costprofitdata){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.deleteProfitInfo(costprofitdata);
        return Result.success();
    }
    @PostMapping("/updateProductData")
    public Result updateProductData(@RequestBody @Validated CropProductinfo cropProductinfo){
            adminService.updateProductData(cropProductinfo);
            return Result.success();

    }
    @PostMapping("/updatePriceData")
    public Result updatePriceData(@RequestBody @Validated CropWholesaleprice cropWholesaleprice){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.updatePriceData(cropWholesaleprice);
        return Result.success();

    }
    @PostMapping("/updateProfitData")
    public Result updateProfitData(@RequestBody @Validated Costprofitdata costprofitdata){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.updateProfitData(costprofitdata);
        return Result.success();

    }
    @PostMapping("/getNewProfitRow")
    public Result getNewProfitRow(@RequestBody @Validated Costprofitdata costprofitdata){
        Integer rownum = adminService.getNewProfitRow(costprofitdata);
        return Result.success(rownum);
    }
    @PostMapping("/getNewProductRow")
    public Result getNewProductRow(@RequestBody @Validated CropProductinfo cropProductinfo){
        Integer rownum = adminService.getNewProductRow(cropProductinfo);
        return Result.success(rownum);
    }
    @PostMapping("/getNewPriceRow")
    public Result getNewPriceRow(@RequestBody @Validated CropWholesaleprice cropWholesaleprice){
        Integer rownum = adminService.getNewPriceRow(cropWholesaleprice);
        return Result.success(rownum);
    }
    @GetMapping("/deleteHwsd")
    public Result deleteHwsd(Integer fid){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.deleteHwsd(fid);
        return Result.success();
    }

    @GetMapping("/getAutoSoilGid")
    public Result<Integer> getAutoSoilGid(){
//        System.out.println("11-----------"+cropcategory.getCategory());
        Integer mid =adminService.getAutoSoilGid();
        if(mid==null) mid=1;

        return Result.success(mid);
    }

    @GetMapping("/addSoilGenricData")
    public Result addSoilGenricData(Integer id,String soilType){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.addSoilGenricData(id,soilType);
        return Result.success();
    }

    @GetMapping("/getAutoSoilGDetailid")
    public Result<Integer> getAutoSoilGDetailid(String id){
        Integer mid =adminService.getAutoSoilGDetailid(id)+1;
        return Result.success(mid);
    }

    @GetMapping("/getProductData")
    public Result<PageBean<CropProductinfo>> getProductData(Integer pageNum, Integer pageSize){
        PageBean<CropProductinfo> mid =adminService.getProductData(pageNum,pageSize);
        return Result.success(mid);
    }
    @GetMapping("/getPriceData")
    public Result<PageBean<CropWholesaleprice>> getPriceData(Integer pageNum, Integer pageSize){
        PageBean<CropWholesaleprice> mid =adminService.getPriceData(pageNum,pageSize);
        return Result.success(mid);
    }
    @GetMapping("/getProfitData")
    public Result<PageBean<Costprofitdata>> getProfitData(Integer pageNum, Integer pageSize){
        PageBean<Costprofitdata> mid =adminService.getProfitData(pageNum,pageSize);
        return Result.success(mid);
    }

    @GetMapping("/filterProductInfo")
    public Result<PageBean<CropProductinfo>> filterProductInfo(String cropname,Integer xyear,String province,Integer pageNum, Integer pageSize){
        PageBean<CropProductinfo> mid =adminService.filterProductInfo(cropname,xyear,province,pageNum,pageSize);
        return Result.success(mid);
    }
    @GetMapping("/filterPriceInfo")
    public Result<PageBean<CropWholesaleprice>> filterPriceInfo(String cropname,String date,String province,Integer pageNum, Integer pageSize){
        PageBean<CropWholesaleprice> mid =adminService.filterPriceInfo(cropname,date,province,pageNum,pageSize);
        return Result.success(mid);
    }
    @GetMapping("/filterProfitInfo")
    public Result<PageBean<Costprofitdata>> filterProfitInfo(String cropname,String year,String province,String type,Integer pageNum, Integer pageSize){
        PageBean<Costprofitdata> mid =adminService.filterProfitInfo(cropname,year,province,type,pageNum,pageSize);
        return Result.success(mid);
    }

    @GetMapping("/addSoilGenricDetailData")
    public Result addSoilGenricDetailData(Integer id,String soilType,String pid){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.addSoilGenricDetailData(id,soilType,pid);
        return Result.success();
    }

    @GetMapping("/addSoilFaoData")
    public Result addSoilFaoData(String value,String symbol,String chineseValue){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.addSoilFaoData(value,symbol,chineseValue);
        return Result.success();
    }
    @GetMapping("/addFaoDetailData")
    public Result addFaoDetailData(String value,String symbol,String chineseValue){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.addSoilFaoData(value,symbol,chineseValue);
        return Result.success();
    }
    @GetMapping("/deleteSoilGData")
    public Result deleteSoilGData(Integer id){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.deleteSoilGData(id);
        return Result.success();
    }

    @GetMapping("/deleteSoilGDetailData")
    public Result deleteSoilGDetailData(String id){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.deleteSoilGDetailData(id);
        return Result.success();
    }

    @GetMapping("/deleteFaoData")
    public Result deleteFaoData(String code){
//        System.out.println("11-----------"+cropcategory.getCategory());
        adminService.deleteFaoData(code);
        return Result.success();
    }
}
