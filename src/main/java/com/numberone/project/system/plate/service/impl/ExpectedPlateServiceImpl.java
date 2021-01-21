package com.numberone.project.system.plate.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.numberone.framework.web.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.plate.mapper.ExpectedPlateMapper;
import com.numberone.project.system.plate.domain.ExpectedPlate;
import com.numberone.project.system.plate.service.IExpectedPlateService;
import com.numberone.common.utils.text.Convert;

/**
 * 子地区小版块数据后台Service业务层处理
 * 
 * @author sqalong
 * @date 2021-01-12
 */
@Service
public class ExpectedPlateServiceImpl implements IExpectedPlateService 
{
    @Autowired
    private ExpectedPlateMapper expectedPlateMapper;

    /**
     * 查询子地区小版块数据后台
     * 
     * @param id 子地区小版块数据后台ID
     * @return 子地区小版块数据后台
     */
    @Override
    public ExpectedPlate selectExpectedPlateById(Long id)
    {
        return expectedPlateMapper.selectExpectedPlateById(id);
    }

    /**
     * 查询子地区小版块数据后台列表
     * 
     * @param expectedPlate 子地区小版块数据后台
     * @return 子地区小版块数据后台
     */
    @Override
    public List<ExpectedPlate> selectExpectedPlateList(ExpectedPlate expectedPlate)
    {
        return expectedPlateMapper.selectExpectedPlateList(expectedPlate);
    }

    /**
     * 新增子地区小版块数据后台
     * 
     * @param expectedPlate 子地区小版块数据后台
     * @return 结果
     */
    @Override
    public int insertExpectedPlate(ExpectedPlate expectedPlate)
    {
        return expectedPlateMapper.insertExpectedPlate(expectedPlate);
    }

    /**
     * 修改子地区小版块数据后台
     * 
     * @param expectedPlate 子地区小版块数据后台
     * @return 结果
     */
    @Override
    public int updateExpectedPlate(ExpectedPlate expectedPlate)
    {
        return expectedPlateMapper.updateExpectedPlate(expectedPlate);
    }

    /**
     * 删除子地区小版块数据后台对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteExpectedPlateByIds(String ids)
    {
        return expectedPlateMapper.deleteExpectedPlateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除子地区小版块数据后台信息
     * 
     * @param id 子地区小版块数据后台ID
     * @return 结果
     */
    @Override
    public int deleteExpectedPlateById(Long id)
    {
        return expectedPlateMapper.deleteExpectedPlateById(id);
    }

    /**
     * 查询子地区小版块数据后台树列表
     * 
     * @return 所有子地区小版块数据后台信息
     */
    @Override
    public List<Ztree> selectExpectedPlateTree()
    {
        List<ExpectedPlate> expectedPlateList = expectedPlateMapper.selectExpectedPlateList(new ExpectedPlate());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (ExpectedPlate expectedPlate : expectedPlateList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(expectedPlate.getId());
            ztree.setpId(expectedPlate.getPid());
            ztree.setName(expectedPlate.getName());
            ztree.setTitle(expectedPlate.getName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    @Override
    public List<ExpectedPlate> selectExpectedPlateLists(String largeareaname) {
        return expectedPlateMapper.selectExpectedPlateLists(largeareaname);
    }
}
