package com.numberone.project.system.areawater.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.TreeEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 子地区水表数据对象 areawater
 * 
 * @author sqalong
 * @date 2021-01-12
 */
public class Areawater extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 子地区名称 */
    @Excel(name = "子地区名称")
    private String smallareaname;

    /** 场院名称 */
    @Excel(name = "场院名称")
    private String largeareaname;

    /** 数值 */
    @Excel(name = "数值")
    private Double value;

    /** 父ID */
    private Long pid;

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
    public void setPid(Long pid) 
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("smallareaname", getSmallareaname())
            .append("largeareaname", getLargeareaname())
            .append("value", getValue())
            .append("pid", getPid())
            .toString();
    }
}
