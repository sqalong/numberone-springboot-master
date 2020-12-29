package com.numberone.project.system.warning.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.warning.mapper.WarningNoticeMapper;
import com.numberone.project.system.warning.domain.WarningNotice;
import com.numberone.project.system.warning.service.IWarningNoticeService;
import com.numberone.common.utils.text.Convert;

/**
 * 告警通知Service业务层处理
 * 
 * @author sqalong
 * @date 2020-12-09
 */
@Service
public class WarningNoticeServiceImpl implements IWarningNoticeService 
{
    @Autowired
    private WarningNoticeMapper warningNoticeMapper;

    /**
     * 查询告警通知
     * 
     * @param id 告警通知ID
     * @return 告警通知
     */
    @Override
    public WarningNotice selectWarningNoticeById(Long id)
    {
        return warningNoticeMapper.selectWarningNoticeById(id);
    }

    /**
     * 查询告警通知列表
     * 
     * @param warningNotice 告警通知
     * @return 告警通知
     */
    @Override
    public List<WarningNotice> selectWarningNoticeList(WarningNotice warningNotice)
    {
        return warningNoticeMapper.selectWarningNoticeList(warningNotice);
    }

    /**
     * 新增告警通知
     * 
     * @param warningNotice 告警通知
     * @return 结果
     */
    @Override
    public int insertWarningNotice(WarningNotice warningNotice)
    {
        return warningNoticeMapper.insertWarningNotice(warningNotice);
    }

    /**
     * 修改告警通知
     * 
     * @param warningNotice 告警通知
     * @return 结果
     */
    @Override
    public int updateWarningNotice(WarningNotice warningNotice)
    {
        return warningNoticeMapper.updateWarningNotice(warningNotice);
    }

    /**
     * 删除告警通知对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWarningNoticeByIds(String ids)
    {
        return warningNoticeMapper.deleteWarningNoticeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除告警通知信息
     * 
     * @param id 告警通知ID
     * @return 结果
     */
    @Override
    public int deleteWarningNoticeById(Long id)
    {
        return warningNoticeMapper.deleteWarningNoticeById(id);
    }


}
