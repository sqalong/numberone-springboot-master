package com.numberone.project.system.tree_simulate.simulate.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.TreeEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 电表管理对象 tree_simulate
 * 
 * @author sqalong
 * @date 2020-11-23
 */
public class TreeSimulate extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 级别目录 */
    private Long tid;

    /** 树id */
    @Excel(name = "树id")
    private Long treeId;

    /** 父部门id */
    @Excel(name = "父部门id")
    private Long treeParentId;

    /** 目录名称 */
    @Excel(name = "目录名称")
    private String treeName;

    public void setTid(Long tid) 
    {
        this.tid = tid;
    }

    public Long getTid() 
    {
        return tid;
    }
    public void setTreeId(Long treeId) 
    {
        this.treeId = treeId;
    }

    public Long getTreeId() 
    {
        return treeId;
    }
    public void setTreeParentId(Long treeParentId) 
    {
        this.treeParentId = treeParentId;
    }

    public Long getTreeParentId() 
    {
        return treeParentId;
    }
    public void setTreeName(String treeName) 
    {
        this.treeName = treeName;
    }

    public String getTreeName() 
    {
        return treeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("tid", getTid())
            .append("treeId", getTreeId())
            .append("treeParentId", getTreeParentId())
            .append("treeName", getTreeName())
            .toString();
    }
}
