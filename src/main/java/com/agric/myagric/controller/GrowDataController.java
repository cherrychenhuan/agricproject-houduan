package com.agric.myagric.controller;

import com.agric.myagric.pojo.PageBean;
import com.agric.myagric.pojo.Result;
import com.agric.myagric.pojo.Wofostresult;
import com.agric.myagric.service.GrowDataService;
import com.agric.myagric.service.RecommendService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(value = {"/grow"},method = RequestMethod.OPTIONS)
public class GrowDataController {
    @Autowired
    private GrowDataService growDataService;
    @GetMapping("/getHistoryGrowDataByCrop")
    public Result<PageBean<Wofostresult>> getHistoryGrowDataByCrop(
            Integer pageNum,
            Integer pageSize,
            String areacode,
            Integer cropid,
            Integer byear,
            Integer eyear
    ) throws IOException {
        PageBean<Wofostresult> pb=growDataService.getHistoryGrowDataByCrop(pageNum,pageSize,areacode,cropid,byear,eyear);
        return Result.success(pb);
    }
}
