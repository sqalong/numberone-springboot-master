package com.numberone.project.system.electricmanager.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * electricmanager对象 electric
 * 
 * @author sqalong
 * @date 2020-12-21
 */
public class ElectricManager extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 场院名称 */
    @Excel(name = "场院名称")
    private String name;

    /** 数值 */
    @Excel(name = "数值")
    private String value;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("value", getValue())
            .toString();
    }
}
