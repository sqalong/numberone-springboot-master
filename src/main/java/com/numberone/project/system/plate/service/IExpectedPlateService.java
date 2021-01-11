package com.numberone.project.system.plate.service;

import java.util.List;
import com.numberone.project.system.plate.domain.ExpectedPlate;
import com.numberone.framework.web.domain.Ztree;

/**
 * 子地区小版块数据后台Service接口
 * 
 * @author sqalong
 * @date 2021-01-11
 */
public interface IExpectedPlateService 
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
     * 批量删除子地区小版块数据后台
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteExpectedPlateByIds(String ids);

    /**
     * 删除子地区小版块数据后台信息
     * 
     * @param id 子地区小版块数据后台ID
     * @return 结果
     */
    public int deleteExpectedPlateById(Long id);

    /**
     * 查询子地区小版块数据后台树列表
     * 
     * @return 所有子地区小版块数据后台信息
     */
    public List<Ztree> selectExpectedPlateTree();

    List<ExpectedPlate> selectExpectedPlateListBypid(ExpectedPlate expectedPlate);
}
