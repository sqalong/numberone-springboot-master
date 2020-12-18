package com.numberone.project.system.zamanager.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 大屏展示数据对象 za
 * 
 * @author sqalong
 * @date 2020-12-16
 */
public class ZaManager extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 总耗能 */
    @Excel(name = "总耗能")
    private String yuez;

    /** 累计节能量 */
    @Excel(name = "累计节能量")
    private String ljjnl;

    /** 节省金额 */
    @Excel(name = "节省金额")
    private String jsje;

    /** 节能率 */
    @Excel(name = "节能率")
    private String jnl;

    /** 减排二氧化碳 */
    @Excel(name = "减排二氧化碳")
    private String cot;

    /** 减排硫化物 */
    @Excel(name = "减排硫化物")
    private String sot;

    /** 减排烟尘 */
    @Excel(name = "减排烟尘")
    private String nott;

    /** 减排氮化物 */
    @Excel(name = "减排氮化物")
    private String xuet;

    /** 累计节电 */
    @Excel(name = "累计节电")
    private String ljyd;

    /** 减少用煤 */
    @Excel(name = "减少用煤")
    private String jsym;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setYuez(String yuez) 
    {
        this.yuez = yuez;
    }

    public String getYuez() 
    {
        return yuez;
    }
    public void setLjjnl(String ljjnl) 
    {
        this.ljjnl = ljjnl;
    }

    public String getLjjnl() 
    {
        return ljjnl;
    }
    public void setJsje(String jsje) 
    {
        this.jsje = jsje;
    }

    public String getJsje() 
    {
        return jsje;
    }
    public void setJnl(String jnl) 
    {
        this.jnl = jnl;
    }

    public String getJnl() 
    {
        return jnl;
    }
    public void setCot(String cot) 
    {
        this.cot = cot;
    }

    public String getCot() 
    {
        return cot;
    }
    public void setSot(String sot) 
    {
        this.sot = sot;
    }

    public String getSot() 
    {
        return sot;
    }
    public void setNott(String nott) 
    {
        this.nott = nott;
    }

    public String getNott() 
    {
        return nott;
    }
    public void setXuet(String xuet) 
    {
        this.xuet = xuet;
    }

    public String getXuet() 
    {
        return xuet;
    }
    public void setLjyd(String ljyd) 
    {
        this.ljyd = ljyd;
    }

    public String getLjyd() 
    {
        return ljyd;
    }
    public void setJsym(String jsym) 
    {
        this.jsym = jsym;
    }

    public String getJsym() 
    {
        return jsym;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("yuez", getYuez())
            .append("ljjnl", getLjjnl())
            .append("jsje", getJsje())
            .append("jnl", getJnl())
            .append("cot", getCot())
            .append("sot", getSot())
            .append("nott", getNott())
            .append("xuet", getXuet())
            .append("ljyd", getLjyd())
            .append("jsym", getJsym())
            .toString();
    }
}
