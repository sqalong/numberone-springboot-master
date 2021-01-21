package com.numberone.project.system.electricbight.mapper;

import java.util.List;
import com.numberone.project.system.electricbight.domain.SonEnergyElectric;

/**
 * 子地区用电曲线图数据Mapper接口
 * 
 * @author sqalong
 * @date 2021-01-13
 */
public interface SonEnergyElectricMapper 
{
    /**
     * 查询子地区用电曲线图数据
     * 
     * @param pname 子地区用电曲线图数据ID
     * @return 子地区用电曲线图数据
     */
    public SonEnergyElectric selectSonEnergyElectricById(String pname);

    /**
     * 查询子地区用电曲线图数据列表
     * 
     * @param sonEnergyElectric 子地区用电曲线图数据
     * @return 子地区用电曲线图数据集合
     */
    public List<SonEnergyElectric> selectSonEnergyElectricList(SonEnergyElectric sonEnergyElectric);

    /**
     * 新增子地区用电曲线图数据
     * 
     * @param sonEnergyElectric 子地区用电曲线图数据
     * @return 结果
     */
    public int insertSonEnergyElectric(SonEnergyElectric sonEnergyElectric);

    /**
     * 修改子地区用电曲线图数据
     * 
     * @param sonEnergyElectric 子地区用电曲线图数据
     * @return 结果
     */
    public int updateSonEnergyElectric(SonEnergyElectric sonEnergyElectric);

    /**
     * 删除子地区用电曲线图数据
     * 
     * @param pname 子地区用电曲线图数据ID
     * @return 结果
     */
    public int deleteSonEnergyElectricById(String pname);

    /**
     * 批量删除子地区用电曲线图数据
     * 
     * @param pnames 需要删除的数据ID
     * @return 结果
     */
    public int deleteSonEnergyElectricByIds(String[] pnames);
}
