package com.numberone.project.crm.customer.service;

import com.numberone.framework.web.domain.Ztree;
import com.numberone.project.crm.customer.domain.Customer;
import com.numberone.project.system.user.domain.User;

import java.util.List;

/**
 * 客户 服务层
 * 
 * @author numberone专业开发
 * @date 2019-06-05
 */
public interface ICustomerService 
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
     * 删除客户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCustomerByIds(String ids);

	/**
	 * 查询客户管理树
	 *
	 * @param customer 客户信息
	 * @return 所有客户信息
	 */
	public List<Ztree> selectCustomerTree(Customer customer);

	/**
	 * 迁移客户
	 *
	 */
	public int transferCustomerByIds(String userId, String userName, String ids);

	public String importCustomer(List<Customer> customerList, Boolean isUpdateSupport, User operUser);
	
}
