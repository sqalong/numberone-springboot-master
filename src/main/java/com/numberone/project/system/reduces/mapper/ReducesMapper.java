package com.numberone.project.system.reduces.mapper;

import java.util.List;
import com.numberone.project.system.reduces.domain.Reduces;

/**
 * 减少排碳Mapper接口
 * 
 * @author sqalong
 * @date 2021-01-07
 */
public interface ReducesMapper 
{
    /**
     * 查询减少排碳
     * 
     * @param id 减少排碳ID
     * @return 减少排碳
     */
    public Reduces selectReducesById(Long id);

    /**
     * 查询减少排碳列表
     * 
     * @param reduces 减少排碳
     * @return 减少排碳集合
     */
    public List<Reduces> selectReducesList(Reduces reduces);

    /**
     * 新增减少排碳
     * 
     * @param reduces 减少排碳
     * @return 结果
     */
    public int insertReduces(Reduces reduces);

    /**
     * 修改减少排碳
     * 
     * @param reduces 减少排碳
     * @return 结果
     */
    public int updateReduces(Reduces reduces);

    /**
     * 删除减少排碳
     * 
     * @param id 减少排碳ID
     * @return 结果
     */
    public int deleteReducesById(Long id);

    /**
     * 批量删除减少排碳
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteReducesByIds(String[] ids);
}
