package com.numberone.project.crm.order.service;

import com.numberone.project.crm.order.domain.Order;

import java.util.List;

/**
 * 订单 服务层
 * 
 * @author numberone专业开发
 * @date 2019-06-07
 */
public interface IOrderService 
{
	/**
     * 查询订单信息
     * 
     * @param orderId 订单ID
     * @return 订单信息
     */
	public Order selectOrderById(Long orderId);
	
	/**
     * 查询订单列表
     * 
     * @param order 订单信息
     * @return 订单集合
     */
	public List<Order> selectOrderList(Order order);
	
	/**
     * 新增订单
     * 
     * @param order 订单信息
     * @return 结果
     */
	public int insertOrder(Order order);
	
	/**
     * 修改订单
     * 
     * @param order 订单信息
     * @return 结果
     */
	public int updateOrder(Order order);
		
	/**
     * 删除订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrderByIds(String ids);

	/**
	 * 迁移订单
	 *
	 */
	public int transferOrderByIds(String userId, String userName, String ids);
	
}
