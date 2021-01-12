package com.numberone.project.system.areawater.service;

import java.util.List;
import com.numberone.project.system.areawater.domain.Areawater;
import com.numberone.framework.web.domain.Ztree;

/**
 * 子地区水表数据Service接口
 * 
 * @author sqalong
 * @date 2021-01-12
 */
public interface IAreawaterService 
{
    /**
     * 查询子地区水表数据
     * 
     * @param id 子地区水表数据ID
     * @return 子地区水表数据
     */
    public Areawater selectAreawaterById(Long id);

    /**
     * 查询子地区水表数据列表
     * 
     * @param areawater 子地区水表数据
     * @return 子地区水表数据集合
     */
    public List<Areawater> selectAreawaterList(Areawater areawater);

    /**
     * 新增子地区水表数据
     * 
     * @param areawater 子地区水表数据
     * @return 结果
     */
    public int insertAreawater(Areawater areawater);

    /**
     * 修改子地区水表数据
     * 
     * @param areawater 子地区水表数据
     * @return 结果
     */
    public int updateAreawater(Areawater areawater);

    /**
     * 批量删除子地区水表数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAreawaterByIds(String ids);

    /**
     * 删除子地区水表数据信息
     * 
     * @param id 子地区水表数据ID
     * @return 结果
     */
    public int deleteAreawaterById(Long id);

    /**
     * 查询子地区水表数据树列表
     * 
     * @return 所有子地区水表数据信息
     */
    public List<Ztree> selectAreawaterTree();
}
