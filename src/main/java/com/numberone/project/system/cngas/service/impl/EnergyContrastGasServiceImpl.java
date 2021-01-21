package com.numberone.project.system.cngas.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.cngas.mapper.EnergyContrastGasMapper;
import com.numberone.project.system.cngas.domain.EnergyContrastGas;
import com.numberone.project.system.cngas.service.IEnergyContrastGasService;
import com.numberone.common.utils.text.Convert;

/**
 * 场院曲线数据--气表Service业务层处理
 * 
 * @author sqalong
 * @date 2021-01-13
 */
@Service
public class EnergyContrastGasServiceImpl implements IEnergyContrastGasService 
{
    @Autowired
    private EnergyContrastGasMapper energyContrastGasMapper;

    /**
     * 查询场院曲线数据--气表
     * 
     * @param region 场院曲线数据--气表ID
     * @return 场院曲线数据--气表
     */
    @Override
    public EnergyContrastGas selectEnergyContrastGasById(String region)
    {
        return energyContrastGasMapper.selectEnergyContrastGasById(region);
    }

    /**
     * 查询场院曲线数据--气表列表
     * 
     * @param energyContrastGas 场院曲线数据--气表
     * @return 场院曲线数据--气表
     */
    @Override
    public List<EnergyContrastGas> selectEnergyContrastGasList(EnergyContrastGas energyContrastGas)
    {
        return energyContrastGasMapper.selectEnergyContrastGasList(energyContrastGas);
    }

    /**
     * 新增场院曲线数据--气表
     * 
     * @param energyContrastGas 场院曲线数据--气表
     * @return 结果
     */
    @Override
    public int insertEnergyContrastGas(EnergyContrastGas energyContrastGas)
    {
        return energyContrastGasMapper.insertEnergyContrastGas(energyContrastGas);
    }

    /**
     * 修改场院曲线数据--气表
     * 
     * @param energyContrastGas 场院曲线数据--气表
     * @return 结果
     */
    @Override
    public int updateEnergyContrastGas(EnergyContrastGas energyContrastGas)
    {
        return energyContrastGasMapper.updateEnergyContrastGas(energyContrastGas);
    }

    /**
     * 删除场院曲线数据--气表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEnergyContrastGasByIds(String ids)
    {
        return energyContrastGasMapper.deleteEnergyContrastGasByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除场院曲线数据--气表信息
     * 
     * @param region 场院曲线数据--气表ID
     * @return 结果
     */
    @Override
    public int deleteEnergyContrastGasById(String region)
    {
        return energyContrastGasMapper.deleteEnergyContrastGasById(region);
    }
}
