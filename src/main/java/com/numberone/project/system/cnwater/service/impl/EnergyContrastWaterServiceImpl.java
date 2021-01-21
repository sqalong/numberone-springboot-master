package com.numberone.project.system.cnwater.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.cnwater.mapper.EnergyContrastWaterMapper;
import com.numberone.project.system.cnwater.domain.EnergyContrastWater;
import com.numberone.project.system.cnwater.service.IEnergyContrastWaterService;
import com.numberone.common.utils.text.Convert;

/**
 * 场院曲线数据--水表Service业务层处理
 * 
 * @author sqalong
 * @date 2021-01-13
 */
@Service
public class EnergyContrastWaterServiceImpl implements IEnergyContrastWaterService 
{
    @Autowired
    private EnergyContrastWaterMapper energyContrastWaterMapper;

    /**
     * 查询场院曲线数据--水表
     * 
     * @param region 场院曲线数据--水表ID
     * @return 场院曲线数据--水表
     */
    @Override
    public EnergyContrastWater selectEnergyContrastWaterById(String region)
    {
        return energyContrastWaterMapper.selectEnergyContrastWaterById(region);
    }

    /**
     * 查询场院曲线数据--水表列表
     * 
     * @param energyContrastWater 场院曲线数据--水表
     * @return 场院曲线数据--水表
     */
    @Override
    public List<EnergyContrastWater> selectEnergyContrastWaterList(EnergyContrastWater energyContrastWater)
    {
        return energyContrastWaterMapper.selectEnergyContrastWaterList(energyContrastWater);
    }

    /**
     * 新增场院曲线数据--水表
     * 
     * @param energyContrastWater 场院曲线数据--水表
     * @return 结果
     */
    @Override
    public int insertEnergyContrastWater(EnergyContrastWater energyContrastWater)
    {
        return energyContrastWaterMapper.insertEnergyContrastWater(energyContrastWater);
    }

    /**
     * 修改场院曲线数据--水表
     * 
     * @param energyContrastWater 场院曲线数据--水表
     * @return 结果
     */
    @Override
    public int updateEnergyContrastWater(EnergyContrastWater energyContrastWater)
    {
        return energyContrastWaterMapper.updateEnergyContrastWater(energyContrastWater);
    }

    /**
     * 删除场院曲线数据--水表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEnergyContrastWaterByIds(String ids)
    {
        return energyContrastWaterMapper.deleteEnergyContrastWaterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除场院曲线数据--水表信息
     * 
     * @param region 场院曲线数据--水表ID
     * @return 结果
     */
    @Override
    public int deleteEnergyContrastWaterById(String region)
    {
        return energyContrastWaterMapper.deleteEnergyContrastWaterById(region);
    }
}
