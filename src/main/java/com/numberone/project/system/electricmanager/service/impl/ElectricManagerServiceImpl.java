package com.numberone.project.system.electricmanager.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.electricmanager.mapper.ElectricManagerMapper;
import com.numberone.project.system.electricmanager.domain.ElectricManager;
import com.numberone.project.system.electricmanager.service.IElectricManagerService;
import com.numberone.common.utils.text.Convert;

/**
 * electricmanagerService业务层处理
 * 
 * @author sqalong
 * @date 2020-12-21
 */
@Service
public class ElectricManagerServiceImpl implements IElectricManagerService 
{
    @Autowired
    private ElectricManagerMapper electricManagerMapper;

    /**
     * 查询electricmanager
     * 
     * @param id electricmanagerID
     * @return electricmanager
     */
    @Override
    public ElectricManager selectElectricManagerById(Long id)
    {
        return electricManagerMapper.selectElectricManagerById(id);
    }

    /**
     * 查询electricmanager列表
     * 
     * @param electricManager electricmanager
     * @return electricmanager
     */
    @Override
    public List<ElectricManager> selectElectricManagerList(ElectricManager electricManager)
    {
        return electricManagerMapper.selectElectricManagerList(electricManager);
    }

    /**
     * 新增electricmanager
     * 
     * @param electricManager electricmanager
     * @return 结果
     */
    @Override
    public int insertElectricManager(ElectricManager electricManager)
    {
        return electricManagerMapper.insertElectricManager(electricManager);
    }

    /**
     * 修改electricmanager
     * 
     * @param electricManager electricmanager
     * @return 结果
     */
    @Override
    public int updateElectricManager(ElectricManager electricManager)
    {
        return electricManagerMapper.updateElectricManager(electricManager);
    }

    /**
     * 删除electricmanager对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteElectricManagerByIds(String ids)
    {
        return electricManagerMapper.deleteElectricManagerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除electricmanager信息
     * 
     * @param id electricmanagerID
     * @return 结果
     */
    @Override
    public int deleteElectricManagerById(Long id)
    {
        return electricManagerMapper.deleteElectricManagerById(id);
    }
}
