package com.numberone.project.system.reduces.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 减少排碳对象 reduce
 * 
 * @author sqalong
 * @date 2021-01-13
 */
public class Reduces extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 地区名称 */
    @Excel(name = "地区名称")
    private String name;

    /** 减少煤 */
    @Excel(name = "减少煤")
    private Double reduceCoal;

    /** 减少Co2 */
    @Excel(name = "减少Co2")
    private Double reduceCo2;

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
    public void setReduceCoal(Double reduceCoal) 
    {
        this.reduceCoal = reduceCoal;
    }

    public Double getReduceCoal() 
    {
        return reduceCoal;
    }
    public void setReduceCo2(Double reduceCo2) 
    {
        this.reduceCo2 = reduceCo2;
    }

    public Double getReduceCo2() 
    {
        return reduceCo2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("reduceCoal", getReduceCoal())
            .append("reduceCo2", getReduceCo2())
            .toString();
    }
}
