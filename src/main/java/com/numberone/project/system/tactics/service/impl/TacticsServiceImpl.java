package com.numberone.project.system.tactics.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.tactics.mapper.TacticsMapper;
import com.numberone.project.system.tactics.domain.Tactics;
import com.numberone.project.system.tactics.service.ITacticsService;
import com.numberone.common.utils.text.Convert;

/**
 * tacticsService业务层处理
 * 
 * @author numberone
 * @date 2020-11-11
 */
@Service
public class TacticsServiceImpl implements ITacticsService 
{
    @Autowired
    private TacticsMapper tacticsMapper;

    /**
     * 查询tactics
     * 
     * @param id tacticsID
     * @return tactics
     */
    @Override
    public Tactics selectTacticsById(Long id)
    {
        return tacticsMapper.selectTacticsById(id);
    }

    /**
     * 查询tactics列表
     * 
     * @param tactics tactics
     * @return tactics
     */
    @Override
    public List<Tactics> selectTacticsList(Tactics tactics)
    {
        return tacticsMapper.selectTacticsList(tactics);
    }

    /**
     * 新增tactics
     * 
     * @param tactics tactics
     * @return 结果
     */
    @Override
    public int insertTactics(Tactics tactics)
    {
        return tacticsMapper.insertTactics(tactics);
    }

    /**
     * 修改tactics
     * 
     * @param tactics tactics
     * @return 结果
     */
    @Override
    public int updateTactics(Tactics tactics)
    {
        return tacticsMapper.updateTactics(tactics);
    }

    /**
     * 删除tactics对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTacticsByIds(String ids)
    {
        return tacticsMapper.deleteTacticsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除tactics信息
     * 
     * @param id tacticsID
     * @return 结果
     */
    @Override
    public int deleteTacticsById(Long id)
    {
        return tacticsMapper.deleteTacticsById(id);
    }
}
