package com.numberone.project.system.tree_simulate.simulate.mapper;

import java.util.List;
import com.numberone.project.system.tree_simulate.simulate.domain.TreeSimulate;

/**
 * 电表管理Mapper接口
 * 
 * @author sqalong
 * @date 2020-11-23
 */
public interface TreeSimulateMapper 
{
    /**
     * 查询电表管理
     * 
     * @param tid 电表管理ID
     * @return 电表管理
     */
    public TreeSimulate selectTreeSimulateById(Long tid);

    /**
     * 查询电表管理列表
     * 
     * @param treeSimulate 电表管理
     * @return 电表管理集合
     */
    public List<TreeSimulate> selectTreeSimulateList(TreeSimulate treeSimulate);

    /**
     * 新增电表管理
     * 
     * @param treeSimulate 电表管理
     * @return 结果
     */
    public int insertTreeSimulate(TreeSimulate treeSimulate);

    /**
     * 修改电表管理
     * 
     * @param treeSimulate 电表管理
     * @return 结果
     */
    public int updateTreeSimulate(TreeSimulate treeSimulate);

    /**
     * 删除电表管理
     * 
     * @param tid 电表管理ID
     * @return 结果
     */
    public int deleteTreeSimulateById(Long tid);

    /**
     * 批量删除电表管理
     * 
     * @param tids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTreeSimulateByIds(String[] tids);
}
