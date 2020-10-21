package com.numberone.project.crm.order.controller;

import com.numberone.common.utils.StringUtils;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.common.utils.security.ShiroUtils;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.crm.customer.domain.Customer;
import com.numberone.project.crm.customer.service.ICustomerService;
import com.numberone.project.crm.order.domain.Order;
import com.numberone.project.crm.order.service.IOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.numberone.common.utils.ServletUtils.getRequest;

/**
 * 订单 信息操作处理
 * 
 * @author numberone专业开发
 * @date 2019-06-07
 */
@Controller
@RequestMapping("/crm/order")
public class OrderController extends BaseController
{
    private String prefix = "crm/order";
	
	@Autowired
	private IOrderService orderService;

	@Autowired
	private ICustomerService customerService;
	
	@RequiresPermissions("system:order:view")
	@GetMapping()
	public String order()
	{
	    return prefix + "/order";
	}
	
	/**
	 * 查询订单列表
	 */
	@RequiresPermissions("system:order:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Order order)
	{
		startPage();
        List<Order> list = orderService.selectOrderList(order);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出订单列表
	 */
	@RequiresPermissions("system:order:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Order order)
    {
    	List<Order> list = orderService.selectOrderList(order);
        ExcelUtil<Order> util = new ExcelUtil<Order>(Order.class);
        return util.exportExcel(list, "order");
    }
	
	/**
	 * 新增订单
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		String customerId = getRequest().getParameter("customerId");
		if(StringUtils.isNotBlank(customerId)){
			Customer customer = customerService.selectCustomerById(Long.parseLong(customerId));
			mmap.put("customer",customer);
		}
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单
	 */
	@RequiresPermissions("system:order:add")
	@Log(title = "订单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Order order)
	{
		Customer customer = customerService.selectCustomerById(order.getCustomerId());
		if(customer != null){
			order.setPhone(customer.getPhone());
			order.setSex(customer.getSex());
			order.setIdCard(customer.getIdCard());
			order.setBirthday(customer.getBirthday());
		}
		order.setCreateBy(ShiroUtils.getLoginName());
		order.setUpdateBy(ShiroUtils.getUserId()+"");
		order.setStatus(Order.STATUS_SUBMIT);
		order.setDeptId(ShiroUtils.getSysUser().getDeptId());
		return toAjax(orderService.insertOrder(order));
	}

	/**
	 * 修改订单
	 */
	@GetMapping("/edit/{orderId}")
	public String edit(@PathVariable("orderId") Long orderId, ModelMap mmap)
	{
		Order order = orderService.selectOrderById(orderId);
		mmap.put("order", order);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单
	 */
	@RequiresPermissions("system:order:edit")
	@Log(title = "订单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Order order)
	{
		//order.setUpdateBy(ShiroUtils.getLoginName());
		Customer customer = customerService.selectCustomerById(order.getCustomerId());
		if(customer != null){
			order.setPhone(customer.getPhone());
			order.setSex(customer.getSex());
			order.setIdCard(customer.getIdCard());
			order.setBirthday(customer.getBirthday());
		}
		return toAjax(orderService.updateOrder(order));
	}
	
	/**
	 * 删除订单
	 */
	@RequiresPermissions("system:order:remove")
	@Log(title = "订单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		orderService.deleteOrderByIds(ids);
		return AjaxResult.success("删除成功");
	}

	/**
	 * 接单
	 */
	@RequiresPermissions("system:order:accept")
	@PostMapping("/acceptOrder")
	@ResponseBody
	public AjaxResult acceptOrder(String id)
	{
		Order order = orderService.selectOrderById(Long.parseLong(id));
		if(Order.STATUS_SUBMIT.equals(order.getStatus())){
			Order order_ = new Order();
			//order_.setUpdateBy(ShiroUtils.getLoginName());
			order_.setManagerId(ShiroUtils.getUserId());
			order_.setManagerName(ShiroUtils.getLoginName());
			order_.setManagerDeptId(ShiroUtils.getSysUser().getDeptId());
			order_.setOrderId(Long.parseLong(id));
			order_.setStatus(Order.STATUS_ACCEPT);
			orderService.updateOrder(order_);
			Customer customer = customerService.selectCustomerById(order.getCustomerId());
			if(customer != null){
				customer.setType("3");//接单客户
				customerService.updateCustomer(customer);
			}
			return AjaxResult.success("接单成功");
		}else{
			return AjaxResult.error("此订单已被接受，不能接单");
		}
	}

	/**
	 * 确认放款
	 */
	@RequiresPermissions("system:order:confirm")
	@PostMapping("/confirmFk")
	@ResponseBody
	public AjaxResult confirmFk(String orderId,String remark)
	{
		Order order = orderService.selectOrderById(Long.parseLong(orderId));
		if(Order.STATUS_ACCEPT.equals(order.getStatus())){
			Order order_ = new Order();
			//order_.setUpdateBy(ShiroUtils.getLoginName());
			order_.setOrderId(Long.parseLong(orderId));
			order_.setStatus(Order.STATUS_CONFIRM);
			order_.setRemark(remark);
			orderService.updateOrder(order_);
			Customer customer = customerService.selectCustomerById(order.getCustomerId());
			if(customer != null){
				customer.setType("7");//
				customerService.updateCustomer(customer);
			}
			return AjaxResult.success("确认放款成功");
		}else{
			return AjaxResult.error("此订单不是已接单状态，不能确认放款");
		}
	}

	/**
	 * 确认回款
	 */
	@RequiresPermissions("system:order:confirm")
	@PostMapping("/confirmHk")
	@ResponseBody
	public AjaxResult confirmHk(String orderId,String remark)
	{
		Order order = orderService.selectOrderById(Long.parseLong(orderId));
		if(Order.STATUS_CONFIRM.equals(order.getStatus())){
			Order order_ = new Order();
			//order_.setUpdateBy(ShiroUtils.getLoginName());
			order_.setOrderId(Long.parseLong(orderId));
			order_.setStatus(Order.STATUS_HK);
			order_.setRemark(remark);
			orderService.updateOrder(order_);
			Customer customer = customerService.selectCustomerById(order.getCustomerId());
			if(customer != null){
				customer.setType("4");//
				customerService.updateCustomer(customer);
			}
			return AjaxResult.success("确认回款成功");
		}else{
			return AjaxResult.error("此订单不是确认放款状态，不能确认回款");
		}
	}

	/**
	 * 拒绝订单
	 */
	@RequiresPermissions("system:order:refuse")
	@PostMapping("/refuse")
	@ResponseBody
	public AjaxResult refuse(String id)
	{
		Order order = orderService.selectOrderById(Long.parseLong(id));
		Order order_ = new Order();
		//order_.setUpdateBy(ShiroUtils.getLoginName());
		order_.setOrderId(Long.parseLong(id));
		order_.setStatus(Order.STATUS_REFUSE);
		orderService.updateOrder(order_);
		return AjaxResult.success("作废成功");
	}

	/**
	 * 跳转确认界面
	 */
	@GetMapping("/goConfirm")
	@RequiresPermissions("system:order:confirm")
	public String goConfirm(String id,String code, ModelMap mmap)
	{
		Order order = orderService.selectOrderById(Long.parseLong(id));
		String title = "";
		if("fk".equals(code)){
			title = "确认放款：";
		}else if("hk".equals(code)){
			title = "确认回款：";
		}
		mmap.put("order", order);
		mmap.put("code", code);
		mmap.put("title", title);
		return prefix + "/other";
	}

}
