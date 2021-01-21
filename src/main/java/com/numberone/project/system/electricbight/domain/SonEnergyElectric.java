package com.numberone.project.system.electricbight.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 子地区用电曲线图数据对象 son_energy_electric
 * 
 * @author sqalong
 * @date 2021-01-13
 */
public class SonEnergyElectric extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 场院名称 */
    @Excel(name = "场院名称")
    private String pname;

    /** 子地区名称 */
    @Excel(name = "子地区名称")
    private String name;

    /** 时间 */
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 用电值 */
    @Excel(name = "用电值")
    private Double sonNumber;

    public void setPname(String pname) 
    {
        this.pname = pname;
    }

    public String getPname() 
    {
        return pname;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setSonNumber(Double sonNumber) 
    {
        this.sonNumber = sonNumber;
    }

    public Double getSonNumber() 
    {
        return sonNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("pname", getPname())
            .append("name", getName())
            .append("time", getTime())
            .append("sonNumber", getSonNumber())
            .toString();
    }
}
