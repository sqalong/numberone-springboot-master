package com.numberone.project.system.day.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.day.mapper.DayMapper;
import com.numberone.project.system.day.domain.Day;
import com.numberone.project.system.day.service.IDayService;
import com.numberone.common.utils.text.Convert;

/**
 * VIEWService业务层处理
 * 
 * @author numberone
 * @date 2020-10-22
 */
@Service
public class DayServiceImpl implements IDayService 
{
    @Autowired
    private DayMapper dayMapper;

    /**
     * 查询VIEW
     * 
     * @param name VIEWID
     * @return VIEW
     */
    @Override
    public Day selectDayById(String name)
    {
        return dayMapper.selectDayById(name);
    }

    /**
     * 查询VIEW列表
     * 
     * @param day VIEW
     * @return VIEW
     */
    @Override
    public List<Day> selectDayList(Day day)
    {
        return dayMapper.selectDayList(day);
    }

    /**
     * 新增VIEW
     * 
     * @param day VIEW
     * @return 结果
     */
    @Override
    public int insertDay(Day day)
    {
        return dayMapper.insertDay(day);
    }

    /**
     * 修改VIEW
     * 
     * @param day VIEW
     * @return 结果
     */
    @Override
    public int updateDay(Day day)
    {
        return dayMapper.updateDay(day);
    }

    /**
     * 删除VIEW对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDayByIds(String ids)
    {
        return dayMapper.deleteDayByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除VIEW信息
     * 
     * @param name VIEWID
     * @return 结果
     */
    @Override
    public int deleteDayById(String name)
    {
        return dayMapper.deleteDayById(name);
    }
}
