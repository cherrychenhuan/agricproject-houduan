package com.agric.myagric.service;

import com.agric.myagric.pojo.*;

import java.util.List;

public interface CompanyService {
    List<Topics> getTopiclist();

    List<Xcomments> getCommentList(Integer id);

    void addComment(String userid, Integer topicid, String content, String commenttime);

    void addTopic(String tittle, String content, String creatorId, String createTime);

    List<Knowledges> getKnowledgeList();

    List<Collectdata> getifCollect(String userid,Integer postid,Integer flag);

    void addCollect(String userid, Integer postid, Integer type, String collecttime);

    void deleteCollect(String userid, Integer postid, Integer type);

    PageBean<Xcomments> getxCommentList(Integer id, Integer pageNum, Integer pageSize);
}
