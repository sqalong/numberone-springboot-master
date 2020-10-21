package com.numberone.project.crm.customer.controller;

import com.numberone.common.utils.StringUtils;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.common.utils.security.ShiroUtils;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.domain.Ztree;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.crm.customer.domain.Customer;
import com.numberone.project.crm.customer.service.ICustomerService;
import com.numberone.project.crm.order.service.IOrderService;
import com.numberone.project.system.dict.service.IDictDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

import static com.numberone.common.utils.ServletUtils.getRequest;

/**
 * 客户 信息操作处理
 * 
 * @author numberone专业开发
 * @date 2019-06-05
 */
@Controller
@RequestMapping("/crm/customer")
public class CustomerController extends BaseController
{
    private String prefix = "crm/customer";
	
	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IDictDataService dictDataService;

	@Autowired
	private IOrderService orderService;
	
	@RequiresPermissions("system:customer:view")
	@GetMapping()
	public String customer(ModelMap mmap)
	{
		//是否只显示自己的客户
		String isOwn = getRequest().getParameter("isOwn");
		mmap.put("isOwn",isOwn);
	    return prefix + "/customer";
	}
	
	/**
	 * 查询客户列表
	 */
	@RequiresPermissions("system:customer:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Customer customer)
	{
		String searchOption = getRequest().getParameter("searchOption");
		System.out.println("searchOption:"+searchOption);
		if("0".equals(searchOption)){
			customer.setCustomerSql("fc");
		}else if("1".equals(searchOption)){
			customer.setCustomerSql("car");
		}else if("2".equals(searchOption)){
			customer.setCustomerSql("credit_card");
		}else if("3".equals(searchOption)){
			customer.setCustomerSql("bx");
		}
		//是否只显示自己的客户
		String isOwn = getRequest().getParameter("isOwn");
		if(StringUtils.isNotBlank(isOwn) && "1".equals(isOwn)){
			customer.setCreateBy(ShiroUtils.getLoginName());
		}
		System.out.println("isOwn:"+isOwn);
        List<Customer> list = customerService.selectCustomerList(customer);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出客户列表
	 */
	@RequiresPermissions("system:customer:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Customer customer)
    {
    	List<Customer> list = customerService.selectCustomerList(customer);
        ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
        return util.exportExcel(list, "customer");
    }
	
	/**
	 * 新增客户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存客户
	 */
	@RequiresPermissions("system:customer:add")
	@Log(title = "客户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Customer customer)
	{
		customer.setCreateBy(ShiroUtils.getLoginName());
		customer.setUpdateBy(ShiroUtils.getUserId()+"");
		customer.setDeptId(ShiroUtils.getSysUser().getDeptId());
		return toAjax(customerService.insertCustomer(customer));
	}

	/**
	 * 修改客户
	 */
	@GetMapping("/edit/{customerId}")
	public String edit(@PathVariable("customerId") Long customerId, ModelMap mmap)
	{
		Customer customer = customerService.selectCustomerById(customerId);
		mmap.put("customer", customer);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存客户
	 */
	@RequiresPermissions("system:customer:edit")
	@Log(title = "客户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Customer customer)
	{
		//customer.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(customerService.updateCustomer(customer));
	}
	
	/**
	 * 删除客户至公海
	 */
	@RequiresPermissions("system:customer:gh")
	@PostMapping( "/toGh")
	@ResponseBody
	public AjaxResult toGh(String id)
	{
		Customer customer = new Customer();
		customer.setCustomerId(Long.parseLong(id));
		customer.setType("6");//公海
		return toAjax(customerService.updateCustomer(customer));
	}

	/**
	 * 删除客户
	 */
	@RequiresPermissions("system:customer:remove")
	@Log(title = "客户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		customerService.deleteCustomerByIds(ids);
		return AjaxResult.success("删除成功");
	}

	/**
	 * 编辑客户资产信息
	 */
	@GetMapping("/updateZc")
	@RequiresPermissions("system:customer:edit")
	public String updateZc(String customerId,String code, ModelMap mmap)
	{
		Customer customer = customerService.selectCustomerById(Long.parseLong(customerId));
		String content = "";
		String title = "";
		if("fc".equals(code)){
			content = customer.getFc();
			title = "房产：";
		}else if("cc".equals(code)){
			content = customer.getCar();
			title = "车产：";
		}else if("gjj".equals(code)){
			content = customer.getCreditCard();
			title = "公积金：";
		}else if("bd".equals(code)){
			content = customer.getBx();
			title = "保单：";
		}else if("follow".equals(code)){
			content = customer.getFollow();
			title = "跟进：";
		}
		mmap.put("customer", customer);
		mmap.put("code", code);
		mmap.put("content", content);
		mmap.put("title", title);
		return prefix + "/other";
	}

	/**
	 * 保存客户资产信息
	 */
	@RequiresPermissions("system:customer:edit")
	@PostMapping("/doUpdateZc")
	@ResponseBody
	public AjaxResult doUpdateZc(Customer customer,String code,String content)
	{
		if("fc".equals(code)){
			customer.setFc(content);
		}else if("cc".equals(code)){
			customer.setCar(content);
		}else if("gjj".equals(code)){
			customer.setCreditCard(content);
		}else if("bd".equals(code)){
			customer.setBx(content);
		}else if("follow".equals(code)){
			customer.setFollow(content);
			customer.setFollowTime(new Date());
		}
		return toAjax(customerService.updateCustomer(customer));
	}

	/**
	 * 查看客户详情
	 */
	@GetMapping("/detail/{customerId}")
	public String detail(@PathVariable("customerId") Long customerId, ModelMap mmap)
	{
		Customer customer = customerService.selectCustomerById(customerId);
		if(StringUtils.isNotBlank(customer.getSex())){
			String sex = dictDataService.selectDictLabel("sys_user_sex",customer.getSex());
			mmap.put("sex",sex);
		}
		if(StringUtils.isNotBlank(customer.getQualification())){
			String qualification = dictDataService.selectDictLabel("qualification",customer.getQualification());
			mmap.put("qualification",qualification);
		}
		if(StringUtils.isNotBlank(customer.getMarriage())){
			String marriage = dictDataService.selectDictLabel("marriage",customer.getMarriage());
			mmap.put("marriage",marriage);
		}
		if(StringUtils.isNotBlank(customer.getType())){
			String customerType = dictDataService.selectDictLabel("customerType",customer.getType());
			mmap.put("customerType",customerType);
		}
		if(StringUtils.isNotBlank(customer.getLevel())){
			String customerLevel = dictDataService.selectDictLabel("customerLevel",customer.getLevel());
			mmap.put("customerLevel",customerLevel);
		}
		if(StringUtils.isNotBlank(customer.getStatus2())){
			String customerType2 = dictDataService.selectDictLabel("customerType2",customer.getStatus2());
			mmap.put("customerType2",customerType2);
		}
		if(StringUtils.isNotBlank(customer.getSource())){
			String customerSource = dictDataService.selectDictLabel("customerSource",customer.getSource());
			mmap.put("customerSource",customerSource);
		}
		mmap.put("customer", customer);
		return prefix + "/detail";
	}

	/**
	 * 选择客户树
	 */
	@GetMapping("/selectCustomerTree")
	public String selectCustomerTree()
	{
		return prefix + "/tree";
	}

	/**
	 * 加载客户列表树
	 */
	@GetMapping("/treeData")
	@ResponseBody
	public List<Ztree> treeData()
	{
		List<Ztree> ztrees = customerService.selectCustomerTree(new Customer());
		return ztrees;
	}

	/**
	 * 迁移客户
	 */
	@RequiresPermissions("system:customer:transfer")
	@GetMapping("/goTransfer")
	public String goTransfer(ModelMap mmap)
	{
		String ids = getRequest().getParameter("ids");
		mmap.put("ids",ids);
		return prefix + "/transfer";
	}

	/**
	 * 迁移客户
	 */
	@RequiresPermissions("system:customer:transfer")
	@PostMapping( "/transfer")
	@ResponseBody
	public AjaxResult transfer(String ids,String userId,String userName)
	{
		System.out.println("ids:"+ids+" userId:"+userId + " userName:"+userName);
		if(StringUtils.isNotBlank(ids) && StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(userName)){
			customerService.transferCustomerByIds(userId, userName, ids);
			orderService.transferOrderByIds(userId, userName, ids);
			return AjaxResult.success("迁移成功");
		}
		return AjaxResult.success("迁移失败：参数不全");
	}

	@RequiresPermissions("system:customer:view")
	@GetMapping("/importTemplate")
	@ResponseBody
	public AjaxResult importTemplate()
	{
		ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
		return util.importTemplateExcel("客户数据");
	}

	@RequiresPermissions("system:customer:import")
	@PostMapping("/importData")
	@ResponseBody
	public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
	{
		ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
		List<Customer> customerList = util.importExcel(file.getInputStream());
		String message = customerService.importCustomer(customerList, updateSupport, ShiroUtils.getSysUser());
		return AjaxResult.success(message);
	}
	
}
