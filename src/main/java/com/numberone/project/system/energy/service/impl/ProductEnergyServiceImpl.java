package com.numberone.project.system.energy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.energy.mapper.ProductEnergyMapper;
import com.numberone.project.system.energy.domain.ProductEnergy;
import com.numberone.project.system.energy.service.IProductEnergyService;
import com.numberone.common.utils.text.Convert;

/**
 * 单位用能ManagerService业务层处理
 * 
 * @author numberone
 * @date 2020-11-19
 */
@Service
public class ProductEnergyServiceImpl implements IProductEnergyService 
{
    @Autowired
    private ProductEnergyMapper productEnergyMapper;

    /**
     * 查询单位用能Manager
     * 
     * @param productId 单位用能ManagerID
     * @return 单位用能Manager
     */
    @Override
    public ProductEnergy selectProductEnergyById(Long productId)
    {
        return productEnergyMapper.selectProductEnergyById(productId);
    }

    /**
     * 查询单位用能Manager列表
     * 
     * @param productEnergy 单位用能Manager
     * @return 单位用能Manager
     */
    @Override
    public List<ProductEnergy> selectProductEnergyList(ProductEnergy productEnergy)
    {
        return productEnergyMapper.selectProductEnergyList(productEnergy);
    }

    /**
     * 新增单位用能Manager
     * 
     * @param productEnergy 单位用能Manager
     * @return 结果
     */
    @Override
    public int insertProductEnergy(ProductEnergy productEnergy)
    {
        return productEnergyMapper.insertProductEnergy(productEnergy);
    }

    /**
     * 修改单位用能Manager
     * 
     * @param productEnergy 单位用能Manager
     * @return 结果
     */
    @Override
    public int updateProductEnergy(ProductEnergy productEnergy)
    {
        return productEnergyMapper.updateProductEnergy(productEnergy);
    }

    /**
     * 删除单位用能Manager对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProductEnergyByIds(String ids)
    {
        return productEnergyMapper.deleteProductEnergyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除单位用能Manager信息
     * 
     * @param productId 单位用能ManagerID
     * @return 结果
     */
    @Override
    public int deleteProductEnergyById(Long productId)
    {
        return productEnergyMapper.deleteProductEnergyById(productId);
    }
}
