package com.numberone.project.system.warning.mapper;

import java.util.List;
import com.numberone.project.system.warning.domain.WarningNotice;

/**
 * 告警通知Mapper接口
 * 
 * @author sqalong
 * @date 2020-12-09
 */
public interface WarningNoticeMapper 
{
    /**
     * 查询告警通知
     * 
     * @param id 告警通知ID
     * @return 告警通知
     */
    public WarningNotice selectWarningNoticeById(Long id);

    /**
     * 查询告警通知列表
     * 
     * @param warningNotice 告警通知
     * @return 告警通知集合
     */
    public List<WarningNotice> selectWarningNoticeList(WarningNotice warningNotice);

    /**
     * 新增告警通知
     * 
     * @param warningNotice 告警通知
     * @return 结果
     */
    public int insertWarningNotice(WarningNotice warningNotice);

    /**
     * 修改告警通知
     * 
     * @param warningNotice 告警通知
     * @return 结果
     */
    public int updateWarningNotice(WarningNotice warningNotice);

    /**
     * 删除告警通知
     * 
     * @param id 告警通知ID
     * @return 结果
     */
    public int deleteWarningNoticeById(Long id);

    /**
     * 批量删除告警通知
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWarningNoticeByIds(String[] ids);
}
