package com.numberone.project.system.zamanager.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.zamanager.mapper.ZaManagerMapper;
import com.numberone.project.system.zamanager.domain.ZaManager;
import com.numberone.project.system.zamanager.service.IZaManagerService;
import com.numberone.common.utils.text.Convert;

/**
 * 大屏展示数据Service业务层处理
 * 
 * @author sqalong
 * @date 2020-12-16
 */
@Service
public class ZaManagerServiceImpl implements IZaManagerService 
{
    @Autowired
    private ZaManagerMapper zaManagerMapper;

    /**
     * 查询大屏展示数据
     * 
     * @param id 大屏展示数据ID
     * @return 大屏展示数据
     */
    @Override
    public ZaManager selectZaManagerById(Long id)
    {
        return zaManagerMapper.selectZaManagerById(id);
    }

    /**
     * 查询大屏展示数据列表
     * 
     * @param zaManager 大屏展示数据
     * @return 大屏展示数据
     */
    @Override
    public List<ZaManager> selectZaManagerList(ZaManager zaManager)
    {
        return zaManagerMapper.selectZaManagerList(zaManager);
    }

    /**
     * 新增大屏展示数据
     * 
     * @param zaManager 大屏展示数据
     * @return 结果
     */
    @Override
    public int insertZaManager(ZaManager zaManager)
    {
        return zaManagerMapper.insertZaManager(zaManager);
    }

    /**
     * 修改大屏展示数据
     * 
     * @param zaManager 大屏展示数据
     * @return 结果
     */
    @Override
    public int updateZaManager(ZaManager zaManager)
    {
        return zaManagerMapper.updateZaManager(zaManager);
    }

    /**
     * 删除大屏展示数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZaManagerByIds(String ids)
    {
        return zaManagerMapper.deleteZaManagerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除大屏展示数据信息
     * 
     * @param id 大屏展示数据ID
     * @return 结果
     */
    @Override
    public int deleteZaManagerById(Long id)
    {
        return zaManagerMapper.deleteZaManagerById(id);
    }
}
