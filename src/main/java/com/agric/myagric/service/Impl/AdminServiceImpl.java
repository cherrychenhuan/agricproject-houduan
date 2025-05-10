package com.agric.myagric.service.Impl;

import com.agric.myagric.mapper.AdminMapper;
import com.agric.myagric.mapper.AreaMapper;
import com.agric.myagric.pojo.*;
import com.agric.myagric.service.AdminService;
import com.agric.myagric.utils.Md5Util;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public PageBean<User> getUserList(Integer pageNum, Integer pageSize) {
        //1.创建PageBean对象
        PageBean<User> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);

        //3.调用mapper
//        Map<String,Object> map = ThreadLocalUtil.get();
        List<User> as = adminMapper.getUserList();
        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<User> p = (Page<User>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public User addUser(User user) {
        String md5String = Md5Util.getMD5String(user.getPassword());
        user.setPassword(md5String);
        adminMapper.addUser(user);
        return user;
    }

    @Override
    public List<User> getAllusers() {
        return adminMapper.getAllusers();
    }

    @Override
    public PageBean<User> userFilter(Integer pageNum,
                                 Integer pageSize,
                                 String value) {
        //1.创建PageBean对象
        PageBean<User> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);

        //3.调用mapper
//        Map<String,Object> map = ThreadLocalUtil.get();
        List<User> as = adminMapper.userFilter(value);
        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<User> p = (Page<User>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBean<UserIdverifydata> getIdVerifyList(Integer pageNum, Integer pageSize, Integer flag) {
        //1.创建PageBean对象
        PageBean<UserIdverifydata> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<UserIdverifydata> as;
        //3.调用mapper
//        Map<String,Object> map = ThreadLocalUtil.get();
        if(flag==0) as = adminMapper.getIdVerifyList1();
        else as = adminMapper.getIdVerifyList2();
        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<UserIdverifydata> p = (Page<UserIdverifydata>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void updateVerifyIDData(Integer verifyid, String examinetime, String examineadmin, String verifystate, String remark) {
        adminMapper.updateVerifyIDData(verifyid,examinetime,examineadmin,verifystate,remark);
    }

    @Override
    public PageBean<UserIdverifydata> getFilterVerifyIDData(Integer pageNum, Integer pageSize, String idtime1, String idtime2,Integer flag) {
        //1.创建PageBean对象
        PageBean<UserIdverifydata> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<UserIdverifydata> as;
        if(flag==0) as=adminMapper.getFilterVerifyIDData1(idtime1,idtime2);
        else as=adminMapper.getFilterVerifyIDData2(idtime1,idtime2);
        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<UserIdverifydata> p = (Page<UserIdverifydata>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBean<UserCompanyverifydata> getCompanyVerifyList(Integer pageNum, Integer pageSize, Integer flag) {
        //1.创建PageBean对象
        PageBean<UserCompanyverifydata> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<UserCompanyverifydata> as;
        //3.调用mapper
//        Map<String,Object> map = ThreadLocalUtil.get();
        if(flag==0) as = adminMapper.getCompanyVerifyList1();
        else as = adminMapper.getCompanyVerifyList2();
        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<UserCompanyverifydata> p = (Page<UserCompanyverifydata>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBean<UserCompanyverifydata> getFilterVerifyCompanyData(Integer pageNum, Integer pageSize, String idtime1, String idtime2, Integer flag) {
        //1.创建PageBean对象
        PageBean<UserCompanyverifydata> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<UserCompanyverifydata> as;
        if(flag==0) as=adminMapper.getFilterVerifyCompanyData1(idtime1,idtime2);
        else as=adminMapper.getFilterVerifyCompanyData2(idtime1,idtime2);
        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<UserCompanyverifydata> p = (Page<UserCompanyverifydata>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void updateVerifyCompany(Integer verifyid, String examinetime, String examineadmin, String verifystate, String remark) {
        adminMapper.updateVerifyCompany(verifyid,examinetime,examineadmin,verifystate,remark);

    }

    @Override
    public PageBean<SoilHwsd> getHwsdList(Integer pageNum, Integer pageSize) {
        //1.创建PageBean对象
        PageBean<SoilHwsd> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<SoilHwsd> as;
       as=adminMapper.getHwsdList();

        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<SoilHwsd> p = (Page<SoilHwsd>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void updateHwsd(SoilHwsd soilHwsd) {
        adminMapper.updateHwsd(soilHwsd);
    }

    @Override
    public void deleteHwsd(Integer fid) {
        adminMapper.deleteHwsd(fid);
    }

    @Override
    public Integer getAutoSoilGid() {
        return adminMapper.getAutoSoilGid();
    }

    @Override
    public void addSoilGenricData(Integer id, String soilType) {
        adminMapper.addSoilGenricData(id,soilType);
    }

    @Override
    public Integer getAutoSoilGDetailid(String id) {
        return adminMapper.getAutoSoilGDetailid(id);
    }

    @Override
    public void addSoilGenricDetailData(Integer id, String soilType,String pid) {
        adminMapper.addSoilGenricDetailData(id,soilType,pid);
    }

    @Override
    public void addSoilFaoData(String value, String symbol, String chineseValue) {
        adminMapper.addSoilFaoData(value,symbol,chineseValue);
    }

    @Override
    public void deleteSoilGData(Integer id) {
        adminMapper.deleteSoilGData(id);
    }

    @Override
    public void deleteSoilGDetailData(String id) {
        adminMapper.deleteSoilGDetailData(id);
    }

    @Override
    public void deleteFaoData(String code) {
        adminMapper.deleteFaoData(code);
    }

    @Override
    public PageBean<CropProductinfo> getProductData(Integer pageNum, Integer pageSize) {
        //1.创建PageBean对象
        PageBean<CropProductinfo> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<CropProductinfo> as;
        as=adminMapper.getProductData();

        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<CropProductinfo> p = (Page<CropProductinfo>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public List<CropProductinfo> getifProductData(CropProductinfo cropProductinfo) {
        return adminMapper.getifProductData(cropProductinfo);
    }

    @Override
    public void addProductData(CropProductinfo cropProductinfo) {
        adminMapper.addProductData(cropProductinfo);
    }

    @Override
    public void updateProductData(CropProductinfo cropProductinfo) {
        adminMapper.updateProductData(cropProductinfo);
    }

    @Override
    public Integer getNewProductRow(CropProductinfo cropProductinfo) {
        return adminMapper.getNewProductRow(cropProductinfo);
    }

    @Override
    public void deleteProductInfo(CropProductinfo cropProductinfo) {
        adminMapper.deleteProductInfo(cropProductinfo);
    }

    @Override
    public PageBean<CropProductinfo> filterProductInfo(String cropname, Integer xyear, String province,Integer pageNum, Integer pageSize) {
        //1.创建PageBean对象
        PageBean<CropProductinfo> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<CropProductinfo> as;
        as=adminMapper.filterProductInfo(cropname,xyear,province);

        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<CropProductinfo> p = (Page<CropProductinfo>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBean<CropWholesaleprice> getPriceData(Integer pageNum, Integer pageSize) {
        //1.创建PageBean对象
        PageBean<CropWholesaleprice> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<CropWholesaleprice> as;
        as=adminMapper.getPriceData();

        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<CropWholesaleprice> p = (Page<CropWholesaleprice>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBean<CropWholesaleprice> filterPriceInfo(String cropname, String date, String province, Integer pageNum, Integer pageSize) {
        //1.创建PageBean对象
        PageBean<CropWholesaleprice> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<CropWholesaleprice> as;
        as=adminMapper.filterPriceInfo(cropname,date,province);

        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<CropWholesaleprice> p = (Page<CropWholesaleprice>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void addPriceData(CropWholesaleprice cropWholesaleprice) {
        adminMapper.addPriceData(cropWholesaleprice);
    }

    @Override
    public void updatePriceData(CropWholesaleprice cropWholesaleprice) {
        adminMapper.updatePriceData(cropWholesaleprice);
    }

    @Override
    public Integer getNewPriceRow(CropWholesaleprice cropWholesaleprice) {
        return adminMapper.getNewPriceRow(cropWholesaleprice);
    }

    @Override
    public List<CropWholesaleprice> getifPriceData(CropWholesaleprice cropWholesaleprice) {
        return adminMapper.getifPriceData(cropWholesaleprice);
    }

    @Override
    public void deletePriceInfo(CropWholesaleprice cropWholesaleprice) {
        adminMapper.deletePriceInfo(cropWholesaleprice);
    }

    @Override
    public PageBean<Costprofitdata> getProfitData(Integer pageNum, Integer pageSize) {
        //1.创建PageBean对象
        PageBean<Costprofitdata> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<Costprofitdata> as;
        as=adminMapper.getProfitData();

        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<Costprofitdata> p = (Page<Costprofitdata>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBean<Costprofitdata> filterProfitInfo(String cropname, String year, String province, String type, Integer pageNum, Integer pageSize) {
        //1.创建PageBean对象
        PageBean<Costprofitdata> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<Costprofitdata> as;
        as=adminMapper.filterProfitInfo(cropname,year,province,type);

        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<Costprofitdata> p = (Page<Costprofitdata>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public List<Costprofitdata> getifProfitData(Costprofitdata costprofitdata) {
        return adminMapper.getifProfitData(costprofitdata);
    }

    @Override
    public void addProfitData(Costprofitdata costprofitdata) {
        adminMapper.addProfitData(costprofitdata);
    }

    @Override
    public void deleteProfitInfo(Costprofitdata costprofitdata) {
        adminMapper.deleteProfitInfo(costprofitdata);
    }

    @Override
    public void updateProfitData(Costprofitdata costprofitdata) {
        adminMapper.updateProfitData(costprofitdata);
    }

    @Override
    public Integer getNewProfitRow(Costprofitdata costprofitdata) {
        return adminMapper.getNewProfitRow(costprofitdata);
    }

    @Override
    public PageBean<Topics> getTopicData(Integer pageNum, Integer pageSize) {
        //1.创建PageBean对象
        PageBean<Topics> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<Topics> as;
        as=adminMapper.getTopicData();

        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<Topics> p = (Page<Topics>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void updateTopic(Integer topicId,String tittle, String creatorId, String createTime, String content) {
        adminMapper.updateTopic(topicId,tittle,creatorId,createTime,content);
    }

    @Override
    public void deleteTopic(Integer topicid) {
        adminMapper.deleteTopic(topicid);
    }

    @Override
    public void updateComment(Integer commentid, String content, String commenttime) {
        adminMapper.updateComment(commentid,content,commenttime);
    }

    @Override
    public void deleteComment(Integer commentid) {
        adminMapper.deleteComment(commentid);
    }

    @Override
    public PageBean<Knowledges> getKnowledgeData(Integer pageNum, Integer pageSize) {
        //1.创建PageBean对象
        PageBean<Knowledges> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);
        List<Knowledges> as;
        as=adminMapper.getKnowledgeData();

        //Page中提供了方法,可以获取PageHelper（插件 需要导入）分页查询后 得到的总记录条数和当前页数据
        Page<Knowledges> p = (Page<Knowledges>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void addKnowledge(String tittle, String editor, String createtime, String content) {
        adminMapper.addKnowledge(tittle,editor,createtime,content);
    }

    @Override
    public void updateKnowledge(Integer id, String tittle, String editor, String createtime, String content) {
        adminMapper.updateKnowledge(id,tittle,editor,createtime,content);
    }

    @Override
    public void deleteKnowledge(Integer id) {
        adminMapper.deleteKnowledge(id);
    }
}
