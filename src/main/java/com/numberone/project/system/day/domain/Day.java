package com.numberone.project.system.day.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * VIEW对象 day
 * 
 * @author numberone
 * @date 2020-10-22
 */
public class Day extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 班级 */
    @Excel(name = "班级")
    private String classname;

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setClassname(String classname) 
    {
        this.classname = classname;
    }

    public String getClassname() 
    {
        return classname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("name", getName())
            .append("sex", getSex())
            .append("address", getAddress())
            .append("classname", getClassname())
            .toString();
    }
}
