package com.agric.myagric.service;

import com.agric.myagric.pojo.Areas;
import com.agric.myagric.pojo.Cropcategories;
import com.agric.myagric.pojo.AreaVillages;
import java.util.List;

public interface AreaService {



    List<Areas> getAreaList(String code);

    List<Areas> getProvinceList();

    List<AreaVillages> getLocation(String code,Integer flag);

    List<Areas> getTreeArealist(String pcode, Integer level);

    List<AreaVillages> getAreaInfo(String code);
}
