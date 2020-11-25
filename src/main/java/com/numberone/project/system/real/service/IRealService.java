package com.numberone.project.system.real.service;

import java.util.List;
import com.numberone.project.system.real.domain.Real;
import com.numberone.project.system.real.domain.Treee;

/**
 * 实时遥测曲线Service接口
 * 
 * @author numberone
 * @date 2020-11-24
 */
public interface IRealService 
{
    /**
     * 查询实时遥测曲线
     * 
     * @param id 实时遥测曲线ID
     * @return 实时遥测曲线
     */
    public Real selectRealById(Long id);

    /**
     * 查询实时遥测曲线列表
     * 
     * @param real 实时遥测曲线
     * @return 实时遥测曲线集合
     */
    public List<Real> selectRealList(Real real);

    /**
     * 新增实时遥测曲线
     * 
     * @param real 实时遥测曲线
     * @return 结果
     */
    public int insertReal(Real real);

    /**
     * 修改实时遥测曲线
     * 
     * @param real 实时遥测曲线
     * @return 结果
     */
    public int updateReal(Real real);

    /**
     * 批量删除实时遥测曲线
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRealByIds(String ids);

    /**
     * 删除实时遥测曲线信息
     * 
     * @param id 实时遥测曲线ID
     * @return 结果
     */
    public int deleteRealById(Long id);

    List<Treee> treelist();
}
