package com.numberone.project.system.watermanager.controller;

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
import com.numberone.project.system.watermanager.domain.WaterManager;
import com.numberone.project.system.watermanager.service.IWaterManagerService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * watermanagerController
 * 
 * @author sqalong
 * @date 2020-12-17
 */
@Controller
@RequestMapping("/system/watermanager")
public class WaterManagerController extends BaseController
{
    private String prefix = "system/watermanager";

    @Autowired
    private IWaterManagerService waterManagerService;

    @RequiresPermissions("system:watermanager:view")
    @GetMapping()
    public String watermanager()
    {
        return prefix + "/watermanager";
    }

    /**
     * 查询watermanager列表
     */
    @RequiresPermissions("system:watermanager:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WaterManager waterManager)
    {
        startPage();
        List<WaterManager> list = waterManagerService.selectWaterManagerList(waterManager);
        return getDataTable(list);
    }

    /**
     * 导出watermanager列表
     */
    @RequiresPermissions("system:watermanager:export")
    @Log(title = "watermanager", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WaterManager waterManager)
    {
        List<WaterManager> list = waterManagerService.selectWaterManagerList(waterManager);
        ExcelUtil<WaterManager> util = new ExcelUtil<WaterManager>(WaterManager.class);
        return util.exportExcel(list, "watermanager");
    }

    /**
     * 新增watermanager
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存watermanager
     */
    @RequiresPermissions("system:watermanager:add")
    @Log(title = "watermanager", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WaterManager waterManager)
    {
        return toAjax(waterManagerService.insertWaterManager(waterManager));
    }

    /**
     * 修改watermanager
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WaterManager waterManager = waterManagerService.selectWaterManagerById(id);
        mmap.put("waterManager", waterManager);
        return prefix + "/edit";
    }

    /**
     * 修改保存watermanager
     */
    @RequiresPermissions("system:watermanager:edit")
    @Log(title = "watermanager", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WaterManager waterManager)
    {
        return toAjax(waterManagerService.updateWaterManager(waterManager));
    }

    /**
     * 删除watermanager
     */
    @RequiresPermissions("system:watermanager:remove")
    @Log(title = "watermanager", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(waterManagerService.deleteWaterManagerByIds(ids));
    }
}
