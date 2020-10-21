package com.numberone.project.crm.customer.mapper;

import com.numberone.project.crm.customer.domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户 数据层
 * 
 * @author numberone专业开发
 * @date 2019-06-05
 */
public interface CustomerMapper 
{
	/**
     * 查询客户信息
     * 
     * @param customerId 客户ID
     * @return 客户信息
     */
	public Customer selectCustomerById(Long customerId);
	
	/**
     * 查询客户列表
     * 
     * @param customer 客户信息
     * @return 客户集合
     */
	public List<Customer> selectCustomerList(Customer customer);
	
	/**
     * 新增客户
     * 
     * @param customer 客户信息
     * @return 结果
     */
	public int insertCustomer(Customer customer);
	
	/**
     * 修改客户
     * 
     * @param customer 客户信息
     * @return 结果
     */
	public int updateCustomer(Customer customer);
	
	/**
     * 删除客户
     * 
     * @param customerId 客户ID
     * @return 结果
     */
	public int deleteCustomerById(Long customerId);
	
	/**
     * 批量删除客户
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCustomerByIds(String[] customerIds);

	/**
	 * 迁移客户
	 *
	 */
	public int transferCustomerByIds(@Param("userId") String userId, @Param("userName") String userName, @Param("customerIds") String[] customerIds);

}