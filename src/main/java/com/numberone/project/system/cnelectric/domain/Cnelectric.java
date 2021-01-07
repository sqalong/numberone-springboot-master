package com.numberone.project.system.cnelectric.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 场院电表数据控制台对象 energy_contrast
 * 
 * @author sqalong
 * @date 2021-01-07
 */
public class Cnelectric extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 地区名称 */
    @Excel(name = "地区名称")
    private String region;

    /** 时间 */
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date timing;

    /** 用电值 */
    @Excel(name = "用电值")
    private Double number;

    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setTiming(Date timing) 
    {
        this.timing = timing;
    }

    public Date getTiming() 
    {
        return timing;
    }
    public void setNumber(Double number) 
    {
        this.number = number;
    }

    public Double getNumber() 
    {
        return number;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("region", getRegion())
            .append("timing", getTiming())
            .append("number", getNumber())
            .toString();
    }
}
