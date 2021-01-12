package com.numberone.project.system.areagas.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.numberone.framework.web.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.areagas.mapper.AreagasMapper;
import com.numberone.project.system.areagas.domain.Areagas;
import com.numberone.project.system.areagas.service.IAreagasService;
import com.numberone.common.utils.text.Convert;

/**
 * 子地区气表数据Service业务层处理
 * 
 * @author sqalong
 * @date 2021-01-12
 */
@Service
public class AreagasServiceImpl implements IAreagasService 
{
    @Autowired
    private AreagasMapper areagasMapper;

    /**
     * 查询子地区气表数据
     * 
     * @param id 子地区气表数据ID
     * @return 子地区气表数据
     */
    @Override
    public Areagas selectAreagasById(Long id)
    {
        return areagasMapper.selectAreagasById(id);
    }

    /**
     * 查询子地区气表数据列表
     * 
     * @param areagas 子地区气表数据
     * @return 子地区气表数据
     */
    @Override
    public List<Areagas> selectAreagasList(Areagas areagas)
    {
        return areagasMapper.selectAreagasList(areagas);
    }

    /**
     * 新增子地区气表数据
     * 
     * @param areagas 子地区气表数据
     * @return 结果
     */
    @Override
    public int insertAreagas(Areagas areagas)
    {
        return areagasMapper.insertAreagas(areagas);
    }

    /**
     * 修改子地区气表数据
     * 
     * @param areagas 子地区气表数据
     * @return 结果
     */
    @Override
    public int updateAreagas(Areagas areagas)
    {
        return areagasMapper.updateAreagas(areagas);
    }

    /**
     * 删除子地区气表数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAreagasByIds(String ids)
    {
        return areagasMapper.deleteAreagasByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除子地区气表数据信息
     * 
     * @param id 子地区气表数据ID
     * @return 结果
     */
    @Override
    public int deleteAreagasById(Long id)
    {
        return areagasMapper.deleteAreagasById(id);
    }

    /**
     * 查询子地区气表数据树列表
     * 
     * @return 所有子地区气表数据信息
     */
    @Override
    public List<Ztree> selectAreagasTree()
    {
        List<Areagas> areagasList = areagasMapper.selectAreagasList(new Areagas());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (Areagas areagas : areagasList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(areagas.getId());
            ztree.setpId(areagas.getPid());
            ztree.setName(areagas.getLargeareaname());
            ztree.setTitle(areagas.getLargeareaname());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
