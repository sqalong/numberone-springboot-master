package com.numberone.project.system.news.domain;

import com.numberone.framework.aspectj.lang.annotation.Excel;
import com.numberone.framework.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 消息提醒对象 news
 * 
 * @author sqalong
 * @date 2020-12-28
 */
public class News extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String noticeTitle;

    /** 公告内容 */
    @Excel(name = "公告内容")
    private String noticeContent;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** 更改时间 */
    private Date changeTime;

    /** 用户ID */
    private Long userId;

    /** 登录账号 */
    private String loginName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNoticeTitle(String noticeTitle) 
    {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeTitle() 
    {
        return noticeTitle;
    }
    public void setNoticeContent(String noticeContent) 
    {
        this.noticeContent = noticeContent;
    }

    public String getNoticeContent() 
    {
        return noticeContent;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setChangeTime(Date changeTime) 
    {
        this.changeTime = changeTime;
    }

    public Date getChangeTime() 
    {
        return changeTime;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("noticeTitle", getNoticeTitle())
            .append("noticeContent", getNoticeContent())
            .append("createTime", getCreateTime())
            .append("state", getState())
            .append("changeTime", getChangeTime())
            .append("userId", getUserId())
            .append("loginName", getLoginName())
            .toString();
    }
}
