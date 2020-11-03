package com.numberone.project.system.energy.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.project.system.energy.domain.ProductEnergy;
import com.numberone.project.system.energy.service.IProductEnergyService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;



/**
 * 单位用能ManagerController
 * 
 * @author numberone
 * @date 2020-10-23
 */
@Controller
@RequestMapping("/system/energy")
public class ProductEnergyController extends BaseController
{
    private String prefix = "system/energy";

    @Autowired
    private IProductEnergyService productEnergyService;

    @RequestMapping("l")
    @ResponseBody
    public List<ProductEnergy> wori(Model model) {
    	ProductEnergy p = new ProductEnergy();
        List<ProductEnergy> list = productEnergyService.selectProductEnergyList(p);
        for(ProductEnergy q : list) {
        	System.out.println("弟弟"+q.getCapacity()+"山东省"+q.getProducEnergyCost());
        }
    	return list;
    }
    @RequestMapping("lll")
    public String ss(){
    	return "dd";
    }
    
    
    @RequiresPermissions("system:energy:view")
    @GetMapping()
    public String energy()
    {
        return prefix + "/energy";
    }

    /**
     * 查询单位用能Manager列表
     */
    @RequiresPermissions("system:energy:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductEnergy productEnergy)
    {
        startPage();
        List<ProductEnergy> list = productEnergyService.selectProductEnergyList(productEnergy);
        return getDataTable(list);
    }

    /**
     * 导出单位用能Manager列表
     */
    @RequiresPermissions("system:energy:export")
    @Log(title = "单位用能Manager", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductEnergy productEnergy)
    {
        List<ProductEnergy> list = productEnergyService.selectProductEnergyList(productEnergy);
        ExcelUtil<ProductEnergy> util = new ExcelUtil<ProductEnergy>(ProductEnergy.class);
        return util.exportExcel(list, "energy");
    }

    /**
     * 新增单位用能Manager
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存单位用能Manager
     */
    @RequiresPermissions("system:energy:add")
    @Log(title = "单位用能Manager", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProductEnergy productEnergy)
    {
        return toAjax(productEnergyService.insertProductEnergy(productEnergy));
    }

    /**
     * 修改单位用能Manager
     */
    @GetMapping("/edit/{productId}")
    public String edit(@PathVariable("productId") Long productId, ModelMap mmap)
    {
        ProductEnergy productEnergy = productEnergyService.selectProductEnergyById(productId);
        mmap.put("productEnergy", productEnergy);
        return prefix + "/edit";
    }

    /**
     * 修改保存单位用能Manager
     */
    @RequiresPermissions("system:energy:edit")
    @Log(title = "单位用能Manager", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductEnergy productEnergy)
    {
        return toAjax(productEnergyService.updateProductEnergy(productEnergy));
    }

    /**
     * 删除单位用能Manager
     */
    @RequiresPermissions("system:energy:remove")
    @Log(title = "单位用能Manager", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(productEnergyService.deleteProductEnergyByIds(ids));
    }
}
