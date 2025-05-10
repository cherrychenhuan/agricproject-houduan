package com.agric.myagric.controller;

import com.agric.myagric.pojo.*;
import com.agric.myagric.service.ArgomanageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Component

@RestController
@AllArgsConstructor
@RequestMapping(value = {"/argomanage"},method = RequestMethod.OPTIONS)
@CrossOrigin
public class ArgomController {
    @Autowired
    private ArgomanageService argomanageService;

    @GetMapping("/argomanagelist")
    public Result<List<Agromanagement>> getArgomanagelist(Integer flag){
        List<Agromanagement> cs;
        if(flag==0){
            cs = argomanageService.getArgomanagelist();
        }else{
            cs = argomanageService.getArgomanagelist1();
        }
//        System.out.println(cs);
        return Result.success(cs);
    }
    @GetMapping("/addArgomanage")
    public Result<Integer> addArgomanage(
        Integer flag,
        String managename,
        String userid,
        String createtime,
        String areacode,
        Double lon,
        Double lat
    ){
        argomanageService.addArgomanage(flag,managename,userid,createtime,areacode,lon,lat);
        Integer mid=argomanageService.getArgomanage(userid,managename);
//        System.out.println(cs);
        return Result.success(mid);
    }

    @GetMapping("/addCropcalendar")
    public Result<Integer> addCropcalendar(
        Integer argomid,
        String plandate,
        String cropName,
        String cropStartType,
        String cropEndType,
        Integer maxDuration
    ){
        argomanageService.addCropcalendar(argomid,plandate,cropName,cropStartType,cropEndType,maxDuration);
        Integer mid=argomanageService.getCropcalendar(argomid);
//        System.out.println(cs);
        return Result.success(mid);
    }

    @GetMapping("/CropCalendarList")
    public Result<List<Cropcalendar>> getCropCalendarList(Integer argomid,Integer flag){
        List<Cropcalendar> cs = argomanageService.getCropCalendarList(argomid,flag);
//        System.out.println(cs);
        return Result.success(cs);
    }

    @GetMapping("/getTimeEventIrriData")
    public Result<List<TimeeventIrrigate>> getTimeEventIrriData(Integer cropcalendarid){
        List<TimeeventIrrigate> cs = argomanageService.getTimeEventIrriData(cropcalendarid);
//        System.out.println(cs);
        return Result.success(cs);
    }
    @GetMapping("/getTimeEventTnData")
    public Result<List<TimeeventNpk>> getTimeEventTnData(Integer cropcalendarid){
        List<TimeeventNpk> cs = argomanageService.getTimeEventTnData(cropcalendarid);
//        System.out.println(cs);
        return Result.success(cs);
    }
    @GetMapping("/getTimeEventTmData")
    public Result<List<TimeeventMowing>> getTimeEventTmData(Integer cropcalendarid){
        List<TimeeventMowing> cs = argomanageService.getTimeEventTmData(cropcalendarid);
//        System.out.println(cs);
        return Result.success(cs);
    }
    @GetMapping("/getStateEventIrriData")
    public Result<List<StateeventIrrigate>> getStateEventIrriData(Integer cropcalendarid){
        List<StateeventIrrigate> cs = argomanageService.getStateEventIrriData(cropcalendarid);
//        System.out.println(cs);
        return Result.success(cs);
    }
    @GetMapping("/getStateEventSnData")
    public Result<List<StateeventNpk>> getStateEventSnData(Integer cropcalendarid){
        List<StateeventNpk> cs = argomanageService.getStateEventSnData(cropcalendarid);
//        System.out.println(cs);
        return Result.success(cs);
    }
    @GetMapping("/getStateEventSmData")
    public Result<List<StateeventMowing>> getStateEventSmData(Integer cropcalendarid){
        List<StateeventMowing> cs = argomanageService.getStateEventSmData(cropcalendarid);
//        System.out.println(cs);
        return Result.success(cs);
    }
    @PostMapping("/updateTimeIrrigate")
    public Result updateTimeIrrigate(@RequestBody @Validated TimeeventIrrigate timeeventIrrigate){
        List<TimeeventIrrigate> xs=argomanageService.getXdata11(timeeventIrrigate.getTimeeventid());
        if(xs.size()!=0) argomanageService.updateTimeIrrigate(timeeventIrrigate);
        else argomanageService.addTimeIrrigate(timeeventIrrigate);
        return Result.success();
    }
    @PostMapping("/updateTimeTn")
    public Result updateTimeTn(@RequestBody @Validated TimeeventNpk timeeventNpk){
        List<TimeeventNpk> xs=argomanageService.getXdata21(timeeventNpk.getTimeeventid());
        if(xs.size()!=0) argomanageService.updateTimeTn(timeeventNpk);
        else argomanageService.addTimeTn(timeeventNpk);
        return Result.success();
    }
    @PostMapping("/updateTimeTm")
    public Result updateTimeTm(@RequestBody @Validated TimeeventMowing timeeventMowing){
        List<TimeeventMowing> xs=argomanageService.getXdata31(timeeventMowing.getTimeeventid());
        if(xs.size()!=0) argomanageService.updateTimeTm(timeeventMowing);
        else argomanageService.addTimeTm(timeeventMowing);
        return Result.success();
    }
    @PostMapping("/updateStateIrrigate")
    public Result updateStateIrrigate(@RequestBody @Validated StateeventIrrigate stateeventIrrigate){
        List<StateeventIrrigate> xs=argomanageService.getXdata12(stateeventIrrigate.getStateeventid());
        if(xs.size()!=0) argomanageService.updateStateIrrigate(stateeventIrrigate);
        else argomanageService.addStateIrrigate(stateeventIrrigate);
        return Result.success();
    }
    @PostMapping("/updateStateSn")
    public Result updateStateSn(@RequestBody @Validated StateeventNpk stateeventNpk){
        List<StateeventNpk> xs=argomanageService.getXdata22(stateeventNpk.getStateeventid());
        if(xs.size()!=0) argomanageService.updateStateSn(stateeventNpk);
        else argomanageService.addStateSn(stateeventNpk);
        return Result.success();
    }
    @PostMapping("/updateStateSm")
    public Result updateStateSm(@RequestBody @Validated StateeventMowing stateeventMowing){
        List<StateeventMowing> xs=argomanageService.getXdata32(stateeventMowing.getStateeventid());
        if(xs.size()!=0) argomanageService.updateStateSm(stateeventMowing);
        else argomanageService.addStateSm(stateeventMowing);
        return Result.success();
    }

    @GetMapping("/getMaxTiId")
    public Result<Integer> getMaxTiId(){
        Integer maxid = argomanageService.getMaxTiId();
//        System.out.println(cs);
        return Result.success(maxid);
    }
    @GetMapping("/getMaxTnId")
    public Result<Integer> getMaxTnId(){
        Integer maxid = argomanageService.getMaxTnId();
//        System.out.println(cs);
        return Result.success(maxid);
    }
    @GetMapping("/getMaxTmId")
    public Result<Integer> getMaxTmId(){
        Integer maxid = argomanageService.getMaxTmId();
//        System.out.println(cs);
        return Result.success(maxid);
    }
    @GetMapping("/getMaxSiId")
    public Result<Integer> getMaxSiId(){
        Integer maxid = argomanageService.getMaxSiId();
//        System.out.println(cs);
        return Result.success(maxid);
    }
    @GetMapping("/getMaxSmId")
    public Result<Integer> getMaxSmId(){
        Integer maxid = argomanageService.getMaxSmId();
//        System.out.println(cs);
        return Result.success(maxid);
    }
    @GetMapping("/getMaxSnId")
    public Result<Integer> getMaxSnId(){
        Integer maxid = argomanageService.getMaxSnId();
//        System.out.println(cs);
        return Result.success(maxid);
    }
    @PostMapping("/addTimeIrrigate")
    public Result addTimeIrrigate(@RequestBody @Validated TimeeventIrrigate timeeventIrrigate){
        argomanageService.addTimeIrrigate(timeeventIrrigate);
//        System.out.println(cs);
        return Result.success();
    }
    @GetMapping("/deleteTi")
    public Result deleteTi(Long id){
        argomanageService.deleteTi(id);
//        System.out.println(cs);
        return Result.success();
    }
    @GetMapping("/deleteTn")
    public Result deleteTn(Long id){
        argomanageService.deleteTn(id);
//        System.out.println(cs);
        return Result.success();
    }
    @GetMapping("/deleteTm")
    public Result deleteTm(Long id){
        argomanageService.deleteTm(id);
//        System.out.println(cs);
        return Result.success();
    }
    @GetMapping("/deleteSi")
    public Result deleteSi(Long id){

        argomanageService.deleteSi(id);
//        System.out.println(cs);
        return Result.success();
    }
    @GetMapping("/deleteSm")
    public Result deleteSm(Long id){
        argomanageService.deleteSm(id);
        return Result.success();
    }
    @GetMapping("/deleteSn")
    public Result deleteSn(Long id){

        argomanageService.deleteSn(id);
//        System.out.println(cs);
        return Result.success();
    }

    @GetMapping("/deleteCropcalendar")
    public Result deleteCropcalendar(Integer id){

        argomanageService.deleteCropcalendar(id);
//        System.out.println(cs);
        return Result.success();
    }
    @PostMapping("/updateArgo")
    public Result updateArgo(@RequestBody @Validated Agromanagement agromanagement){
        List<Agromanagement> xs=argomanageService.getAgromanagementById(agromanagement.getMid());
        if(xs.size()!=0) argomanageService.updateAgro(agromanagement);
        else argomanageService.addAgro(agromanagement);
        return Result.success();
    }

    @PostMapping("/upDateCropCalendar")
    public Result upDateCropCalendar(@RequestBody @Validated Cropcalendar cropcalendar){
        List<Cropcalendar> xs=argomanageService.getCropcalendarById(cropcalendar.getCropCalendarid());
        if(xs.size()!=0) argomanageService.upDateCropCalendar(cropcalendar);
        else argomanageService.addCropCalendar(cropcalendar);
        return Result.success();
    }

    @GetMapping("/getMaxArgoID")
    public Result<Integer> getMaxArgoID(){
        Integer xid=argomanageService.getMaxArgoID();
        return Result.success(xid);
    }

    @GetMapping("/deleteArgo")
    public Result deleteArgo(Integer mid){
        argomanageService.deleteArgo(mid);
        return Result.success();
    }

    @GetMapping("/getMaxCalId")
    public Result<Integer> getMaxCalId(Integer mid){
        Integer xid=argomanageService.getMaxCalId(mid);
        return Result.success(xid);
    }

}
