package com.numberone.project.system.areaelectric.mapper;

import java.util.List;
import com.numberone.project.system.areaelectric.domain.Areaelectric;

/**
 * areaelectricMapper接口
 * 
 * @author sqalong
 * @date 2021-01-11
 */
public interface AreaelectricMapper 
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
     * 删除areaelectric
     * 
     * @param id areaelectricID
     * @return 结果
     */
    public int deleteAreaelectricById(Long id);

    /**
     * 批量删除areaelectric
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAreaelectricByIds(String[] ids);
}
