package com.numberone.project.system.water.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.water.mapper.WaterMapper;
import com.numberone.project.system.water.domain.Water;
import java.util.*;

/**
 * 角色 业务层处理
 * 
 * @author numberone
 */
@Service
public class WaterServiceImpl implements WaterService
{
    @Autowired
    private WaterMapper w;




    @Override
    public List<Water> selectWaterList() {
        return w.selectWaterList();
    }

    @Override
    public Water wsum() {
        return w.wsum();
    }
}
