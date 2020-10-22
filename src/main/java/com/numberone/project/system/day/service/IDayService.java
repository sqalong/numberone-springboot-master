package com.numberone.project.system.day.service;

import java.util.List;
import com.numberone.project.system.day.domain.Day;

/**
 * VIEWService接口
 * 
 * @author numberone
 * @date 2020-10-22
 */
public interface IDayService 
{
    /**
     * 查询VIEW
     * 
     * @param name VIEWID
     * @return VIEW
     */
    public Day selectDayById(String name);

    /**
     * 查询VIEW列表
     * 
     * @param day VIEW
     * @return VIEW集合
     */
    public List<Day> selectDayList(Day day);

    /**
     * 新增VIEW
     * 
     * @param day VIEW
     * @return 结果
     */
    public int insertDay(Day day);

    /**
     * 修改VIEW
     * 
     * @param day VIEW
     * @return 结果
     */
    public int updateDay(Day day);

    /**
     * 批量删除VIEW
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDayByIds(String ids);

    /**
     * 删除VIEW信息
     * 
     * @param name VIEWID
     * @return 结果
     */
    public int deleteDayById(String name);
}
