package com.numberone.project.system.notice.service;

import java.util.List;

import com.numberone.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.common.utils.security.ShiroUtils;
import com.numberone.common.utils.text.Convert;
import com.numberone.project.system.notice.mapper.NoticeMapper;
import com.numberone.project.system.notice.domain.Notice;

/**
 * 公告 服务层实现
 * 
 * @author numberone
 * @date 2018-06-25
 */
@Service
public class NoticeServiceImpl implements INoticeService
{
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    @Override
    public Notice selectNoticeById(Long noticeId)
    {
        return noticeMapper.selectNoticeById(noticeId);
    }

    /**
     * 查询公告列表
     * 
     * @param notice 公告信息
     * @return 公告集合
     */
    @Override
    public List<Notice> selectNoticeList(Notice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int insertNotice(Notice notice)
    {
        notice.setCreateBy(ShiroUtils.getLoginName());
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int updateNotice(Notice notice)
    {
        notice.setUpdateBy(ShiroUtils.getLoginName());
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 删除公告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(String ids)
    {
        return noticeMapper.deleteNoticeByIds(Convert.toStrArray(ids));
    }

    @Override
    public List<Notice> getnoticeids() {
        return noticeMapper.getnoticeids();
    }

    @Override
    public int addmessage(List<User> list) {
        return noticeMapper.addmessage(list);
    }

    @Override
    public Integer waringNumber(Long nameids) {
        return noticeMapper.waringNumber(nameids);
    }


//    @Override
//    public User getNameId(String username) {
//        return noticeMapper.upMessage(ids,nameids);
//    }
}
