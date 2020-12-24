package com.numberone.project.system.gasmanager.service;

import java.util.List;
import com.numberone.project.system.gasmanager.domain.GasManager;

/**
 * gasmanagerService接口
 * 
 * @author sqalong
 * @date 2020-12-23
 */
public interface IGasManagerService 
{
    /**
     * 查询gasmanager
     * 
     * @param id gasmanagerID
     * @return gasmanager
     */
    public GasManager selectGasManagerById(Long id);

    /**
     * 查询gasmanager列表
     * 
     * @param gasManager gasmanager
     * @return gasmanager集合
     */
    public List<GasManager> selectGasManagerList(GasManager gasManager);

    /**
     * 新增gasmanager
     * 
     * @param gasManager gasmanager
     * @return 结果
     */
    public int insertGasManager(GasManager gasManager);

    /**
     * 修改gasmanager
     * 
     * @param gasManager gasmanager
     * @return 结果
     */
    public int updateGasManager(GasManager gasManager);

    /**
     * 批量删除gasmanager
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGasManagerByIds(String ids);

    /**
     * 删除gasmanager信息
     * 
     * @param id gasmanagerID
     * @return 结果
     */
    public int deleteGasManagerById(Long id);
}
