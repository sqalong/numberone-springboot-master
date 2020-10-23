package com.numberone.project.system.energy.mapper;

import java.util.List;
import com.numberone.project.system.energy.domain.ProductEnergy;

/**
 * 单位用能ManagerMapper接口
 * 
 * @author numberone
 * @date 2020-10-23
 */
public interface ProductEnergyMapper 
{
    /**
     * 查询单位用能Manager
     * 
     * @param productId 单位用能ManagerID
     * @return 单位用能Manager
     */
    public ProductEnergy selectProductEnergyById(Long productId);

    /**
     * 查询单位用能Manager列表
     * 
     * @param productEnergy 单位用能Manager
     * @return 单位用能Manager集合
     */
    public List<ProductEnergy> selectProductEnergyList(ProductEnergy productEnergy);

    /**
     * 新增单位用能Manager
     * 
     * @param productEnergy 单位用能Manager
     * @return 结果
     */
    public int insertProductEnergy(ProductEnergy productEnergy);

    /**
     * 修改单位用能Manager
     * 
     * @param productEnergy 单位用能Manager
     * @return 结果
     */
    public int updateProductEnergy(ProductEnergy productEnergy);

    /**
     * 删除单位用能Manager
     * 
     * @param productId 单位用能ManagerID
     * @return 结果
     */
    public int deleteProductEnergyById(Long productId);

    /**
     * 批量删除单位用能Manager
     * 
     * @param productIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProductEnergyByIds(String[] productIds);
}
