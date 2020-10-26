package com.numberone.project.system.uprush.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.uprush.mapper.EnergyUprushMapper;
import com.numberone.project.system.uprush.domain.EnergyUprush;
import com.numberone.project.system.uprush.service.IEnergyUprushService;
import com.numberone.common.utils.text.Convert;

/**
 * 模拟时间查询Service业务层处理
 * 
 * @author numberone
 * @date 2020-10-26
 */
@Service
public class EnergyUprushServiceImpl implements IEnergyUprushService 
{
    @Autowired
    private EnergyUprushMapper energyUprushMapper;

    /**
     * 查询模拟时间查询
     * 
     * @param id 模拟时间查询ID
     * @return 模拟时间查询
     */
    @Override
    public EnergyUprush selectEnergyUprushById(Long id)
    {
        return energyUprushMapper.selectEnergyUprushById(id);
    }

    /**
     * 查询模拟时间查询列表
     * 
     * @param energyUprush 模拟时间查询
     * @return 模拟时间查询
     */
    @Override
    public List<EnergyUprush> selectEnergyUprushList(EnergyUprush energyUprush)
    {
        return energyUprushMapper.selectEnergyUprushList(energyUprush);
    }

    /**
     * 新增模拟时间查询
     * 
     * @param energyUprush 模拟时间查询
     * @return 结果
     */
    @Override
    public int insertEnergyUprush(EnergyUprush energyUprush)
    {
        return energyUprushMapper.insertEnergyUprush(energyUprush);
    }

    /**
     * 修改模拟时间查询
     * 
     * @param energyUprush 模拟时间查询
     * @return 结果
     */
    @Override
    public int updateEnergyUprush(EnergyUprush energyUprush)
    {
        return energyUprushMapper.updateEnergyUprush(energyUprush);
    }

    /**
     * 删除模拟时间查询对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEnergyUprushByIds(String ids)
    {
        return energyUprushMapper.deleteEnergyUprushByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除模拟时间查询信息
     * 
     * @param id 模拟时间查询ID
     * @return 结果
     */
    @Override
    public int deleteEnergyUprushById(Long id)
    {
        return energyUprushMapper.deleteEnergyUprushById(id);
    }
}
