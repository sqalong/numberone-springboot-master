package com.numberone.project.system.areawater.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * areawater对象 areawater
 * 
 * @author sqalong
 * @date 2020-12-28
 */
public class Areawater extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 子地区单位名称 */
    @Excel(name = "子地区单位名称")
    private String smallareaname;

    /** 场院名称名称 */
    @Excel(name = "场院名称名称")
    private String largeareaname;

    /** 数值 */
    @Excel(name = "数值")
    private Double value;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSmallareaname(String smallareaname) 
    {
        this.smallareaname = smallareaname;
    }

    public String getSmallareaname() 
    {
        return smallareaname;
    }
    public void setLargeareaname(String largeareaname) 
    {
        this.largeareaname = largeareaname;
    }

    public String getLargeareaname() 
    {
        return largeareaname;
    }
    public void setValue(Double value) 
    {
        this.value = value;
    }

    public Double getValue() 
    {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("smallareaname", getSmallareaname())
            .append("largeareaname", getLargeareaname())
            .append("value", getValue())
            .toString();
    }
}
