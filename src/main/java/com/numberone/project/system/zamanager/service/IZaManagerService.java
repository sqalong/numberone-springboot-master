package com.numberone.project.system.zamanager.service;

import java.util.List;
import com.numberone.project.system.zamanager.domain.ZaManager;

/**
 * 大屏展示数据Service接口
 * 
 * @author sqalong
 * @date 2020-12-16
 */
public interface IZaManagerService 
{
    /**
     * 查询大屏展示数据
     * 
     * @param id 大屏展示数据ID
     * @return 大屏展示数据
     */
    public ZaManager selectZaManagerById(Long id);

    /**
     * 查询大屏展示数据列表
     * 
     * @param zaManager 大屏展示数据
     * @return 大屏展示数据集合
     */
    public List<ZaManager> selectZaManagerList(ZaManager zaManager);

    /**
     * 新增大屏展示数据
     * 
     * @param zaManager 大屏展示数据
     * @return 结果
     */
    public int insertZaManager(ZaManager zaManager);

    /**
     * 修改大屏展示数据
     * 
     * @param zaManager 大屏展示数据
     * @return 结果
     */
    public int updateZaManager(ZaManager zaManager);

    /**
     * 批量删除大屏展示数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZaManagerByIds(String ids);

    /**
     * 删除大屏展示数据信息
     * 
     * @param id 大屏展示数据ID
     * @return 结果
     */
    public int deleteZaManagerById(Long id);
}
