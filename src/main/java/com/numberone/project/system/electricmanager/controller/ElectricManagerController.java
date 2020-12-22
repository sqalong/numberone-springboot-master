package com.numberone.project.system.electricmanager.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.project.system.electricmanager.domain.ElectricManager;
import com.numberone.project.system.electricmanager.service.IElectricManagerService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * electricmanagerController
 * 
 * @author sqalong
 * @date 2020-12-21
 */
@Controller
@RequestMapping("/system/electricmanager")
public class ElectricManagerController extends BaseController
{
    private String prefix = "system/electricmanager";

    @Autowired
    private IElectricManagerService electricManagerService;

    @RequiresPermissions("system:electricmanager:view")
    @GetMapping()
    public String electricmanager()
    {
        return prefix + "/electricmanager";
    }

    /**
     * 查询electricmanager列表
     */
    @RequiresPermissions("system:electricmanager:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ElectricManager electricManager)
    {
        startPage();
        List<ElectricManager> list = electricManagerService.selectElectricManagerList(electricManager);
        return getDataTable(list);
    }

    /**
     * 导出electricmanager列表
     */
    @RequiresPermissions("system:electricmanager:export")
    @Log(title = "electricmanager", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ElectricManager electricManager)
    {
        List<ElectricManager> list = electricManagerService.selectElectricManagerList(electricManager);
        ExcelUtil<ElectricManager> util = new ExcelUtil<ElectricManager>(ElectricManager.class);
        return util.exportExcel(list, "electricmanager");
    }

    /**
     * 新增electricmanager
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存electricmanager
     */
    @RequiresPermissions("system:electricmanager:add")
    @Log(title = "electricmanager", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ElectricManager electricManager)
    {
        return toAjax(electricManagerService.insertElectricManager(electricManager));
    }

    /**
     * 修改electricmanager
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ElectricManager electricManager = electricManagerService.selectElectricManagerById(id);
        mmap.put("electricManager", electricManager);
        return prefix + "/edit";
    }

    /**
     * 修改保存electricmanager
     */
    @RequiresPermissions("system:electricmanager:edit")
    @Log(title = "electricmanager", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ElectricManager electricManager)
    {
        return toAjax(electricManagerService.updateElectricManager(electricManager));
    }

    /**
     * 删除electricmanager
     */
    @RequiresPermissions("system:electricmanager:remove")
    @Log(title = "electricmanager", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(electricManagerService.deleteElectricManagerByIds(ids));
    }
}
