package com.numberone.project.system.areagas.mapper;

import java.util.List;
import com.numberone.project.system.areagas.domain.Areagas;

/**
 * 子地区气表数据Mapper接口
 * 
 * @author sqalong
 * @date 2021-01-12
 */
public interface AreagasMapper 
{
    /**
     * 查询子地区气表数据
     * 
     * @param id 子地区气表数据ID
     * @return 子地区气表数据
     */
    public Areagas selectAreagasById(Long id);

    /**
     * 查询子地区气表数据列表
     * 
     * @param areagas 子地区气表数据
     * @return 子地区气表数据集合
     */
    public List<Areagas> selectAreagasList(Areagas areagas);

    /**
     * 新增子地区气表数据
     * 
     * @param areagas 子地区气表数据
     * @return 结果
     */
    public int insertAreagas(Areagas areagas);

    /**
     * 修改子地区气表数据
     * 
     * @param areagas 子地区气表数据
     * @return 结果
     */
    public int updateAreagas(Areagas areagas);

    /**
     * 删除子地区气表数据
     * 
     * @param id 子地区气表数据ID
     * @return 结果
     */
    public int deleteAreagasById(Long id);

    /**
     * 批量删除子地区气表数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAreagasByIds(String[] ids);
}
