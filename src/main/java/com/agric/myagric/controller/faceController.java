package com.agric.myagric.controller;

import com.agric.myagric.service.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/face")
public class faceController {
    @Autowired
    private FaceService faceService;

    @RequestMapping("/face")
    public void face() throws IOException {
        faceService.faceRecognition();
    }
}

