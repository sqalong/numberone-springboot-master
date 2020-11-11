package com.numberone.project.system.tactics.service;

import java.util.List;
import com.numberone.project.system.tactics.domain.Tactics;

/**
 * tacticsService接口
 * 
 * @author numberone
 * @date 2020-11-11
 */
public interface ITacticsService 
{
    /**
     * 查询tactics
     * 
     * @param id tacticsID
     * @return tactics
     */
    public Tactics selectTacticsById(Long id);

    /**
     * 查询tactics列表
     * 
     * @param tactics tactics
     * @return tactics集合
     */
    public List<Tactics> selectTacticsList(Tactics tactics);

    /**
     * 新增tactics
     * 
     * @param tactics tactics
     * @return 结果
     */
    public int insertTactics(Tactics tactics);

    /**
     * 修改tactics
     * 
     * @param tactics tactics
     * @return 结果
     */
    public int updateTactics(Tactics tactics);

    /**
     * 批量删除tactics
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTacticsByIds(String ids);

    /**
     * 删除tactics信息
     * 
     * @param id tacticsID
     * @return 结果
     */
    public int deleteTacticsById(Long id);
}
