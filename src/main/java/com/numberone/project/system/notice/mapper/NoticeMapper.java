package com.numberone.project.system.notice.mapper;

import com.numberone.project.system.notice.domain.Notice;
import com.numberone.project.system.user.domain.User;

import java.util.List;

/**
 * 公告 数据层
 * 
 * @author numberone
 */
public interface NoticeMapper
{
    /**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    public Notice selectNoticeById(Long noticeId);

    /**
     * 查询公告列表
     * 
     * @param notice 公告信息
     * @return 公告集合
     */
    public List<Notice> selectNoticeList(Notice notice);

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int insertNotice(Notice notice);

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int updateNotice(Notice notice);

    /**
     * 批量删除公告
     * 
     * @param noticeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeByIds(String[] noticeIds);

    /**
     * 批量删除公告
     *
     * @param messages 需要删除的数据ID
     * @return 结果
     */
    int deletemessageByIds(String[] messages);

    List<Notice> getnoticeids();

    int addmessage(List<User> list);

    Integer waringNumber(Long nameids);


}