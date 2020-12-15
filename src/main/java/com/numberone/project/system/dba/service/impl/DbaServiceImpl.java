package com.numberone.project.system.dba.service.impl;

import com.numberone.common.utils.text.Convert;
import com.numberone.project.system.dba.domain.Dba;
import com.numberone.project.system.dba.mapper.DbaMapper;
import com.numberone.project.system.dba.service.DbaService;
import com.numberone.project.system.energy.service.IProductEnergyService;
import com.numberone.project.system.real.domain.Real;
import com.numberone.project.system.real.domain.Treee;
import com.numberone.project.system.real.mapper.RealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实时遥测曲线Service业务层处理
 * 
 * @author numberone
 * @date 2020-11-24
 */
@Service
public class DbaServiceImpl implements DbaService
{

    @Autowired
    private DbaMapper dbamapper;


    @Override
    public List<Dba> DbaList() {
        return dbamapper.DbaList();
    }
//    @Autowired
//    private RealMapper realMapper;
//
//    /**
//     * 查询实时遥测曲线
//     *
//     * @param id 实时遥测曲线ID
//     * @return 实时遥测曲线
//     */
//    @Override
//    public Real selectRealById(Long id)
//    {
//        return realMapper.selectRealById(id);
//    }
//
//    /**
//     * 查询实时遥测曲线列表
//     *
//     * @param real 实时遥测曲线
//     * @return 实时遥测曲线
//     */
//    @Override
//    public List<Real> selectRealList(Real real)
//    {
//        return realMapper.selectRealList(real);
//    }
//
//    /**
//     * 新增实时遥测曲线
//     *
//     * @param real 实时遥测曲线
//     * @return 结果
//     */
//    @Override
//    public int insertReal(Real real)
//    {
//        return realMapper.insertReal(real);
//    }
//
//    /**
//     * 修改实时遥测曲线
//     *
//     * @param real 实时遥测曲线
//     * @return 结果
//     */
//    @Override
//    public int updateReal(Real real)
//    {
//        return realMapper.updateReal(real);
//    }
//
//    /**
//     * 删除实时遥测曲线对象
//     *
//     * @param ids 需要删除的数据ID
//     * @return 结果
//     */
//    @Override
//    public int deleteRealByIds(String ids)
//    {
//        return realMapper.deleteRealByIds(Convert.toStrArray(ids));
//    }
//
//    /**
//     * 删除实时遥测曲线信息
//     *
//     * @param id 实时遥测曲线ID
//     * @return 结果
//     */
//    @Override
//    public int deleteRealById(Long id)
//    {
//        return realMapper.deleteRealById(id);
//    }
//
//    @Override
//    public List<Treee> treelist() {
//        return realMapper.treelist();
//    }
}
