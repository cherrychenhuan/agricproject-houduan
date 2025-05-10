package com.agric.myagric.service;
import com.agric.myagric.pojo.*;

import java.util.List;

public interface UserService {
    User findByPhone(String phone);

    void register(String phone, String userid, String password);

    void update(User user);

    String toSendMessage(String phone);

    String checkMsg(String phone, String code);

    void resetpwd(String phone, String password);

    void deleteUser(String userid);

    void addVerifyData(String userid, String realname, String idnumber, String verifytime);

    UserIdverifydata getVerifyIDState(String userid);

    void addVerifyCompany(String userid, String companyname, String tellphone, String mainactivity, String verifytime);

    UserCompanyverifydata getVerifyCompanyState(String userid);

    byte[] getAvatar(String filePath);

    List<RecommendHistory> getRecommendRecordTimeList(String userid);

    List<AreaVillages> getAddressBycode(String areacode);

    void deleteRecommendRecord(String userid, String createtime);

    void deleteRecommendRecordAll(String userid);
}
