package com.numberone.project.system.reduces.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.reduces.mapper.ReducesMapper;
import com.numberone.project.system.reduces.domain.Reduces;
import com.numberone.project.system.reduces.service.IReducesService;
import com.numberone.common.utils.text.Convert;

/**
 * 减少排碳Service业务层处理
 * 
 * @author sqalong
 * @date 2021-01-13
 */
@Service
public class ReducesServiceImpl implements IReducesService 
{
    @Autowired
    private ReducesMapper reducesMapper;

    /**
     * 查询减少排碳
     * 
     * @param id 减少排碳ID
     * @return 减少排碳
     */
    @Override
    public Reduces selectReducesById(Long id)
    {
        return reducesMapper.selectReducesById(id);
    }

    /**
     * 查询减少排碳列表
     * 
     * @param reduces 减少排碳
     * @return 减少排碳
     */
    @Override
    public List<Reduces> selectReducesList(Reduces reduces)
    {
        return reducesMapper.selectReducesList(reduces);
    }

    /**
     * 新增减少排碳
     * 
     * @param reduces 减少排碳
     * @return 结果
     */
    @Override
    public int insertReduces(Reduces reduces)
    {
        return reducesMapper.insertReduces(reduces);
    }

    /**
     * 修改减少排碳
     * 
     * @param reduces 减少排碳
     * @return 结果
     */
    @Override
    public int updateReduces(Reduces reduces)
    {
        return reducesMapper.updateReduces(reduces);
    }

    /**
     * 删除减少排碳对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteReducesByIds(String ids)
    {
        return reducesMapper.deleteReducesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除减少排碳信息
     * 
     * @param id 减少排碳ID
     * @return 结果
     */
    @Override
    public int deleteReducesById(Long id)
    {
        return reducesMapper.deleteReducesById(id);
    }
}
