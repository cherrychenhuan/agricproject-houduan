package com.agric.myagric.service;

import com.agric.myagric.pojo.PageBean;
import com.agric.myagric.pojo.Wofostresult;

public interface GrowDataService {
    PageBean<Wofostresult> getHistoryGrowDataByCrop(Integer pageNum, Integer pageSize, String areacode, Integer cropid,Integer byear,Integer eyear);
}
