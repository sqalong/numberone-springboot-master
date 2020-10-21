package com.numberone.project.system.student.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;

/**
 * StudentManager对象 student
 * 
 * @author numberone
 * @date 2020-10-20
 */
public class Student extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生ID */
    private Long id;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String name;

    /** 学生性别 */
    @Excel(name = "学生性别")
    private String sex;

    /** 家庭地址 */
    @Excel(name = "家庭地址")
    private String address;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sex", getSex())
            .append("address", getAddress())
            .toString();
    }
}
