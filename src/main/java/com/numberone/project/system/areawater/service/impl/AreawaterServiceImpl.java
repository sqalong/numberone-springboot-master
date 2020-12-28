package com.numberone.project.system.areawater.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.areawater.mapper.AreawaterMapper;
import com.numberone.project.system.areawater.domain.Areawater;
import com.numberone.project.system.areawater.service.IAreawaterService;
import com.numberone.common.utils.text.Convert;

/**
 * areawaterService业务层处理
 * 
 * @author sqalong
 * @date 2020-12-28
 */
@Service
public class AreawaterServiceImpl implements IAreawaterService 
{
    @Autowired
    private AreawaterMapper areawaterMapper;

    /**
     * 查询areawater
     * 
     * @param id areawaterID
     * @return areawater
     */
    @Override
    public Areawater selectAreawaterById(Long id)
    {
        return areawaterMapper.selectAreawaterById(id);
    }

    /**
     * 查询areawater列表
     * 
     * @param areawater areawater
     * @return areawater
     */
    @Override
    public List<Areawater> selectAreawaterList(Areawater areawater)
    {
        return areawaterMapper.selectAreawaterList(areawater);
    }

    /**
     * 新增areawater
     * 
     * @param areawater areawater
     * @return 结果
     */
    @Override
    public int insertAreawater(Areawater areawater)
    {
        return areawaterMapper.insertAreawater(areawater);
    }

    /**
     * 修改areawater
     * 
     * @param areawater areawater
     * @return 结果
     */
    @Override
    public int updateAreawater(Areawater areawater)
    {
        return areawaterMapper.updateAreawater(areawater);
    }

    /**
     * 删除areawater对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAreawaterByIds(String ids)
    {
        return areawaterMapper.deleteAreawaterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除areawater信息
     * 
     * @param id areawaterID
     * @return 结果
     */
    @Override
    public int deleteAreawaterById(Long id)
    {
        return areawaterMapper.deleteAreawaterById(id);
    }
}
