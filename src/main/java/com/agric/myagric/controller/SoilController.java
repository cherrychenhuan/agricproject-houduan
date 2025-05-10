package com.agric.myagric.controller;
import com.agric.myagric.pojo.Soil;
import com.agric.myagric.service.SoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoilController {
    @Autowired
    private SoilService soilService;

    @RequestMapping("/findByID")
    public Soil findByID(int id){

        return soilService.findByID(id);
    }

}
