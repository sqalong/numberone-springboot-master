package com.numberone.project.system.news.service.impl;

import java.util.List;
import com.numberone.common.utils.DateUtils;
import com.numberone.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.news.mapper.NewsMapper;
import com.numberone.project.system.news.domain.News;
import com.numberone.project.system.news.service.INewsService;
import com.numberone.common.utils.text.Convert;


/**
 * 消息提醒Service业务层处理
 * 
 * @author sqalong
 * @date 2020-12-28
 */
@Service
public class NewsServiceImpl implements INewsService 
{
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询消息提醒
     * 
     * @param id 消息提醒ID
     * @return 消息提醒
     */
    @Override
    public News selectNewsById(Long id)
    {
        return newsMapper.selectNewsById(id);
    }

    /**
     * 查询消息提醒列表
     * 
     * @param news 消息提醒
     * @return 消息提醒
     */
    @Override
    public List<News> selectNewsList(News news)
    {
        return newsMapper.selectNewsList(news);
    }

    /**
     * 新增消息提醒
     * 
     * @param news 消息提醒
     * @return 结果
     */
    @Override
    public int insertNews(News news)
    {
        news.setCreateTime(DateUtils.getNowDate());
        return newsMapper.insertNews(news);
    }

    /**
     * 修改消息提醒
     * 
     * @param news 消息提醒
     * @return 结果
     */
    @Override
    public int updateNews(News news)
    {
        return newsMapper.updateNews(news);
    }

    /**
     * 删除消息提醒对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNewsByIds(String ids)
    {
        return newsMapper.deleteNewsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除消息提醒信息
     * 
     * @param id 消息提醒ID
     * @return 结果
     */
    @Override
    public int deleteNewsById(Long id)
    {
        return newsMapper.deleteNewsById(id);
    }

    @Override
    public User getNameId(String username) {
        return newsMapper.getNameId(username);
    }

    @Override
    public int upMessage(String ids, Long nameids) {
        return newsMapper.upMessage(ids,nameids);
    }

    @Override
    public int deleteMessage(String ids, Long nameids) {
        return newsMapper.deleteMessage(ids,nameids);
    }


}
