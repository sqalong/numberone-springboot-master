package com.numberone.project.system.mrar.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 表具抄表录入对象 mrar
 * 
 * @author numberone
 * @date 2020-11-12
 */
public class Mrar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Integer id;

    /** 测点编码 */
    @Excel(name = "测点编码")
    private String coding;

    /** 测点名称 */
    @Excel(name = "测点名称")
    private String name;

    /** 表计编号 */
    @Excel(name = "表计编号")
    private String number;

    /** 抄表周期 */
    @Excel(name = "抄表周期")
    private String period;

    /** 信号名称 */
    @Excel(name = "信号名称")
    private String badname;

    /** 时间 */
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String time;

    /** 上一次读数 */
    @Excel(name = "上一次读数")
    private String lastreading;

    /** 读数 */
    @Excel(name = "读数")
    private String reading;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String unit;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String state;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setCoding(String coding) 
    {
        this.coding = coding;
    }

    public String getCoding() 
    {
        return coding;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getNumber() 
    {
        return number;
    }
    public void setPeriod(String period) 
    {
        this.period = period;
    }

    public String getPeriod() 
    {
        return period;
    }
    public void setBadname(String badname) 
    {
        this.badname = badname;
    }

    public String getBadname() 
    {
        return badname;
    }
    public void setTime(String time)
    {
        this.time = time;
    }

    public String getTime()
    {
        return time;
    }
    public void setLastreading(String lastreading) 
    {
        this.lastreading = lastreading;
    }

    public String getLastreading() 
    {
        return lastreading;
    }
    public void setReading(String reading) 
    {
        this.reading = reading;
    }

    public String getReading() 
    {
        return reading;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("coding", getCoding())
            .append("name", getName())
            .append("number", getNumber())
            .append("period", getPeriod())
            .append("badname", getBadname())
            .append("time", getTime())
            .append("lastreading", getLastreading())
            .append("reading", getReading())
            .append("unit", getUnit())
            .append("state", getState())
            .toString();
    }
}
