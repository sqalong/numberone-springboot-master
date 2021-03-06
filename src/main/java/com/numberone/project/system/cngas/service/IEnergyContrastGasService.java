package com.numberone.project.system.cngas.service;

import java.util.List;
import com.numberone.project.system.cngas.domain.EnergyContrastGas;

/**
 * 场院曲线数据--气表Service接口
 * 
 * @author sqalong
 * @date 2021-01-13
 */
public interface IEnergyContrastGasService 
{
    /**
     * 查询场院曲线数据--气表
     * 
     * @param region 场院曲线数据--气表ID
     * @return 场院曲线数据--气表
     */
    public EnergyContrastGas selectEnergyContrastGasById(String region);

    /**
     * 查询场院曲线数据--气表列表
     * 
     * @param energyContrastGas 场院曲线数据--气表
     * @return 场院曲线数据--气表集合
     */
    public List<EnergyContrastGas> selectEnergyContrastGasList(EnergyContrastGas energyContrastGas);

    /**
     * 新增场院曲线数据--气表
     * 
     * @param energyContrastGas 场院曲线数据--气表
     * @return 结果
     */
    public int insertEnergyContrastGas(EnergyContrastGas energyContrastGas);

    /**
     * 修改场院曲线数据--气表
     * 
     * @param energyContrastGas 场院曲线数据--气表
     * @return 结果
     */
    public int updateEnergyContrastGas(EnergyContrastGas energyContrastGas);

    /**
     * 批量删除场院曲线数据--气表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEnergyContrastGasByIds(String ids);

    /**
     * 删除场院曲线数据--气表信息
     * 
     * @param region 场院曲线数据--气表ID
     * @return 结果
     */
    public int deleteEnergyContrastGasById(String region);
}
