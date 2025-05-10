package com.agric.myagric.controller;

import com.agric.myagric.pojo.*;
import com.agric.myagric.service.AreaService;
import com.agric.myagric.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(value = {"/company"},method = RequestMethod.OPTIONS)
public class CompanyController {
    @Autowired
    private CompanyService companyService;


    @GetMapping("/getTopiclist")
    public Result<List<Topics>> getTopiclist() {
        List<Topics> pb=companyService.getTopiclist();
        return Result.success(pb);
    }
    @GetMapping("/getKnowledgeList")
    public Result<List<Knowledges>> getKnowledgeList() {
        List<Knowledges> pb=companyService.getKnowledgeList();
        return Result.success(pb);
    }

    @GetMapping("/getifCollect")
    public Result<List<Collectdata>> getifCollect(String userid,Integer postid,Integer type) {
        List<Collectdata> pb=companyService.getifCollect(userid,postid,type);
        return Result.success(pb);
    }

    @GetMapping("/getCommentList")
    public Result<List<Xcomments>> getCommentList(Integer id) {
        List<Xcomments> pb=companyService.getCommentList(id);
        return Result.success(pb);
    }
    @GetMapping("/addComment")
    public Result addComment(String userid,Integer topicid,String content,String commenttime) {
        companyService.addComment(userid,topicid,content,commenttime);
        return Result.success();
    }
    @GetMapping("/addTopic")
    public Result addTopic(String tittle,String content,String creatorId,String createTime) {
        companyService.addTopic(tittle,content,creatorId,createTime);
        return Result.success();
    }
    @GetMapping("/addCollect")
    public Result addCollect(String userid,Integer postid,Integer type,String collecttime) {
        companyService.addCollect(userid,postid,type,collecttime);
        return Result.success();
    }

    @GetMapping("/deleteCollect")
    public Result deleteCollect(String userid,Integer postid,Integer type) {
        companyService.deleteCollect(userid,postid,type);
        return Result.success();
    }


    @GetMapping("/getxCommentList")
    public Result<PageBean<Xcomments>> getxCommentList(Integer id,Integer pageNum,Integer pageSize) {
        PageBean<Xcomments> pb=companyService.getxCommentList(id,pageNum,pageSize);
        return Result.success(pb);
    }
}
