package com.agric.myagric.mapper;

import com.agric.myagric.pojo.AreaVillages;
import com.agric.myagric.pojo.Areas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
@Configuration
@MapperScan("com.agric.myagric.mapper")
public interface AreaMapper {



    @Select("select * from areas where pcode = #{xcode}")
    List<Areas> getAreaList(String xcode);

    @Select("select * from areas where level = 1")
    List<Areas> getProvinceList();

    @Select("select * from area_villages where villagecode=#{code}")
    List<AreaVillages> getLocation1(String code);
    @Select("select * from area_villages where citycode=#{code}")
    List<AreaVillages> getLocation2(String code);
    @Select("select * from area_villages where countycode=#{code}")
    List<AreaVillages> getLocation3(String code);

    @Select("select * from areas where pcode=#{pcode} and level=#{level}")
    List<Areas> getTreeArealist(String pcode, Integer level);

    @Select("select * from area_villages where villagecode=#{code}")
    List<AreaVillages> getAreaInfo(String code);
}
