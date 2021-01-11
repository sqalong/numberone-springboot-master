package com.numberone.project.system.areaelectric.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.numberone.framework.web.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.areaelectric.mapper.AreaelectricMapper;
import com.numberone.project.system.areaelectric.domain.Areaelectric;
import com.numberone.project.system.areaelectric.service.IAreaelectricService;
import com.numberone.common.utils.text.Convert;

/**
 * areaelectricService业务层处理
 * 
 * @author sqalong
 * @date 2021-01-11
 */
@Service
public class AreaelectricServiceImpl implements IAreaelectricService 
{
    @Autowired
    private AreaelectricMapper areaelectricMapper;

    /**
     * 查询areaelectric
     * 
     * @param id areaelectricID
     * @return areaelectric
     */
    @Override
    public Areaelectric selectAreaelectricById(Long id)
    {
        return areaelectricMapper.selectAreaelectricById(id);
    }

    /**
     * 查询areaelectric列表
     * 
     * @param areaelectric areaelectric
     * @return areaelectric
     */
    @Override
    public List<Areaelectric> selectAreaelectricList(Areaelectric areaelectric)
    {
        return areaelectricMapper.selectAreaelectricList(areaelectric);
    }

    /**
     * 新增areaelectric
     * 
     * @param areaelectric areaelectric
     * @return 结果
     */
    @Override
    public int insertAreaelectric(Areaelectric areaelectric)
    {
        return areaelectricMapper.insertAreaelectric(areaelectric);
    }

    /**
     * 修改areaelectric
     * 
     * @param areaelectric areaelectric
     * @return 结果
     */
    @Override
    public int updateAreaelectric(Areaelectric areaelectric)
    {
        return areaelectricMapper.updateAreaelectric(areaelectric);
    }

    /**
     * 删除areaelectric对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAreaelectricByIds(String ids)
    {
        return areaelectricMapper.deleteAreaelectricByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除areaelectric信息
     * 
     * @param id areaelectricID
     * @return 结果
     */
    @Override
    public int deleteAreaelectricById(Long id)
    {
        return areaelectricMapper.deleteAreaelectricById(id);
    }

    /**
     * 查询areaelectric树列表
     * 
     * @return 所有areaelectric信息
     */
    @Override
    public List<Ztree> selectAreaelectricTree()
    {
        List<Areaelectric> areaelectricList = areaelectricMapper.selectAreaelectricList(new Areaelectric());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (Areaelectric areaelectric : areaelectricList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(areaelectric.getId());
            ztree.setpId(areaelectric.getPid());
            ztree.setName(areaelectric.getLargeareaname());
            ztree.setTitle(areaelectric.getLargeareaname());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
