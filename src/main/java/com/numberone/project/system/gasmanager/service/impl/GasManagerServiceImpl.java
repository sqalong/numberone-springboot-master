package com.numberone.project.system.gasmanager.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.gasmanager.mapper.GasManagerMapper;
import com.numberone.project.system.gasmanager.domain.GasManager;
import com.numberone.project.system.gasmanager.service.IGasManagerService;
import com.numberone.common.utils.text.Convert;

/**
 * gasmanagerService业务层处理
 * 
 * @author sqalong
 * @date 2020-12-23
 */
@Service
public class GasManagerServiceImpl implements IGasManagerService 
{
    @Autowired
    private GasManagerMapper gasManagerMapper;

    /**
     * 查询gasmanager
     * 
     * @param id gasmanagerID
     * @return gasmanager
     */
    @Override
    public GasManager selectGasManagerById(Long id)
    {
        return gasManagerMapper.selectGasManagerById(id);
    }

    /**
     * 查询gasmanager列表
     * 
     * @param gasManager gasmanager
     * @return gasmanager
     */
    @Override
    public List<GasManager> selectGasManagerList(GasManager gasManager)
    {
        return gasManagerMapper.selectGasManagerList(gasManager);
    }

    /**
     * 新增gasmanager
     * 
     * @param gasManager gasmanager
     * @return 结果
     */
    @Override
    public int insertGasManager(GasManager gasManager)
    {
        return gasManagerMapper.insertGasManager(gasManager);
    }

    /**
     * 修改gasmanager
     * 
     * @param gasManager gasmanager
     * @return 结果
     */
    @Override
    public int updateGasManager(GasManager gasManager)
    {
        return gasManagerMapper.updateGasManager(gasManager);
    }

    /**
     * 删除gasmanager对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGasManagerByIds(String ids)
    {
        return gasManagerMapper.deleteGasManagerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除gasmanager信息
     * 
     * @param id gasmanagerID
     * @return 结果
     */
    @Override
    public int deleteGasManagerById(Long id)
    {
        return gasManagerMapper.deleteGasManagerById(id);
    }
}
