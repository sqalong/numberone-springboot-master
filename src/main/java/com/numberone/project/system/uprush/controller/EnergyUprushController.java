package com.numberone.project.system.uprush.controller;

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
import com.numberone.project.system.uprush.domain.EnergyUprush;
import com.numberone.project.system.uprush.service.IEnergyUprushService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 模拟时间查询Controller
 * 
 * @author numberone
 * @date 2020-10-26
 */
@Controller
@RequestMapping("/system/uprush")
public class EnergyUprushController extends BaseController
{
    private String prefix = "system/uprush";

    @Autowired
    private IEnergyUprushService energyUprushService;
    @RequestMapping("lists")
    @ResponseBody
    public List<EnergyUprush> list(){
        EnergyUprush e = new EnergyUprush();
        List<EnergyUprush> list = energyUprushService.selectEnergyUprushList(e);
        return list;

    }

    @RequiresPermissions("system:uprush:view")
    @GetMapping()
    public String uprush()
    {
        return prefix + "/uprush";
    }

    /**
     * 查询模拟时间查询列表
     */
    @RequiresPermissions("system:uprush:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EnergyUprush energyUprush)
    {
        startPage();
        List<EnergyUprush> list = energyUprushService.selectEnergyUprushList(energyUprush);
        return getDataTable(list);
    }

    /**
     * 导出模拟时间查询列表
     */
    @RequiresPermissions("system:uprush:export")
    @Log(title = "模拟时间查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EnergyUprush energyUprush)
    {
        List<EnergyUprush> list = energyUprushService.selectEnergyUprushList(energyUprush);
        ExcelUtil<EnergyUprush> util = new ExcelUtil<EnergyUprush>(EnergyUprush.class);
        return util.exportExcel(list, "uprush");
    }

    /**
     * 新增模拟时间查询
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存模拟时间查询
     */
    @RequiresPermissions("system:uprush:add")
    @Log(title = "模拟时间查询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EnergyUprush energyUprush)
    {
        return toAjax(energyUprushService.insertEnergyUprush(energyUprush));
    }

    /**
     * 修改模拟时间查询
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        EnergyUprush energyUprush = energyUprushService.selectEnergyUprushById(id);
        mmap.put("energyUprush", energyUprush);
        return prefix + "/edit";
    }

    /**
     * 修改保存模拟时间查询
     */
    @RequiresPermissions("system:uprush:edit")
    @Log(title = "模拟时间查询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EnergyUprush energyUprush)
    {
        return toAjax(energyUprushService.updateEnergyUprush(energyUprush));
    }

    /**
     * 删除模拟时间查询
     */
    @RequiresPermissions("system:uprush:remove")
    @Log(title = "模拟时间查询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(energyUprushService.deleteEnergyUprushByIds(ids));
    }
}
