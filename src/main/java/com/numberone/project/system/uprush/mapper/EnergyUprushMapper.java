package com.numberone.project.system.uprush.mapper;

import java.util.List;
import com.numberone.project.system.uprush.domain.EnergyUprush;

/**
 * 模拟时间查询Mapper接口
 * 
 * @author numberone
 * @date 2020-10-26
 */
public interface EnergyUprushMapper 
{
    /**
     * 查询模拟时间查询
     * 
     * @param id 模拟时间查询ID
     * @return 模拟时间查询
     */
    public EnergyUprush selectEnergyUprushById(Long id);

    /**
     * 查询模拟时间查询列表
     * 
     * @param energyUprush 模拟时间查询
     * @return 模拟时间查询集合
     */
    public List<EnergyUprush> selectEnergyUprushList(EnergyUprush energyUprush);

    /**
     * 新增模拟时间查询
     * 
     * @param energyUprush 模拟时间查询
     * @return 结果
     */
    public int insertEnergyUprush(EnergyUprush energyUprush);

    /**
     * 修改模拟时间查询
     * 
     * @param energyUprush 模拟时间查询
     * @return 结果
     */
    public int updateEnergyUprush(EnergyUprush energyUprush);

    /**
     * 删除模拟时间查询
     * 
     * @param id 模拟时间查询ID
     * @return 结果
     */
    public int deleteEnergyUprushById(Long id);

    /**
     * 批量删除模拟时间查询
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEnergyUprushByIds(String[] ids);
}
