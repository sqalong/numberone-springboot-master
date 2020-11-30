package com.numberone.project.system.tree_simulate.simulate.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.numberone.framework.web.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.tree_simulate.simulate.mapper.TreeSimulateMapper;
import com.numberone.project.system.tree_simulate.simulate.domain.TreeSimulate;
import com.numberone.project.system.tree_simulate.simulate.service.ITreeSimulateService;
import com.numberone.common.utils.text.Convert;

/**
 * 电表管理Service业务层处理
 * 
 * @author sqalong
 * @date 2020-11-23
 */
@Service
public class TreeSimulateServiceImpl implements ITreeSimulateService 
{
    @Autowired
    private TreeSimulateMapper treeSimulateMapper;

    /**
     * 查询电表管理
     * 
     * @param tid 电表管理ID
     * @return 电表管理
     */
    @Override
    public TreeSimulate selectTreeSimulateById(Long tid)
    {
        return treeSimulateMapper.selectTreeSimulateById(tid);
    }

    /**
     * 查询电表管理列表
     * 
     * @param treeSimulate 电表管理
     * @return 电表管理
     */
    @Override
    public List<TreeSimulate> selectTreeSimulateList(TreeSimulate treeSimulate)
    {
        return treeSimulateMapper.selectTreeSimulateList(treeSimulate);
    }

    /**
     * 新增电表管理
     * 
     * @param treeSimulate 电表管理
     * @return 结果
     */
    @Override
    public int insertTreeSimulate(TreeSimulate treeSimulate)
    {
        return treeSimulateMapper.insertTreeSimulate(treeSimulate);
    }

    /**
     * 修改电表管理
     * 
     * @param treeSimulate 电表管理
     * @return 结果
     */
    @Override
    public int updateTreeSimulate(TreeSimulate treeSimulate)
    {
        return treeSimulateMapper.updateTreeSimulate(treeSimulate);
    }

    /**
     * 删除电表管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTreeSimulateByIds(String ids)
    {
        return treeSimulateMapper.deleteTreeSimulateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除电表管理信息
     * 
     * @param tid 电表管理ID
     * @return 结果
     */
    @Override
    public int deleteTreeSimulateById(Long tid)
    {
        return treeSimulateMapper.deleteTreeSimulateById(tid);
    }

    /**
     * 查询电表管理树列表
     * 
     * @return 所有电表管理信息
     */
    @Override
    public List<Ztree> selectTreeSimulateTree()
    {
        List<TreeSimulate> treeSimulateList = treeSimulateMapper.selectTreeSimulateList(new TreeSimulate());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (TreeSimulate treeSimulate : treeSimulateList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(treeSimulate.getTreeId());
            ztree.setpId(treeSimulate.getTreeParentId());
            ztree.setName(treeSimulate.getTreeName());
            ztree.setTitle(treeSimulate.getTreeName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
