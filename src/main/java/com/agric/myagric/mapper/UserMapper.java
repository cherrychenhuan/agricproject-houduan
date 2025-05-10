package com.agric.myagric.mapper;

import com.agric.myagric.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //根据用户名查询用户是否存在
    @Select("select * from users where userid= #{userid}")
    User findByPhone(String userid);

    //添加
    @Insert("insert into users(userid,username,phone,password,registertime)" +
            " values(#{phone},#{username},#{phone},#{password},now())")
    void addUser(String phone,String username,String userid, String password);

    @Update("update users set username=#{username},email=#{email},phone=#{phone},gender=#{gender},selfintroduction=#{selfintroduction},address=#{address},birthdate=#{birthdate},avatarurl=#{avatarurl}" +
            " where userid=#{userId}")
    void update(User user);

    @Update("update users set password=#{password}" +
            " where phone=#{phone}")
    void resetpwd(String phone, String password);

    @Update("delete from  users  where userid=#{phone}")
    void deleteUser(String userid);

    @Insert("insert into user_idverifydata(userid,realname,idnumber,verifytime,verifystate)values(#{userid},#{realname},#{idnumber},#{verifytime},'待审核')")
    void addVerifyData(String userid, String realname, String idnumber, String verifytime);

    @Select("select * from user_idverifydata where userid= #{userid} order by verifytime desc")
    List<UserIdverifydata> getVerifyIDData(String userid);

    @Insert("insert into user_companyverifydata(userid,companyname,tellphone,mainactivity,verifytime,verifystate)values(#{userid},#{companyname},#{tellphone},#{mainactivity},#{verifytime},'审核中')")
    void addVerifyCompany(String userid, String companyname, String tellphone, String mainactivity, String verifytime);

    @Select("select * from User_Companyverifydata where userid= #{userid} order by verifytime desc")
    List<UserCompanyverifydata> getVerifyCompanyData(String userid);

    @Select("SELECT createtime, json_arrayagg(json_object('areacode', areacode, 'cropid', cropid, 'cropname', cropname, 'avgprofit', avgprofit," +
            " 'avgyield', avgyield, 'avgmodelyield', avgmodelyield, 'index', xindex, 'star', star,'type',xtype))as datalist from recommendindex " +
            "where userid=#{userid} group by createtime order by createtime desc;")
    List<RecommendHistory> getRecommendRecordTimeList(String userid);

    @Select("select * from area_villages where villagecode=#{areacode}")
    List<AreaVillages> getAddressBycode1(String areacode);

    @Select("select * from area_villages where towncode=#{areacode}")
    List<AreaVillages> getAddressBycode2(String areacode);

    @Select("select * from area_villages where countycode=#{areacode}")
    List<AreaVillages> getAddressBycode3(String areacode);

    @Select("select * from area_villages where citycode=#{areacode}")
    List<AreaVillages> getAddressBycode4(String areacode);

    @Delete("delete from recommendindex where userid=#{userid} and createtime=#{createtime}")
    void deleteRecommendRecord(String userid, String createtime);

    @Delete("delete from recommendindex where userid=#{userid} ")
    void deleteRecommendRecordAll(String userid);
}
