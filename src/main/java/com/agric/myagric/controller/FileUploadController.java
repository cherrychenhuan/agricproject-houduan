package com.agric.myagric.controller;


import com.agric.myagric.pojo.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;
@CrossOrigin
@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file,Integer id) throws Exception {
        //把文件的内容存储到本地磁盘上

        String filename = file.getOriginalFilename();
        String nid = String.valueOf(id);
        //保证文件的名字是唯一的,从而防止文件覆盖
//        String filename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
//        System.out.println(filename);
        File newfile = new File("D:\\importantFiles\\Graduation Design 2024\\vueproject\\crop-recommend\\src\\assets\\crop_categorysampleimgs\\"+filename);
        file.transferTo(newfile.getAbsoluteFile());

//        String url = AliOssUtil.uploadFile(filename,file.getInputStream());
        return Result.success("url访问地址...");
    }

    @PostMapping("/uploadTopicImg")
    public Result<String> uploadTopicImg(MultipartFile file,String name) throws Exception {
        //把文件的内容存储到本地磁盘上

        String filename = name;
//        String nid = String.valueOf(id);
        //保证文件的名字是唯一的,从而防止文件覆盖
//        String filename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println(filename);
        File newfile = new File("D:\\importantFiles\\Graduation Design 2024\\vueproject\\crop-recommend\\src\\assets\\topic\\"+filename);
        file.transferTo(newfile.getAbsoluteFile());

//        String url = AliOssUtil.uploadFile(filename,file.getInputStream());
        return Result.success("url访问地址...");
    }
    @PostMapping("/uploadKnowledgeImg")
    public Result<String> uploadKnowledgeImg(MultipartFile file,String name) throws Exception {
        //把文件的内容存储到本地磁盘上
        String filename = name;
//        String nid = String.valueOf(id);
        //保证文件的名字是唯一的,从而防止文件覆盖
//        String filename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println(filename);
        File newfile = new File("D:\\importantFiles\\Graduation Design 2024\\vueproject\\crop-recommend\\src\\assets\\knowledge\\"+filename);
        file.transferTo(newfile.getAbsoluteFile());

//        String url = AliOssUtil.uploadFile(filename,file.getInputStream());
        return Result.success("url访问地址...");
    }
}
