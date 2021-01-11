package com.numberone.project.system.punctuation.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 地图驻点对象 map_punctuation
 * 
 * @author sqalong
 * @date 2021-01-11
 */
public class MapPunctuation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 驻点名称 */
    @Excel(name = "驻点名称")
    private String name;

    /** 经度 */
    @Excel(name = "经度")
    private Double latitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private Double longitude;

    /** 驻点颜色 */
    @Excel(name = "驻点颜色")
    private String color;

    /** 总值 */
    @Excel(name = "总值")
    private String value;

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setLatitude(Double latitude) 
    {
        this.latitude = latitude;
    }

    public Double getLatitude() 
    {
        return latitude;
    }
    public void setLongitude(Double longitude) 
    {
        this.longitude = longitude;
    }

    public Double getLongitude() 
    {
        return longitude;
    }
    public void setColor(String color) 
    {
        this.color = color;
    }

    public String getColor() 
    {
        return color;
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
            .append("name", getName())
            .append("latitude", getLatitude())
            .append("longitude", getLongitude())
            .append("color", getColor())
            .append("value", getValue())
            .toString();
    }
}
