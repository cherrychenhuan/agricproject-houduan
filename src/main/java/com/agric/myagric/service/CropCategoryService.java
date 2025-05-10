package com.agric.myagric.service;

import com.agric.myagric.pojo.*;

import java.util.List;

public interface CropCategoryService {
    //新增分类
    void add(Cropcategories Cropcategory);
    PageBean<Cropcategories> list(Integer pageNum, Integer pageSize);
    void delete(Integer id);
    Integer getNewID(String category);
    List<String> getGenusList(String family);

    Integer getRowNum(Integer id);

    void update(Cropcategories cropcategory);

    PageBean<Cropcategories> getSearchFilterList(Integer pageNum, Integer pageSize, String value);

    List<Cropcategories> getAllData();

    List<Cropcategories> getCropList();


    List<CropEcotypes> getEcotypeList(Integer cropid);

    List<CropVarities> getCropVarietyList(String ecotype);

    List<CropGenerictypes> getGenerictypeData(Integer cropid);

    List<Cropcategories> getCropBycategory(String category);

    Integer getNewEcotypeID(Integer cropid);


    void addEcotype(CropEcotypes cropEcotypes);

    void updateEcotype(CropEcotypes cropEcotypes);

    Integer getNewVarietyID(String ecotype,Integer ecotypeid);

    void addVariety(CropVarities cropVarities);

    void updateVariety(CropVarities cropVarities);

    void deleteEcotype(Integer ecotypeid);

    void deleteVariety(Integer varietyid);

    Integer getNewGenericID(Integer id);

    void addGenericType(CropGenerictypes cropGenerictypes);

    void updateGenericType(CropGenerictypes cropGenerictypes);

    void deleteGenericType(String genericid);
}
