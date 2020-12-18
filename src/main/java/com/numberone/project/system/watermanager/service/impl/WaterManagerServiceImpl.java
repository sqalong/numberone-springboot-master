package com.numberone.project.system.watermanager.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.watermanager.mapper.WaterManagerMapper;
import com.numberone.project.system.watermanager.domain.WaterManager;
import com.numberone.project.system.watermanager.service.IWaterManagerService;
import com.numberone.common.utils.text.Convert;

/**
 * watermanagerService业务层处理
 * 
 * @author sqalong
 * @date 2020-12-17
 */
@Service
public class WaterManagerServiceImpl implements IWaterManagerService 
{
    @Autowired
    private WaterManagerMapper waterManagerMapper;

    /**
     * 查询watermanager
     * 
     * @param id watermanagerID
     * @return watermanager
     */
    @Override
    public WaterManager selectWaterManagerById(Long id)
    {
        return waterManagerMapper.selectWaterManagerById(id);
    }

    /**
     * 查询watermanager列表
     * 
     * @param waterManager watermanager
     * @return watermanager
     */
    @Override
    public List<WaterManager> selectWaterManagerList(WaterManager waterManager)
    {
        return waterManagerMapper.selectWaterManagerList(waterManager);
    }

    /**
     * 新增watermanager
     * 
     * @param waterManager watermanager
     * @return 结果
     */
    @Override
    public int insertWaterManager(WaterManager waterManager)
    {
        return waterManagerMapper.insertWaterManager(waterManager);
    }

    /**
     * 修改watermanager
     * 
     * @param waterManager watermanager
     * @return 结果
     */
    @Override
    public int updateWaterManager(WaterManager waterManager)
    {
        return waterManagerMapper.updateWaterManager(waterManager);
    }

    /**
     * 删除watermanager对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWaterManagerByIds(String ids)
    {
        return waterManagerMapper.deleteWaterManagerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除watermanager信息
     * 
     * @param id watermanagerID
     * @return 结果
     */
    @Override
    public int deleteWaterManagerById(Long id)
    {
        return waterManagerMapper.deleteWaterManagerById(id);
    }
}
