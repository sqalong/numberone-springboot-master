package com.numberone.project.system.news.service;

import java.util.List;
import com.numberone.project.system.news.domain.News;
import com.numberone.project.system.user.domain.User;

/**
 * 消息提醒Service接口
 * 
 * @author sqalong
 * @date 2020-12-28
 */
public interface INewsService 
{
    /**
     * 查询消息提醒
     * 
     * @param id 消息提醒ID
     * @return 消息提醒
     */
    public News selectNewsById(Long id);

    /**
     * 查询消息提醒列表
     * 
     * @param news 消息提醒
     * @return 消息提醒集合
     */
    public List<News> selectNewsList(News news);

    /**
     * 新增消息提醒
     * 
     * @param news 消息提醒
     * @return 结果
     */
    public int insertNews(News news);

    /**
     * 修改消息提醒
     * 
     * @param news 消息提醒
     * @return 结果
     */
    public int updateNews(News news);

    /**
     * 批量删除消息提醒
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNewsByIds(String ids);

    /**
     * 删除消息提醒信息
     * 
     * @param id 消息提醒ID
     * @return 结果
     */
    public int deleteNewsById(Long id);

    User getNameId(String username);

    int upMessage(String ids, Long nameids);

    int deleteMessage(String ids, Long nameids);
}
