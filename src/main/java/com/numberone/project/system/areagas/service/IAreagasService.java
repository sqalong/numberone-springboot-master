package com.numberone.project.system.areagas.service;

import java.util.List;
import com.numberone.project.system.areagas.domain.Areagas;
import com.numberone.framework.web.domain.Ztree;

/**
 * 子地区气表数据Service接口
 * 
 * @author sqalong
 * @date 2021-01-12
 */
public interface IAreagasService 
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
     * 批量删除子地区气表数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAreagasByIds(String ids);

    /**
     * 删除子地区气表数据信息
     * 
     * @param id 子地区气表数据ID
     * @return 结果
     */
    public int deleteAreagasById(Long id);

    /**
     * 查询子地区气表数据树列表
     * 
     * @return 所有子地区气表数据信息
     */
    public List<Ztree> selectAreagasTree();
}
