package com.numberone.project.system.cnwater.mapper;

import java.util.List;
import com.numberone.project.system.cnwater.domain.EnergyContrastWater;

/**
 * 场院曲线数据--水表Mapper接口
 * 
 * @author sqalong
 * @date 2021-01-13
 */
public interface EnergyContrastWaterMapper 
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
     * 删除场院曲线数据--水表
     * 
     * @param region 场院曲线数据--水表ID
     * @return 结果
     */
    public int deleteEnergyContrastWaterById(String region);

    /**
     * 批量删除场院曲线数据--水表
     * 
     * @param regions 需要删除的数据ID
     * @return 结果
     */
    public int deleteEnergyContrastWaterByIds(String[] regions);
}
