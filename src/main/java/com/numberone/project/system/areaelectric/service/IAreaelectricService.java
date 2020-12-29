package com.numberone.project.system.areaelectric.service;

import java.util.List;
import com.numberone.project.system.areaelectric.domain.Areaelectric;
import com.numberone.framework.web.domain.Ztree;

/**
 * areaelectricService接口
 * 
 * @author sqalong
 * @date 2020-12-29
 */
public interface IAreaelectricService 
{
    /**
     * 查询areaelectric
     * 
     * @param id areaelectricID
     * @return areaelectric
     */
    public Areaelectric selectAreaelectricById(Long id);

    /**
     * 查询areaelectric列表
     * 
     * @param areaelectric areaelectric
     * @return areaelectric集合
     */
    public List<Areaelectric> selectAreaelectricList(Areaelectric areaelectric);

    /**
     * 新增areaelectric
     * 
     * @param areaelectric areaelectric
     * @return 结果
     */
    public int insertAreaelectric(Areaelectric areaelectric);

    /**
     * 修改areaelectric
     * 
     * @param areaelectric areaelectric
     * @return 结果
     */
    public int updateAreaelectric(Areaelectric areaelectric);

    /**
     * 批量删除areaelectric
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAreaelectricByIds(String ids);

    /**
     * 删除areaelectric信息
     * 
     * @param id areaelectricID
     * @return 结果
     */
    public int deleteAreaelectricById(Long id);

    /**
     * 查询areaelectric树列表
     * 
     * @return 所有areaelectric信息
     */
    public List<Ztree> selectAreaelectricTree();
}
