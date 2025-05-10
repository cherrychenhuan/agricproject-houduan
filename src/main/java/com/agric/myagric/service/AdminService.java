package com.agric.myagric.service;

import com.agric.myagric.pojo.*;

import java.util.List;

public interface AdminService {
    PageBean<User> getUserList(Integer pageNum, Integer pageSize);

    User addUser(User user);

    List<User> getAllusers();

    PageBean<User> userFilter(Integer pageNum,
                          Integer pageSize,
                          String value);

    PageBean<UserIdverifydata> getIdVerifyList(Integer pageNum, Integer pageSize, Integer flag);

    void updateVerifyIDData(Integer verifyid, String examinetime, String examineadmin, String verifystate, String remark);

    PageBean<UserIdverifydata> getFilterVerifyIDData(Integer pageNum, Integer pageSize, String idtime1, String idtime2,Integer flag);

    PageBean<UserCompanyverifydata> getCompanyVerifyList(Integer pageNum, Integer pageSize, Integer flag);

    PageBean<UserCompanyverifydata> getFilterVerifyCompanyData(Integer pageNum, Integer pageSize, String idtime1, String idtime2, Integer flag);

    void updateVerifyCompany(Integer verifyid, String examinetime, String examineadmin, String verifystate, String remark);

    PageBean<SoilHwsd> getHwsdList(Integer pageNum, Integer pageSize);

    void updateHwsd(SoilHwsd soilHwsd);

    void deleteHwsd(Integer fid);

    Integer getAutoSoilGid();

    void addSoilGenricData(Integer id, String soilType);


    Integer getAutoSoilGDetailid(String id);

    void addSoilGenricDetailData(Integer id, String soilType,String pid);

    void addSoilFaoData(String value, String symbol, String chineseValue);

    void deleteSoilGData(Integer id);

    void deleteSoilGDetailData(String id);

    void deleteFaoData(String code);

    PageBean<CropProductinfo> getProductData(Integer pageNum, Integer pageSize);

    List<CropProductinfo> getifProductData(CropProductinfo cropProductinfo);

    void addProductData(CropProductinfo cropProductinfo);

    void updateProductData(CropProductinfo cropProductinfo);

    Integer getNewProductRow(CropProductinfo cropProductinfo);

    void deleteProductInfo(CropProductinfo cropProductinfo);

    PageBean<CropProductinfo> filterProductInfo(String cropname, Integer xyear, String province,Integer pageNum, Integer pageSize);

    PageBean<CropWholesaleprice> getPriceData(Integer pageNum, Integer pageSize);

    PageBean<CropWholesaleprice> filterPriceInfo(String cropname, String date, String province, Integer pageNum, Integer pageSize);

    void addPriceData(CropWholesaleprice cropWholesaleprice);

    void updatePriceData(CropWholesaleprice cropWholesaleprice);

    Integer getNewPriceRow(CropWholesaleprice cropWholesaleprice);

    List<CropWholesaleprice> getifPriceData(CropWholesaleprice cropWholesaleprice);

    void deletePriceInfo(CropWholesaleprice cropWholesaleprice);

    PageBean<Costprofitdata> getProfitData(Integer pageNum, Integer pageSize);

    PageBean<Costprofitdata> filterProfitInfo(String cropname, String year, String province, String type, Integer pageNum, Integer pageSize);

    List<Costprofitdata> getifProfitData(Costprofitdata costprofitdata);

    void addProfitData(Costprofitdata costprofitdata);

    void deleteProfitInfo(Costprofitdata costprofitdata);

    void updateProfitData(Costprofitdata costprofitdata);

    Integer getNewProfitRow(Costprofitdata costprofitdata);

    PageBean<Topics> getTopicData(Integer pageNum, Integer pageSize);

    void updateTopic(Integer topicId,String tittle, String creatorId, String createTime, String content);

    void deleteTopic(Integer topicid);

    void updateComment(Integer commentid, String content, String commenttime);

    void deleteComment(Integer commentid);

    PageBean<Knowledges> getKnowledgeData(Integer pageNum, Integer pageSize);

    void addKnowledge(String tittle, String editor, String createtime, String content);

    void updateKnowledge(Integer id, String tittle, String editor, String createtime, String content);

    void deleteKnowledge(Integer id);
}
