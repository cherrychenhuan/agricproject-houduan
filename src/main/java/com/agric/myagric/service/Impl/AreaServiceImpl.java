package com.agric.myagric.service.Impl;

import com.agric.myagric.mapper.AreaMapper;
import com.agric.myagric.mapper.CropCategoryMapper;
import com.agric.myagric.pojo.Areas;
import com.agric.myagric.pojo.Cropcategories;
import com.agric.myagric.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agric.myagric.pojo.AreaVillages;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public List<Areas> getAreaList(String code) {
        return areaMapper.getAreaList(code);
    }
    @Override
    public List<Areas> getProvinceList() {
        return areaMapper.getProvinceList();
    }
    @Override
    public List<AreaVillages> getLocation(String code,Integer flag) {
        if(flag==1) {//常规调用
            return areaMapper.getLocation1(code);
        } else if (flag==2) {//如果县级以下为空
            return areaMapper.getLocation2(code);
        }else if(flag==3) {//如果县级以下为空
            return areaMapper.getLocation3(code);
        }
        else{
            return null;
        }
    }
    @Override
    public List<Areas> getTreeArealist(String pcode, Integer level) {
        return areaMapper.getTreeArealist(pcode,level);
    }

    @Override
    public List<AreaVillages> getAreaInfo(String code) {
        return areaMapper.getAreaInfo(code);
    }
}
