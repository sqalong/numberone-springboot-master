package com.numberone.project.system.watermanager.mapper;

import java.util.List;
import com.numberone.project.system.watermanager.domain.WaterManager;

/**
 * watermanagerMapper接口
 * 
 * @author sqalong
 * @date 2020-12-17
 */
public interface WaterManagerMapper 
{
    /**
     * 查询watermanager
     * 
     * @param id watermanagerID
     * @return watermanager
     */
    public WaterManager selectWaterManagerById(Long id);

    /**
     * 查询watermanager列表
     * 
     * @param waterManager watermanager
     * @return watermanager集合
     */
    public List<WaterManager> selectWaterManagerList(WaterManager waterManager);

    /**
     * 新增watermanager
     * 
     * @param waterManager watermanager
     * @return 结果
     */
    public int insertWaterManager(WaterManager waterManager);

    /**
     * 修改watermanager
     * 
     * @param waterManager watermanager
     * @return 结果
     */
    public int updateWaterManager(WaterManager waterManager);

    /**
     * 删除watermanager
     * 
     * @param id watermanagerID
     * @return 结果
     */
    public int deleteWaterManagerById(Long id);

    /**
     * 批量删除watermanager
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWaterManagerByIds(String[] ids);
}
