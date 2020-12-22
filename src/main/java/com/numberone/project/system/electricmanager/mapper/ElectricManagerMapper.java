package com.numberone.project.system.electricmanager.mapper;

import java.util.List;
import com.numberone.project.system.electricmanager.domain.ElectricManager;

/**
 * electricmanagerMapper接口
 * 
 * @author sqalong
 * @date 2020-12-21
 */
public interface ElectricManagerMapper 
{
    /**
     * 查询electricmanager
     * 
     * @param id electricmanagerID
     * @return electricmanager
     */
    public ElectricManager selectElectricManagerById(Long id);

    /**
     * 查询electricmanager列表
     * 
     * @param electricManager electricmanager
     * @return electricmanager集合
     */
    public List<ElectricManager> selectElectricManagerList(ElectricManager electricManager);

    /**
     * 新增electricmanager
     * 
     * @param electricManager electricmanager
     * @return 结果
     */
    public int insertElectricManager(ElectricManager electricManager);

    /**
     * 修改electricmanager
     * 
     * @param electricManager electricmanager
     * @return 结果
     */
    public int updateElectricManager(ElectricManager electricManager);

    /**
     * 删除electricmanager
     * 
     * @param id electricmanagerID
     * @return 结果
     */
    public int deleteElectricManagerById(Long id);

    /**
     * 批量删除electricmanager
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteElectricManagerByIds(String[] ids);
}
