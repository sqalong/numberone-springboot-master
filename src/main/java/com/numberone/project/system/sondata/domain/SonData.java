package com.numberone.project.system.sondata.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 子地区基本信息对象 son_data
 * 
 * @author sqalong
 * @date 2021-01-12
 */
public class SonData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 父地区 */
    @Excel(name = "父地区")
    private String pname;

    /** 总耗能 */
    @Excel(name = "总耗能")
    private Long sonTotalDissipation;

    /** 累计节能量 */
    @Excel(name = "累计节能量")
    private Integer saveEnergy;

    /** 节省金额 */
    @Excel(name = "节省金额")
    private Integer saveMoney;

    /** 节能率 */
    @Excel(name = "节能率")
    private Integer saveRate;

    /** 减排二氧化碳 */
    @Excel(name = "减排二氧化碳")
    private Integer reduceCo2;

    /** 减排硫化物 */
    @Excel(name = "减排硫化物")
    private Integer reduceSulfide;

    /** 减排烟尘 */
    @Excel(name = "减排烟尘")
    private Integer reduceSoot;

    /** 减排氮化物 */
    @Excel(name = "减排氮化物")
    private Integer reduceNitride;

    /** 累计节省电量 */
    @Excel(name = "累计节省电量")
    private Integer saveElectricity;

    /** 减少用煤 */
    @Excel(name = "减少用煤")
    private Integer reduceCoal;

    public void setPname(String pname) 
    {
        this.pname = pname;
    }

    public String getPname() 
    {
        return pname;
    }
    public void setSonTotalDissipation(Long sonTotalDissipation) 
    {
        this.sonTotalDissipation = sonTotalDissipation;
    }

    public Long getSonTotalDissipation() 
    {
        return sonTotalDissipation;
    }
    public void setSaveEnergy(Integer saveEnergy) 
    {
        this.saveEnergy = saveEnergy;
    }

    public Integer getSaveEnergy() 
    {
        return saveEnergy;
    }
    public void setSaveMoney(Integer saveMoney) 
    {
        this.saveMoney = saveMoney;
    }

    public Integer getSaveMoney() 
    {
        return saveMoney;
    }
    public void setSaveRate(Integer saveRate) 
    {
        this.saveRate = saveRate;
    }

    public Integer getSaveRate() 
    {
        return saveRate;
    }
    public void setReduceCo2(Integer reduceCo2) 
    {
        this.reduceCo2 = reduceCo2;
    }

    public Integer getReduceCo2() 
    {
        return reduceCo2;
    }
    public void setReduceSulfide(Integer reduceSulfide) 
    {
        this.reduceSulfide = reduceSulfide;
    }

    public Integer getReduceSulfide() 
    {
        return reduceSulfide;
    }
    public void setReduceSoot(Integer reduceSoot) 
    {
        this.reduceSoot = reduceSoot;
    }

    public Integer getReduceSoot() 
    {
        return reduceSoot;
    }
    public void setReduceNitride(Integer reduceNitride) 
    {
        this.reduceNitride = reduceNitride;
    }

    public Integer getReduceNitride() 
    {
        return reduceNitride;
    }
    public void setSaveElectricity(Integer saveElectricity) 
    {
        this.saveElectricity = saveElectricity;
    }

    public Integer getSaveElectricity() 
    {
        return saveElectricity;
    }
    public void setReduceCoal(Integer reduceCoal) 
    {
        this.reduceCoal = reduceCoal;
    }

    public Integer getReduceCoal() 
    {
        return reduceCoal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("pname", getPname())
            .append("sonTotalDissipation", getSonTotalDissipation())
            .append("saveEnergy", getSaveEnergy())
            .append("saveMoney", getSaveMoney())
            .append("saveRate", getSaveRate())
            .append("reduceCo2", getReduceCo2())
            .append("reduceSulfide", getReduceSulfide())
            .append("reduceSoot", getReduceSoot())
            .append("reduceNitride", getReduceNitride())
            .append("saveElectricity", getSaveElectricity())
            .append("reduceCoal", getReduceCoal())
            .toString();
    }
}
