package com.numberone.project.system.areawater.service;

import java.util.List;
import com.numberone.project.system.areawater.domain.Areawater;

/**
 * areawaterService接口
 * 
 * @author sqalong
 * @date 2020-12-28
 */
public interface IAreawaterService 
{
    /**
     * 查询areawater
     * 
     * @param id areawaterID
     * @return areawater
     */
    public Areawater selectAreawaterById(Long id);

    /**
     * 查询areawater列表
     * 
     * @param areawater areawater
     * @return areawater集合
     */
    public List<Areawater> selectAreawaterList(Areawater areawater);

    /**
     * 新增areawater
     * 
     * @param areawater areawater
     * @return 结果
     */
    public int insertAreawater(Areawater areawater);

    /**
     * 修改areawater
     * 
     * @param areawater areawater
     * @return 结果
     */
    public int updateAreawater(Areawater areawater);

    /**
     * 批量删除areawater
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAreawaterByIds(String ids);

    /**
     * 删除areawater信息
     * 
     * @param id areawaterID
     * @return 结果
     */
    public int deleteAreawaterById(Long id);
}
