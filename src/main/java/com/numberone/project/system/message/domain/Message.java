package com.numberone.project.system.message.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * VIEW对象 message
 * 
 * @author sqalong
 * @date 2020-12-23
 */
public class Message extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 消息id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String content;

    /** 内容 */
    @Excel(name = "内容")
    private String type;

    /** 发布时间 */
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** 用户ID */
    private Long userId;

    /** 更改时间 */
    private Date changeTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setChangeTime(Date changeTime) 
    {
        this.changeTime = changeTime;
    }

    public Date getChangeTime() 
    {
        return changeTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("content", getContent())
            .append("type", getType())
            .append("time", getTime())
            .append("state", getState())
            .append("userId", getUserId())
            .append("changeTime", getChangeTime())
            .toString();
    }
}
