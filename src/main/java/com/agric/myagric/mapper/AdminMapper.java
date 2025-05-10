package com.agric.myagric.mapper;


import com.agric.myagric.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from users order by registertime desc")
    List<User> getUserList();

    @Insert("insert into users(userid,username,phone,password,email,birthdate,gender,address,UserType,selfintroduction,registertime)" +
            " values(#{userId},#{username},#{phone},#{password},#{email},#{birthdate},#{gender},#{address},#{userType},#{selfintroduction},#{registerTime})")
    void addUser(User user);

    @Select("select * from users order by registertime desc")
    List<User> getAllusers();

    @Select("select * from users where userId like CONCAT('%', #{value}, '%') or username like CONCAT('%', #{value}, '%') or address like CONCAT('%', #{value}, '%') or selfintroduction like CONCAT('%', #{value}, '%') order by registertime desc")
    List<User> userFilter(String value);

    @Select("select * from User_Idverifydata where isnull(verifystate) or verifystate='待审核' order by verifytime desc")
    List<UserIdverifydata> getIdVerifyList1();

    @Select("select * from User_Idverifydata where verifystate!='待审核' order by examinetime desc")
    List<UserIdverifydata> getIdVerifyList2();

    @Update("update User_Idverifydata set examinetime=#{examinetime},examineadmin=#{examineadmin},verifystate=#{verifystate},remark=#{remark} where verifyid=#{verifyid}")
    void updateVerifyIDData(Integer verifyid, String examinetime, String examineadmin, String verifystate, String remark);

    @Select("select * from User_Idverifydata where  isnull(verifystate) or verifystate='待审核' and verifytime between #{idtime1} and #{idtime2} order by verifytime desc")
    List<UserIdverifydata> getFilterVerifyIDData1(String idtime1, String idtime2);

    @Select("select * from User_Idverifydata where verifystate!='待审核' and examinetime between #{idtime1} and #{idtime2} order by examinetime desc")
    List<UserIdverifydata> getFilterVerifyIDData2(String idtime1, String idtime2);

    @Select("select * from User_Companyverifydata where isnull(verifystate) or verifystate='待审核' order by verifytime desc")
    List<UserCompanyverifydata> getCompanyVerifyList1();

    @Select("select * from User_Companyverifydata where verifystate!='待审核' order by examinetime desc")
    List<UserCompanyverifydata> getCompanyVerifyList2();

    @Select("select * from User_Companyverifydata where  isnull(verifystate) or verifystate='待审核' and verifytime between #{idtime1} and #{idtime2} order by verifytime desc")
    List<UserCompanyverifydata> getFilterVerifyCompanyData1(String idtime1, String idtime2);

    @Select("select * from User_Companyverifydata where verifystate!='待审核' and examinetime between #{idtime1} and #{idtime2} order by examinetime desc")
    List<UserCompanyverifydata> getFilterVerifyCompanyData2(String idtime1, String idtime2);

    @Update("update User_Companyverifydata set examinetime=#{examinetime},examineadmin=#{examineadmin},verifystate=#{verifystate},remark=#{remark} where verifyid=#{verifyid}")
    void updateVerifyCompany(Integer verifyid, String examinetime, String examineadmin, String verifystate, String remark);

    @Select("select * from soil_hwsd")
    List<SoilHwsd> getHwsdList();

    @Update("update soil_hwsd set objectid=#{objectid},lng_84=#{lng84},lat_84=#{lat84},rastervalu=#{rastervalu},hwsd_china=#{hwsdChina},id=#{id},mu_global=#{muGlobal},mu_source1=#{muSource1},mu_source2=#{muSource2},issoil=#{issoil},share=#{share},seq=#{seq},su_sym74=#{suSym74},su_code74=#{suCode74},su_sym85=#{suSym85},su_code85=#{suCode85},su_sym90=#{suSym90},su_code90=#{suCode90},drainage=#{drainage},ref_depth=#{refDepth},awc_class=#{awcClass},phase1=#{phase1},phase2=#{phase2},roots=#{roots},il=#{il},swr=#{swr},add_prop=#{addProp},t_texture=#{ttexture},t_bs=#{tbs},t_teb=#{tteb},t_gravel=#{tgravel},t_cec_clay=#{tcecClay},t_cec_soil=#{tcecSoil},t_sand=#{tsand},t_clay=#{tclay},t_usda_tex_class=#{tusdaTexClass},t_ph_h2o=#{tphH2O},t_ref_bulk_density=#{trefBulkDensity},t_oc=#{toc},t_silt=#{tsilt},s_usda_tex_class=#{susdaTexClass},s_sand=#{ssand},s_oc=#{soc},s_ph_h2o=#{sphH2O},s_esp=#{tesp},s_ece=#{tece},s_cec_clay=#{scecClay},s_cec_soil=#{scecSoil},s_ref_bulk_density=#{srefBulkDensity},s_bs=#{sbs},s_silt=#{ssilt},s_teb=#{steb},s_gravel=#{sgravel},s_clay=#{sclay},t_caco3=#{tcaco3},t_caso4=#{tcaso4},s_caco3=#{scaco3},s_ece=#{sece},s_caso4=#{scaso4},s_esp=#{sesp} where fid=#{fid}")
    void updateHwsd(SoilHwsd soilHwsd);

    @Delete("delete from soil_hwsd where fid=#{fid}")
    void deleteHwsd(Integer fid);

    @Select("select max(id)+1 from soil_category_genetic")
    Integer getAutoSoilGid();

    @Insert("insert into soil_category_genetic values(#{id},#{soilType})")
    void addSoilGenricData(Integer id, String soilType);

    @Select("select count(*) from soil_category_g_details where id=#{id}")
    Integer getAutoSoilGDetailid(String id);

    @Insert("insert into soil_category_g_details values(#{pid},#{id},#{soilType})")
    void addSoilGenricDetailData(Integer id, String soilType, String pid);

    @Insert("insert into soil_category_fao90(value,symbol,chineseValue) values(#{value},#{symbol},#{chineseValue})")
    void addSoilFaoData(String value, String symbol, String chineseValue);

    @Delete("delete from soil_category_genetic where id=#{id}")
    void deleteSoilGData(Integer id);

    @Delete("delete from soil_category_g_details where detailid=#{id}")
    void deleteSoilGDetailData(String id);

    @Delete("delete from soil_category_fao90 where code=#{code}")
    void deleteFaoData(String code);

    @Select("select * from crop_productinfo ORDER BY cropid")
    List<CropProductinfo> getProductData();

    @Select("select * from crop_productinfo where cropname=#{cropname} and xyear=#{xyear} and provincename=#{provinceName}")
    List<CropProductinfo> getifProductData(CropProductinfo cropProductinfo);

    @Insert("insert into crop_productinfo values(#{provinceCode},#{provinceName},#{cropid},#{cropname},#{xyear},#{areaSeed},#{yieldTotal},#{yieldUnit})")
    void addProductData(CropProductinfo cropProductinfo);

    @Update("update crop_productinfo set areaSeed=#{areaSeed},yieldTotal=#{yieldTotal},yieldUnit=#{yieldUnit} where cropname=#{cropname} and xyear=#{xyear} and provincename=#{provinceName}")
    void updateProductData(CropProductinfo cropProductinfo);

    @Select("with tmp as (select *,ROW_NUMBER() OVER (ORDER BY cropid) as rownum from crop_productinfo)select rownum from tmp " +
            "where cropname=#{cropname} and xyear=#{xyear} and provinceName=#{provinceName}")
    Integer getNewProductRow(CropProductinfo cropProductinfo);

    @Delete("delete from crop_productinfo where cropname=#{cropname} and xyear=#{xyear} and provinceName=#{provinceName}")
    void deleteProductInfo(CropProductinfo cropProductinfo);

    @Select("select * from crop_productinfo where cropname=#{cropname} or xyear=#{xyear} or provincename=#{province}")
    List<CropProductinfo> filterProductInfo(String cropname, Integer xyear, String province);

    @Select("select * from crop_Wholesaleprice ORDER BY cropid")
    List<CropWholesaleprice> getPriceData();

    @Select("select * from crop_Wholesaleprice where cropname=#{cropname} and date=#{date} and province=#{province} ORDER BY cropid")
    List<CropWholesaleprice> filterPriceInfo(String cropname, String date, String province);

    @Select("select * from crop_Wholesaleprice where cropname=#{cropname} and date=#{date} and province=#{province} ORDER BY cropid")
    List<CropWholesaleprice> getifPriceData(CropWholesaleprice cropWholesaleprice);

    @Insert("insert into crop_Wholesaleprice values(#{cropid},#{cropname},#{date},#{province},#{marketname},#{marketcode},#{longitude},#{priceDifference},#{nextPriceMarket},#{priceMarketRate},#{priceMarket},#{latitude})")
    void addPriceData(CropWholesaleprice cropWholesaleprice);

    @Update("update crop_Wholesaleprice set price_Market=#{priceMarket},price_Market_Rate=#{priceMarketRate} where cropname=#{cropname} and date=#{date} and marketname=#{marketname}")
    void updatePriceData(CropWholesaleprice cropWholesaleprice);

    @Select("with tmp as (select *,ROW_NUMBER() OVER (ORDER BY cropid) as rownum from crop_Wholesaleprice)select rownum from tmp " +
            "where cropname=#{cropname} and date=#{date} and marketname=#{marketname}")
    Integer getNewPriceRow(CropWholesaleprice cropWholesaleprice);

    @Delete("delete from crop_Wholesaleprice where cropname=#{cropname} and date=#{date} and marketname=#{marketname}")
    void deletePriceInfo(CropWholesaleprice cropWholesaleprice);

    @Select("select * from Costprofitdata ORDER BY cropid")
    List<Costprofitdata> getProfitData();

    @Select("select * from Costprofitdata where cropname=#{cropname} and year=#{year} and province=#{province} and type=#{type} ORDER BY cropid")
    List<Costprofitdata> filterProfitInfo(String cropname, String year, String province, String type);
    @Select("select * from Costprofitdata where cropname=#{cropname} and year=#{year} and province=#{province} and type=#{type} ORDER BY cropid")
    List<Costprofitdata> getifProfitData(Costprofitdata costprofitdata);

    @Insert("insert into Costprofitdata values(#{cropid},#{cropname},#{year},#{value},#{province},#{type})")
    void addProfitData(Costprofitdata costprofitdata);

    @Delete("delete from Costprofitdata where cropname=#{cropname} and year=#{year} and province=#{province} and type=#{type}")
    void deleteProfitInfo(Costprofitdata costprofitdata);

    @Update("update Costprofitdata set value=#{value} where cropname=#{cropname} and year=#{year} and province=#{province} and type=#{type}")
    void updateProfitData(Costprofitdata costprofitdata);

    @Select("with tmp as (select *,ROW_NUMBER() OVER (ORDER BY cropid) as rownum from Costprofitdata)select rownum from tmp " +
            "where cropname=#{cropname} and year=#{year} and province=#{province} and type=#{type}")
    Integer getNewProfitRow(Costprofitdata costprofitdata);

    @Select("select a.*,b.username,b.avatarurl from topics a left join users b on a.creatorid=b.userid order by topicid desc")
    List<Topics> getTopicData();

    @Update("update topics set tittle=#{tittle},creatorId=#{creatorId},createTime=#{createTime},content=#{content} where topicid=#{topicId}")
    void updateTopic(Integer topicId, String tittle, String creatorId, String createTime, String content);

    @Delete("delete  from topics where topicid=#{topicid}")
    void deleteTopic(Integer topicid);

    @Update("update comments set content=#{content},commenttime=#{commenttime} where commentid=#{commentid}")
    void updateComment(Integer commentid, String content, String commenttime);

    @Delete("delete  from comments where commentid=#{commentid}")
    void deleteComment(Integer commentid);

    @Select("select * from knowledges order by id desc")
    List<Knowledges> getKnowledgeData();

    @Insert("insert into knowledges(tittle,editor,createtime,content)values(#{tittle},#{editor},#{createtime},#{content})")
    void addKnowledge(String tittle, String editor, String createtime, String content);

    @Update("update knowledges set content=#{content},editor=#{editor},createtime=#{createtime},tittle=#{tittle} where id=#{id}")
    void updateKnowledge(Integer id, String tittle, String editor, String createtime, String content);

    @Delete("delete  from knowledges where id=#{id}")
    void deleteKnowledge(Integer id);
}
