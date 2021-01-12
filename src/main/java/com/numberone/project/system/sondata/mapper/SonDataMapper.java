package com.numberone.project.system.sondata.mapper;

import java.util.List;
import com.numberone.project.system.sondata.domain.SonData;

/**
 * 子地区基本信息Mapper接口
 * 
 * @author sqalong
 * @date 2021-01-12
 */
public interface SonDataMapper 
{
    /**
     * 查询子地区基本信息
     * 
     * @param pname 子地区基本信息ID
     * @return 子地区基本信息
     */
    public SonData selectSonDataById(String pname);

    /**
     * 查询子地区基本信息列表
     * 
     * @param sonData 子地区基本信息
     * @return 子地区基本信息集合
     */
    public List<SonData> selectSonDataList(SonData sonData);

    /**
     * 新增子地区基本信息
     * 
     * @param sonData 子地区基本信息
     * @return 结果
     */
    public int insertSonData(SonData sonData);

    /**
     * 修改子地区基本信息
     * 
     * @param sonData 子地区基本信息
     * @return 结果
     */
    public int updateSonData(SonData sonData);

    /**
     * 删除子地区基本信息
     * 
     * @param pname 子地区基本信息ID
     * @return 结果
     */
    public int deleteSonDataById(String pname);

    /**
     * 批量删除子地区基本信息
     * 
     * @param pnames 需要删除的数据ID
     * @return 结果
     */
    public int deleteSonDataByIds(String[] pnames);

    SonData selectSonDataBypname(String name);
}
