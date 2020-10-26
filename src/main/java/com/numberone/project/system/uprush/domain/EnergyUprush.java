package com.numberone.project.system.uprush.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 模拟时间查询对象 energy_uprush
 * 
 * @author numberone
 * @date 2020-10-26
 */
public class EnergyUprush extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 诊断内容 */
    @Excel(name = "诊断内容")
    private String diagnoseContent;

    /** 诊断日期 */
    @Excel(name = "诊断日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date diagnoseDate;

    /** 是否为异常 */
    @Excel(name = "是否为异常")
    private String abnormal;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDiagnoseContent(String diagnoseContent) 
    {
        this.diagnoseContent = diagnoseContent;
    }

    public String getDiagnoseContent() 
    {
        return diagnoseContent;
    }
    public void setDiagnoseDate(Date diagnoseDate) 
    {
        this.diagnoseDate = diagnoseDate;
    }

    public Date getDiagnoseDate() 
    {
        return diagnoseDate;
    }
    public void setAbnormal(String abnormal) 
    {
        this.abnormal = abnormal;
    }

    public String getAbnormal() 
    {
        return abnormal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("diagnoseContent", getDiagnoseContent())
            .append("diagnoseDate", getDiagnoseDate())
            .append("abnormal", getAbnormal())
            .toString();
    }
}
