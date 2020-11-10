package com.numberone.project.system.electric.service;

import com.numberone.project.system.electric.domain.Electric;
import com.numberone.project.system.electric.mapper.ElectricMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色 业务层处理
 * 
 * @author numberone
 */
@Service
public class ElectricServiceImpl implements ElectricService
{
    @Autowired
    private ElectricMapper electricMapper;




    @Override
    public List<Electric> selectElectricList() {
        return electricMapper.selectElectricList();
    }
}
