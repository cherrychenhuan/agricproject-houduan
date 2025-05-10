package com.agric.myagric.mapper;

import com.agric.myagric.pojo.Wofostresult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GrowDataMapper {

    @Select("select * from wofostresult where cropid=#{cropid} and areacode=#{areacode} and year(day)>=#{byear} and year(day)<=#{eyear}")
    List<Wofostresult> getHistoryGrowDataByCrop(String areacode, Integer cropid,Integer byear,Integer eyear);
}
