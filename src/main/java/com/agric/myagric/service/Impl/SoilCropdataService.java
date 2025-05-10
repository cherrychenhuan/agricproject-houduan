package com.agric.myagric.service;

import com.agric.myagric.pojo.*;

import java.util.List;

public interface SoilCropdataService {
    void add(SoilCropdata soilCropdata);

    void update(SoilCropdata soilCropdata);


    PageBean<SoilCropdata> getAllsoilCropDataList(Integer pageNum, Integer pageSize);

    void delete(Integer soilid);

    List<SoilCategoryFao90> getSoilcategoryList();

    PageBean<SoilCropdata> getSoilFilterList(Integer pageNum, Integer pageSize, String areacode, String soilcategory, Integer flag);

    PageBean<SoilCropdata> getSoilFilterList1(Integer pageNum, Integer pageSize, String areacode);

    PageBean<SoilCropdata> getSoilFilterList2(Integer pageNum, Integer pageSize, String soilcategory);

    PageBean<SoilCropdata> getSoilFilterList3(Integer pageNum, Integer pageSize, String areacode, String soilcategory);

    List<SoilCropdata> getSoilcropAllData();

    List<SoilCategoryGenetic> getSoilGenericData();

    List<SoilCategoryGDetails> soilGenericDataDetail(Integer id);

    List<SoilCategoryFao90> getSoilFao90Data();
}
