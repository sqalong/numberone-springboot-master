package com.numberone.project.system.real.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 实时遥测曲线对象 real
 * 
 * @author numberone
 * @date 2020-10-26
 */
public class Real extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 分组名称 */
    @Excel(name = "分组名称")
    private String groupsname;

    /** 测量点名称 */
    @Excel(name = "测量点名称")
    private String measurename;

    /** 信号名称 */
    @Excel(name = "信号名称")
    private String signname;

    /** 同步时间 */
    @Excel(name = "同步时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date meanehiletime;

    /** 内部限值 */
    @Excel(name = "内部限值")
    private String insidevalue;

    /** 法规限值 */
    @Excel(name = "法规限值")
    private String regulationvalue;

    /** 示值 */
    @Excel(name = "示值")
    private String indication;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGroupsname(String groupsname) 
    {
        this.groupsname = groupsname;
    }

    public String getGroupsname() 
    {
        return groupsname;
    }
    public void setMeasurename(String measurename) 
    {
        this.measurename = measurename;
    }

    public String getMeasurename() 
    {
        return measurename;
    }
    public void setSignname(String signname) 
    {
        this.signname = signname;
    }

    public String getSignname() 
    {
        return signname;
    }
    public void setMeanehiletime(Date meanehiletime) 
    {
        this.meanehiletime = meanehiletime;
    }

    public Date getMeanehiletime() 
    {
        return meanehiletime;
    }
    public void setInsidevalue(String insidevalue) 
    {
        this.insidevalue = insidevalue;
    }

    public String getInsidevalue() 
    {
        return insidevalue;
    }
    public void setRegulationvalue(String regulationvalue) 
    {
        this.regulationvalue = regulationvalue;
    }

    public String getRegulationvalue() 
    {
        return regulationvalue;
    }
    public void setIndication(String indication) 
    {
        this.indication = indication;
    }

    public String getIndication() 
    {
        return indication;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("groupsname", getGroupsname())
            .append("measurename", getMeasurename())
            .append("signname", getSignname())
            .append("meanehiletime", getMeanehiletime())
            .append("insidevalue", getInsidevalue())
            .append("regulationvalue", getRegulationvalue())
            .append("indication", getIndication())
            .append("unit", getUnit())
            .toString();
    }
}
