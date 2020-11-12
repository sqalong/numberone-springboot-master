package com.numberone.project.system.mrar.mapper;

import java.util.List;
import com.numberone.project.system.mrar.domain.Mrar;
import org.springframework.stereotype.Component;

/**
 * 表具抄表录入Mapper接口
 * 
 * @author numberone
 * @date 2020-11-12
 */

@Component
public interface MrarMapper 
{


    /**
     * 查询表具抄表录入
     * 
     * @param id 表具抄表录入ID
     * @return 表具抄表录入
     */
    public Mrar selectMrarById(Integer id);

    /**
     * 查询表具抄表录入列表
     * 
     * @param mrar 表具抄表录入
     * @return 表具抄表录入集合
     */
    public List<Mrar> selectMrarList(Mrar mrar);

    /**
     * 新增表具抄表录入
     * 
     * @param mrar 表具抄表录入
     * @return 结果
     */
    public int insertMrar(Mrar mrar);

    /**
     * 修改表具抄表录入
     * 
     * @param mrar 表具抄表录入
     * @return 结果
     */
    public int updateMrar(Mrar mrar);

    /**
     * 删除表具抄表录入
     * 
     * @param id 表具抄表录入ID
     * @return 结果
     */
    public int deleteMrarById(Integer id);

    /**
     * 批量删除表具抄表录入
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMrarByIds(String[] ids);

    int addMran(Mrar mrarInfo);
}
