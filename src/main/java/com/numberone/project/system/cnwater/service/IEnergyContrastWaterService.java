package com.numberone.project.system.cnwater.service;

import java.util.List;
import com.numberone.project.system.cnwater.domain.EnergyContrastWater;

/**
 * 场院曲线数据--水表Service接口
 * 
 * @author sqalong
 * @date 2021-01-13
 */
public interface IEnergyContrastWaterService 
{
    /**
     * 查询场院曲线数据--水表
     * 
     * @param region 场院曲线数据--水表ID
     * @return 场院曲线数据--水表
     */
    public EnergyContrastWater selectEnergyContrastWaterById(String region);

    /**
     * 查询场院曲线数据--水表列表
     * 
     * @param energyContrastWater 场院曲线数据--水表
     * @return 场院曲线数据--水表集合
     */
    public List<EnergyContrastWater> selectEnergyContrastWaterList(EnergyContrastWater energyContrastWater);

    /**
     * 新增场院曲线数据--水表
     * 
     * @param energyContrastWater 场院曲线数据--水表
     * @return 结果
     */
    public int insertEnergyContrastWater(EnergyContrastWater energyContrastWater);

    /**
     * 修改场院曲线数据--水表
     * 
     * @param energyContrastWater 场院曲线数据--水表
     * @return 结果
     */
    public int updateEnergyContrastWater(EnergyContrastWater energyContrastWater);

    /**
     * 批量删除场院曲线数据--水表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEnergyContrastWaterByIds(String ids);

    /**
     * 删除场院曲线数据--水表信息
     * 
     * @param region 场院曲线数据--水表ID
     * @return 结果
     */
    public int deleteEnergyContrastWaterById(String region);
}
