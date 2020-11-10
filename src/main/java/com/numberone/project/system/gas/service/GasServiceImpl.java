package com.numberone.project.system.gas.service;

import com.numberone.project.system.gas.domain.Gas;
import com.numberone.project.system.gas.mapper.GasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色 业务层处理
 * 
 * @author numberone
 */
@Service
public class GasServiceImpl implements GasService
{
    @Autowired
    private GasMapper gas;

    @Override
    public List<Gas> selectGasList() {
        return gas.selectGasList();
    }
}
