package com.numberone.project.crm.order.mapper;

import com.numberone.project.crm.order.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单 数据层
 * 
 * @author numberone专业开发
 * @date 2019-06-07
 */
public interface OrderMapper 
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
     * 删除订单
     * 
     * @param orderId 订单ID
     * @return 结果
     */
	public int deleteOrderById(Long orderId);
	
	/**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrderByIds(String[] orderIds);

	/**
	 * 迁移订单
	 *
	 */
	public int transferOrderByIds(@Param("userId") String userId, @Param("userName") String userName, @Param("customerIds") String[] customerIds);
	
}