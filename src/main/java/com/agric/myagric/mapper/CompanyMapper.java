package com.agric.myagric.mapper;

import com.agric.myagric.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompanyMapper {

    @Select("select a.*,b.username,b.avatarurl from topics a left join users b on a.creatorid=b.userid order by createTime desc")
    List<Topics> getTopiclist();
    @Select("select a.*,b.username,b.avatarurl from comments a join users b using(userid) where topicid=#{id} order by commenttime desc")
    List<Xcomments> getCommentList(Integer id);
    @Insert("insert into comments(userid,topicid,content,commenttime)values(#{userid},#{topicid},#{content},#{commenttime})")
    void addComment(String userid, Integer topicid, String content, String commenttime);
    @Insert("insert into topics(tittle,content,creatorId,createTime)values(#{tittle},#{content},#{creatorId},#{createTime})")
    void addTopic(String tittle, String content, String creatorId, String createTime);
    @Select("select * from Knowledges")
    List<Knowledges> getKnowledgeList();
    @Select("select * from collectdata where userid=#{userid} and postid=#{postid} and type=#{flag}")
    List<Collectdata> getifCollect(String userid, Integer postid, Integer flag);
    @Insert("insert into collectdata(userid,postid,type,collecttime)values(#{userid},#{postid},#{type},#{collecttime})")
    void addCollect(String userid, Integer postid, Integer type, String collecttime);
    @Delete("delete from collectdata where userid=#{userid} and postid=#{postid} and type=#{type} ")
    void deleteCollect(String userid, Integer postid, Integer type);

    @Select("select a.*,b.username,b.avatarurl from comments a join users b using(userid) where topicid=#{id} order by commentid desc")
    List<Xcomments> getxCommentList(Integer id);
}
