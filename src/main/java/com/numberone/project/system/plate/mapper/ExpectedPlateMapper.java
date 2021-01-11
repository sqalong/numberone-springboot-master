package com.numberone.project.system.plate.mapper;

import java.util.List;
import com.numberone.project.system.plate.domain.ExpectedPlate;

/**
 * 子地区小版块数据后台Mapper接口
 * 
 * @author sqalong
 * @date 2021-01-11
 */
public interface ExpectedPlateMapper 
{
    /**
     * 查询子地区小版块数据后台
     * 
     * @param id 子地区小版块数据后台ID
     * @return 子地区小版块数据后台
     */
    public ExpectedPlate selectExpectedPlateById(Long id);

    /**
     * 查询子地区小版块数据后台列表
     * 
     * @param expectedPlate 子地区小版块数据后台
     * @return 子地区小版块数据后台集合
     */
    public List<ExpectedPlate> selectExpectedPlateList(ExpectedPlate expectedPlate);

    /**
     * 新增子地区小版块数据后台
     * 
     * @param expectedPlate 子地区小版块数据后台
     * @return 结果
     */
    public int insertExpectedPlate(ExpectedPlate expectedPlate);

    /**
     * 修改子地区小版块数据后台
     * 
     * @param expectedPlate 子地区小版块数据后台
     * @return 结果
     */
    public int updateExpectedPlate(ExpectedPlate expectedPlate);

    /**
     * 删除子地区小版块数据后台
     * 
     * @param id 子地区小版块数据后台ID
     * @return 结果
     */
    public int deleteExpectedPlateById(Long id);

    /**
     * 批量删除子地区小版块数据后台
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteExpectedPlateByIds(String[] ids);

    List<ExpectedPlate> selectExpectedPlateListBypid(ExpectedPlate expectedPlate);
}
