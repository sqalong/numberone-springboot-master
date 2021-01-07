package com.numberone.project.system.cnelectric.service;

import java.util.List;
import com.numberone.project.system.cnelectric.domain.Cnelectric;

/**
 * 场院电表数据控制台Service接口
 * 
 * @author sqalong
 * @date 2021-01-07
 */
public interface ICnelectricService 
{
    /**
     * 查询场院电表数据控制台
     * 
     * @param region 场院电表数据控制台ID
     * @return 场院电表数据控制台
     */
    public Cnelectric selectCnelectricById(String region);

    /**
     * 查询场院电表数据控制台列表
     * 
     * @param cnelectric 场院电表数据控制台
     * @return 场院电表数据控制台集合
     */
    public List<Cnelectric> selectCnelectricList(Cnelectric cnelectric);

    /**
     * 新增场院电表数据控制台
     * 
     * @param cnelectric 场院电表数据控制台
     * @return 结果
     */
    public int insertCnelectric(Cnelectric cnelectric);

    /**
     * 修改场院电表数据控制台
     * 
     * @param cnelectric 场院电表数据控制台
     * @return 结果
     */
    public int updateCnelectric(Cnelectric cnelectric);

    /**
     * 批量删除场院电表数据控制台
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCnelectricByIds(String ids);

    /**
     * 删除场院电表数据控制台信息
     * 
     * @param region 场院电表数据控制台ID
     * @return 结果
     */
    public int deleteCnelectricById(String region);
}
