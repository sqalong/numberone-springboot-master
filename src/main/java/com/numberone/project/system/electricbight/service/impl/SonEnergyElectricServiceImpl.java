package com.numberone.project.system.electricbight.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.electricbight.mapper.SonEnergyElectricMapper;
import com.numberone.project.system.electricbight.domain.SonEnergyElectric;
import com.numberone.project.system.electricbight.service.ISonEnergyElectricService;
import com.numberone.common.utils.text.Convert;

/**
 * 子地区用电曲线图数据Service业务层处理
 * 
 * @author sqalong
 * @date 2021-01-13
 */
@Service
public class SonEnergyElectricServiceImpl implements ISonEnergyElectricService 
{
    @Autowired
    private SonEnergyElectricMapper sonEnergyElectricMapper;

    /**
     * 查询子地区用电曲线图数据
     * 
     * @param pname 子地区用电曲线图数据ID
     * @return 子地区用电曲线图数据
     */
    @Override
    public SonEnergyElectric selectSonEnergyElectricById(String pname)
    {
        return sonEnergyElectricMapper.selectSonEnergyElectricById(pname);
    }

    /**
     * 查询子地区用电曲线图数据列表
     * 
     * @param sonEnergyElectric 子地区用电曲线图数据
     * @return 子地区用电曲线图数据
     */
    @Override
    public List<SonEnergyElectric> selectSonEnergyElectricList(SonEnergyElectric sonEnergyElectric)
    {
        return sonEnergyElectricMapper.selectSonEnergyElectricList(sonEnergyElectric);
    }

    /**
     * 新增子地区用电曲线图数据
     * 
     * @param sonEnergyElectric 子地区用电曲线图数据
     * @return 结果
     */
    @Override
    public int insertSonEnergyElectric(SonEnergyElectric sonEnergyElectric)
    {
        return sonEnergyElectricMapper.insertSonEnergyElectric(sonEnergyElectric);
    }

    /**
     * 修改子地区用电曲线图数据
     * 
     * @param sonEnergyElectric 子地区用电曲线图数据
     * @return 结果
     */
    @Override
    public int updateSonEnergyElectric(SonEnergyElectric sonEnergyElectric)
    {
        return sonEnergyElectricMapper.updateSonEnergyElectric(sonEnergyElectric);
    }

    /**
     * 删除子地区用电曲线图数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSonEnergyElectricByIds(String ids)
    {
        return sonEnergyElectricMapper.deleteSonEnergyElectricByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除子地区用电曲线图数据信息
     * 
     * @param pname 子地区用电曲线图数据ID
     * @return 结果
     */
    @Override
    public int deleteSonEnergyElectricById(String pname)
    {
        return sonEnergyElectricMapper.deleteSonEnergyElectricById(pname);
    }
}
