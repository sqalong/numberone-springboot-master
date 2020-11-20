package com.numberone.project.system.energy.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 单位用能Manager对象 product_energy
 * 
 * @author numberone
 * @date 2020-11-19
 */
public class ProductEnergy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long productId;

    /** 用能单位 */
    @Excel(name = "用能单位")
    private String energyUnits;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 能源分类 */
    @Excel(name = "能源分类")
    private String energyConsumptionType;

    /** 能耗分项 */
    @Excel(name = "能耗分项")
    private String energyConsumptionItemized;

    /** 时间 */
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 本月值 */
    @Excel(name = "本月值")
    private String theMonthPrice;

    /** 产量 */
    @Excel(name = "产量")
    private String capacity;

    /** 单位产品能耗 */
    @Excel(name = "单位产品能耗")
    private String unitProductEnergy;

    /** 上年同期产量 */
    @Excel(name = "上年同期产量")
    private String yAgoProduction;

    /** 产品能耗费用 */
    @Excel(name = "产品能耗费用")
    private String producEnergyCost;

    /** 单位产品能耗费用 */
    @Excel(name = "单位产品能耗费用")
    private String unitProductEnergyCost;

    /** 上年同期值 */
    @Excel(name = "上年同期值")
    private String yAgoValue;

    /** 单位产品能耗上年同期 */
    @Excel(name = "单位产品能耗上年同期")
    private String unitProductEnergyYAgo;

    /** 产品能耗费用上年同期 */
    @Excel(name = "产品能耗费用上年同期")
    private String producEnergyCostYAgo;

    /** 单位产品能耗费用上年同期 */
    @Excel(name = "单位产品能耗费用上年同期")
    private String unitProductEnergyCostYAgo;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setEnergyUnits(String energyUnits) 
    {
        this.energyUnits = energyUnits;
    }

    public String getEnergyUnits() 
    {
        return energyUnits;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setEnergyConsumptionType(String energyConsumptionType) 
    {
        this.energyConsumptionType = energyConsumptionType;
    }

    public String getEnergyConsumptionType() 
    {
        return energyConsumptionType;
    }
    public void setEnergyConsumptionItemized(String energyConsumptionItemized) 
    {
        this.energyConsumptionItemized = energyConsumptionItemized;
    }

    public String getEnergyConsumptionItemized() 
    {
        return energyConsumptionItemized;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setTheMonthPrice(String theMonthPrice) 
    {
        this.theMonthPrice = theMonthPrice;
    }

    public String getTheMonthPrice() 
    {
        return theMonthPrice;
    }
    public void setCapacity(String capacity) 
    {
        this.capacity = capacity;
    }

    public String getCapacity() 
    {
        return capacity;
    }
    public void setUnitProductEnergy(String unitProductEnergy) 
    {
        this.unitProductEnergy = unitProductEnergy;
    }

    public String getUnitProductEnergy() 
    {
        return unitProductEnergy;
    }
    public void setyAgoProduction(String yAgoProduction) 
    {
        this.yAgoProduction = yAgoProduction;
    }

    public String getyAgoProduction() 
    {
        return yAgoProduction;
    }
    public void setProducEnergyCost(String producEnergyCost) 
    {
        this.producEnergyCost = producEnergyCost;
    }

    public String getProducEnergyCost() 
    {
        return producEnergyCost;
    }
    public void setUnitProductEnergyCost(String unitProductEnergyCost) 
    {
        this.unitProductEnergyCost = unitProductEnergyCost;
    }

    public String getUnitProductEnergyCost() 
    {
        return unitProductEnergyCost;
    }
    public void setyAgoValue(String yAgoValue) 
    {
        this.yAgoValue = yAgoValue;
    }

    public String getyAgoValue() 
    {
        return yAgoValue;
    }
    public void setUnitProductEnergyYAgo(String unitProductEnergyYAgo) 
    {
        this.unitProductEnergyYAgo = unitProductEnergyYAgo;
    }

    public String getUnitProductEnergyYAgo() 
    {
        return unitProductEnergyYAgo;
    }
    public void setProducEnergyCostYAgo(String producEnergyCostYAgo) 
    {
        this.producEnergyCostYAgo = producEnergyCostYAgo;
    }

    public String getProducEnergyCostYAgo() 
    {
        return producEnergyCostYAgo;
    }
    public void setUnitProductEnergyCostYAgo(String unitProductEnergyCostYAgo) 
    {
        this.unitProductEnergyCostYAgo = unitProductEnergyCostYAgo;
    }

    public String getUnitProductEnergyCostYAgo() 
    {
        return unitProductEnergyCostYAgo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("energyUnits", getEnergyUnits())
            .append("productName", getProductName())
            .append("energyConsumptionType", getEnergyConsumptionType())
            .append("energyConsumptionItemized", getEnergyConsumptionItemized())
            .append("time", getTime())
            .append("theMonthPrice", getTheMonthPrice())
            .append("capacity", getCapacity())
            .append("unitProductEnergy", getUnitProductEnergy())
            .append("yAgoProduction", getyAgoProduction())
            .append("producEnergyCost", getProducEnergyCost())
            .append("unitProductEnergyCost", getUnitProductEnergyCost())
            .append("yAgoValue", getyAgoValue())
            .append("unitProductEnergyYAgo", getUnitProductEnergyYAgo())
            .append("producEnergyCostYAgo", getProducEnergyCostYAgo())
            .append("unitProductEnergyCostYAgo", getUnitProductEnergyCostYAgo())
            .toString();
    }
}
