package com.numberone.project.system.plate.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.TreeEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 子地区小版块数据后台对象 expected_plate
 * 
 * @author sqalong
 * @date 2021-01-11
 */
public class ExpectedPlate extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 小版块名称 */
    @Excel(name = "小版块名称")
    private String function;

    /** 场院名称 */
    @Excel(name = "场院名称")
    private String name;

    /** 节能率 */
    @Excel(name = "节能率")
    private Long energySaving;

    /** 节能量 */
    @Excel(name = "节能量")
    private Double energyQuantity;

    /** 节能金额 */
    @Excel(name = "节能金额")
    private Double energyMoney;

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
    public void setFunction(String function) 
    {
        this.function = function;
    }

    public String getFunction() 
    {
        return function;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setEnergySaving(Long energySaving) 
    {
        this.energySaving = energySaving;
    }

    public Long getEnergySaving() 
    {
        return energySaving;
    }
    public void setEnergyQuantity(Double energyQuantity) 
    {
        this.energyQuantity = energyQuantity;
    }

    public Double getEnergyQuantity() 
    {
        return energyQuantity;
    }
    public void setEnergyMoney(Double energyMoney) 
    {
        this.energyMoney = energyMoney;
    }

    public Double getEnergyMoney() 
    {
        return energyMoney;
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
            .append("function", getFunction())
            .append("name", getName())
            .append("energySaving", getEnergySaving())
            .append("energyQuantity", getEnergyQuantity())
            .append("energyMoney", getEnergyMoney())
            .append("pid", getPid())
            .toString();
    }
}
