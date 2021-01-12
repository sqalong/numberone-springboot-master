package com.numberone.project.system.areawater.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.numberone.framework.web.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.areawater.mapper.AreawaterMapper;
import com.numberone.project.system.areawater.domain.Areawater;
import com.numberone.project.system.areawater.service.IAreawaterService;
import com.numberone.common.utils.text.Convert;

/**
 * 子地区水表数据Service业务层处理
 * 
 * @author sqalong
 * @date 2021-01-12
 */
@Service
public class AreawaterServiceImpl implements IAreawaterService 
{
    @Autowired
    private AreawaterMapper areawaterMapper;

    /**
     * 查询子地区水表数据
     * 
     * @param id 子地区水表数据ID
     * @return 子地区水表数据
     */
    @Override
    public Areawater selectAreawaterById(Long id)
    {
        return areawaterMapper.selectAreawaterById(id);
    }

    /**
     * 查询子地区水表数据列表
     * 
     * @param areawater 子地区水表数据
     * @return 子地区水表数据
     */
    @Override
    public List<Areawater> selectAreawaterList(Areawater areawater)
    {
        return areawaterMapper.selectAreawaterList(areawater);
    }

    /**
     * 新增子地区水表数据
     * 
     * @param areawater 子地区水表数据
     * @return 结果
     */
    @Override
    public int insertAreawater(Areawater areawater)
    {
        return areawaterMapper.insertAreawater(areawater);
    }

    /**
     * 修改子地区水表数据
     * 
     * @param areawater 子地区水表数据
     * @return 结果
     */
    @Override
    public int updateAreawater(Areawater areawater)
    {
        return areawaterMapper.updateAreawater(areawater);
    }

    /**
     * 删除子地区水表数据对象
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
     * 删除子地区水表数据信息
     * 
     * @param id 子地区水表数据ID
     * @return 结果
     */
    @Override
    public int deleteAreawaterById(Long id)
    {
        return areawaterMapper.deleteAreawaterById(id);
    }

    /**
     * 查询子地区水表数据树列表
     * 
     * @return 所有子地区水表数据信息
     */
    @Override
    public List<Ztree> selectAreawaterTree()
    {
        List<Areawater> areawaterList = areawaterMapper.selectAreawaterList(new Areawater());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (Areawater areawater : areawaterList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(areawater.getId());
            ztree.setpId(areawater.getPid());
            ztree.setName(areawater.getLargeareaname());
            ztree.setTitle(areawater.getLargeareaname());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
