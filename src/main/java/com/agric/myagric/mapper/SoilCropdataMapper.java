package com.agric.myagric.mapper;

import com.agric.myagric.pojo.SoilCategoryFao90;
import com.agric.myagric.pojo.SoilCategoryGDetails;
import com.agric.myagric.pojo.SoilCategoryGenetic;
import com.agric.myagric.pojo.SoilCropdata;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
@Configuration
public interface SoilCropdataMapper {

    @Insert("INSERT INTO soil_cropdata(`SMW`, `SMFCF`, `CRAIRC`, `K0`, `SOPE`, `KSUB`, `SPADS`, `SPODS`, `SPASS`, `SPOSS`, `DEFLIM`, `soilname`, `lon`, `lat`, `SM0`, `smtabx`, `smtaby`, `contabx`, `contaby`,areacode) VALUES (#{smw}, #{smfcf}, #{crairc}, #{k0}, #{sope}, #{ksub}, #{spads}, #{spods}, #{spass}, #{sposs},#{deflim}, #{soilname}, #{lon}, #{lat}, #{sm0}, #{smtabx}, #{smtaby}, #{contabx}, #{contaby},#{areacode})")
    void add(SoilCropdata soilCropdata);

    @Update("update soil_cropdata set SMW=#{smw}, smfcf=#{smfcf}, crairc=#{crairc}, k0=#{k0}, sope=#{sope}, ksub=#{ksub}, spads=#{spads}, spods=#{spods}, spass=#{spass}, sposs=#{sposs},deflim=#{deflim}, soilname=#{soilname}, sm0=#{sm0}, smtabx=#{smtabx}, smtaby=#{smtaby}, contabx=#{contabx}, contaby=#{contaby} where lon=#{lon} and lat=#{lat}")
    void update(SoilCropdata soilCropdata);

    @Select("select * from soil_cropdata")
    List<SoilCropdata> getAllsoilCropDataList();

    @Delete("delete from soil_cropdata where soilid=#{soilid}")
    void delete(Integer soilid);


    @Select("select * from soil_category_fao90")
    List<SoilCategoryFao90> getSoilcategoryList();

    @Select("select * from soil_cropdata where areacode=#{areacode}")
    List<SoilCropdata> getAllsoilCropDataList1(String areacode);

    @Select("select * from soil_cropdata where soilname=#{soilcategory}")
    List<SoilCropdata> getAllsoilCropDataList2(String soilcategory);

    @Select("select * from soil_cropdata where areacode=#{areacode} and soilname=#{soilcategory}")
    List<SoilCropdata> getAllsoilCropDataList3(String areacode, String soilcategory);

    @Select("select * from soil_cropdata")
    List<SoilCropdata> getSoilcropAllData();

    @Select("select * from soil_category_genetic")
    List<SoilCategoryGenetic> getSoilGenericData();

    @Select("select * from soil_category_g_details where id=#{id}")
    List<SoilCategoryGDetails> soilGenericDataDetail(Integer id);

    @Select("select * from soil_category_fao90")
    List<SoilCategoryFao90> getSoilFao90Data();
}
