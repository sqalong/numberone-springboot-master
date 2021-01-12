package com.numberone.project.system.areawater.mapper;

import java.util.List;
import com.numberone.project.system.areawater.domain.Areawater;

/**
 * 子地区水表数据Mapper接口
 * 
 * @author sqalong
 * @date 2021-01-12
 */
public interface AreawaterMapper 
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
     * 删除子地区水表数据
     * 
     * @param id 子地区水表数据ID
     * @return 结果
     */
    public int deleteAreawaterById(Long id);

    /**
     * 批量删除子地区水表数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAreawaterByIds(String[] ids);
}
