package com.numberone.project.crm.customer.service.impl;

import com.numberone.common.exception.BusinessException;
import com.numberone.common.utils.StringUtils;
import com.numberone.common.utils.text.Convert;
import com.numberone.framework.aspectj.lang.annotation.DataScope;
import com.numberone.framework.web.domain.Ztree;
import com.numberone.project.crm.customer.domain.Customer;
import com.numberone.project.crm.customer.mapper.CustomerMapper;
import com.numberone.project.crm.customer.service.ICustomerService;
import com.numberone.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户 服务层实现
 * 
 * @author numberone专业开发
 * @date 2019-06-05
 */
@Service
public class CustomerServiceImpl implements ICustomerService
{
	@Autowired
	private CustomerMapper customerMapper;

	/**
     * 查询客户信息
     * 
     * @param customerId 客户ID
     * @return 客户信息
     */
    @Override
	public Customer selectCustomerById(Long customerId)
	{
	    return customerMapper.selectCustomerById(customerId);
	}
	
	/**
     * 查询客户列表
     * 
     * @param customer 客户信息
     * @return 客户集合
     */
	@Override
	//@DataScope(tableAlias = "c")
	public List<Customer> selectCustomerList(Customer customer)
	{
	    return customerMapper.selectCustomerList(customer);
	}
	
    /**
     * 新增客户
     * 
     * @param customer 客户信息
     * @return 结果
     */
	@Override
	public int insertCustomer(Customer customer)
	{
	    return customerMapper.insertCustomer(customer);
	}
	
	/**
     * 修改客户
     * 
     * @param customer 客户信息
     * @return 结果
     */
	@Override
	public int updateCustomer(Customer customer)
	{
	    return customerMapper.updateCustomer(customer);
	}

	/**
     * 删除客户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCustomerByIds(String ids)
	{
		return customerMapper.deleteCustomerByIds(Convert.toStrArray(ids));
	}

	/**
	 * 查询客户管理树
	 *
	 * @param customer 客户信息
	 * @return 所有客户信息
	 */
	@Override
	//@DataScope(tableAlias = "c")
	public List<Ztree> selectCustomerTree(Customer customer){
		List<Customer> customerList = customerMapper.selectCustomerList(customer);
		List<Ztree> ztrees = initZtree(customerList);
		return ztrees;
	}

	/**
	 * 对象转用户树
	 *
	 * @param customerList 客户列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<Customer> customerList)
	{

		List<Ztree> ztrees = new ArrayList<Ztree>();
		for (Customer customer : customerList)
		{
			Ztree ztree = new Ztree();
			ztree.setId(customer.getCustomerId());
			ztree.setpId(0l);
			ztree.setName(customer.getName());
			ztree.setTitle(customer.getName());
			ztrees.add(ztree);
		}
		return ztrees;
	}

	/**
	 * 迁移客户
	 *
	 */
	@Override
	public int transferCustomerByIds(String userId,String userName, String ids){
		return customerMapper.transferCustomerByIds(userId,userName,ids.split(","));
	}

	@Override
	public String importCustomer(List<Customer> customerList, Boolean isUpdateSupport, User operUser){
		if (StringUtils.isNull(customerList) || customerList.size() == 0)
		{
			throw new BusinessException("导入用户数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		for (Customer customer : customerList)
		{
			try
			{
				customer.setDeptId(operUser.getDeptId());
				customer.setType("5");
				this.insertCustomer(customer);
				successNum++;
				successMsg.append("<br/>" + successNum + "、客户姓名： " + customer.getName() + " 导入成功");
			}
			catch (Exception e)
			{
				failureNum++;
				String msg = "<br/>" + failureNum + "、客户姓名： " + customer.getName() + " 导入失败：";
				failureMsg.append(msg + e.getMessage());
			}
		}
		if (failureNum > 0)
		{
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		}
		else
		{
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		return successMsg.toString();
	}
	
}
