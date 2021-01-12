package com.numberone.project.system.sondata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.sondata.mapper.SonDataMapper;
import com.numberone.project.system.sondata.domain.SonData;
import com.numberone.project.system.sondata.service.ISonDataService;
import com.numberone.common.utils.text.Convert;

/**
 * 子地区基本信息Service业务层处理
 * 
 * @author sqalong
 * @date 2021-01-12
 */
@Service
public class SonDataServiceImpl implements ISonDataService 
{
    @Autowired
    private SonDataMapper sonDataMapper;

    /**
     * 查询子地区基本信息
     * 
     * @param pname 子地区基本信息ID
     * @return 子地区基本信息
     */
    @Override
    public SonData selectSonDataById(String pname)
    {
        return sonDataMapper.selectSonDataById(pname);
    }

    /**
     * 查询子地区基本信息列表
     * 
     * @param sonData 子地区基本信息
     * @return 子地区基本信息
     */
    @Override
    public List<SonData> selectSonDataList(SonData sonData)
    {
        return sonDataMapper.selectSonDataList(sonData);
    }

    /**
     * 新增子地区基本信息
     * 
     * @param sonData 子地区基本信息
     * @return 结果
     */
    @Override
    public int insertSonData(SonData sonData)
    {
        return sonDataMapper.insertSonData(sonData);
    }

    /**
     * 修改子地区基本信息
     * 
     * @param sonData 子地区基本信息
     * @return 结果
     */
    @Override
    public int updateSonData(SonData sonData)
    {
        return sonDataMapper.updateSonData(sonData);
    }

    /**
     * 删除子地区基本信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSonDataByIds(String ids)
    {
        return sonDataMapper.deleteSonDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除子地区基本信息信息
     * 
     * @param pname 子地区基本信息ID
     * @return 结果
     */
    @Override
    public int deleteSonDataById(String pname)
    {
        return sonDataMapper.deleteSonDataById(pname);
    }

    @Override
    public SonData selectSonDataBypname(String name) {
        return sonDataMapper.selectSonDataBypname(name);
    }


}
