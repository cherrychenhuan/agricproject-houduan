package com.agric.myagric.mapper;

import com.agric.myagric.pojo.Soil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SoilMapper {
    @Select ("select * from soiltype where id = #{id}")
    public Soil findByID(int id);

}

