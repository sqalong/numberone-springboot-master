package com.numberone.project.system.cnelectric.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.cnelectric.mapper.CnelectricMapper;
import com.numberone.project.system.cnelectric.domain.Cnelectric;
import com.numberone.project.system.cnelectric.service.ICnelectricService;
import com.numberone.common.utils.text.Convert;

/**
 * 场院电表数据控制台Service业务层处理
 * 
 * @author sqalong
 * @date 2021-01-07
 */
@Service
public class CnelectricServiceImpl implements ICnelectricService 
{
    @Autowired
    private CnelectricMapper cnelectricMapper;

    /**
     * 查询场院电表数据控制台
     * 
     * @param region 场院电表数据控制台ID
     * @return 场院电表数据控制台
     */
    @Override
    public Cnelectric selectCnelectricById(String region)
    {
        return cnelectricMapper.selectCnelectricById(region);
    }

    /**
     * 查询场院电表数据控制台列表
     * 
     * @param cnelectric 场院电表数据控制台
     * @return 场院电表数据控制台
     */
    @Override
    public List<Cnelectric> selectCnelectricList(Cnelectric cnelectric)
    {
        return cnelectricMapper.selectCnelectricList(cnelectric);
    }

    /**
     * 新增场院电表数据控制台
     * 
     * @param cnelectric 场院电表数据控制台
     * @return 结果
     */
    @Override
    public int insertCnelectric(Cnelectric cnelectric)
    {
        return cnelectricMapper.insertCnelectric(cnelectric);
    }

    /**
     * 修改场院电表数据控制台
     * 
     * @param cnelectric 场院电表数据控制台
     * @return 结果
     */
    @Override
    public int updateCnelectric(Cnelectric cnelectric)
    {
        return cnelectricMapper.updateCnelectric(cnelectric);
    }

    /**
     * 删除场院电表数据控制台对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCnelectricByIds(String ids)
    {
        return cnelectricMapper.deleteCnelectricByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除场院电表数据控制台信息
     * 
     * @param region 场院电表数据控制台ID
     * @return 结果
     */
    @Override
    public int deleteCnelectricById(String region)
    {
        return cnelectricMapper.deleteCnelectricById(region);
    }
}
