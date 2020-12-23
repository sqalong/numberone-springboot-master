package com.numberone.project.system.gasmanager.controller;

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
import com.numberone.project.system.gasmanager.domain.GasManager;
import com.numberone.project.system.gasmanager.service.IGasManagerService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * gasmanagerController
 * 
 * @author sqalong
 * @date 2020-12-23
 */
@Controller
@RequestMapping("/system/gasmanager")
public class GasManagerController extends BaseController
{
    private String prefix = "system/gasmanager";

    @Autowired
    private IGasManagerService gasManagerService;

    @RequiresPermissions("system:gasmanager:view")
    @GetMapping()
    public String gasmanager()
    {
        return prefix + "/gasmanager";
    }

    /**
     * 查询gasmanager列表
     */
    @RequiresPermissions("system:gasmanager:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GasManager gasManager)
    {
        startPage();
        List<GasManager> list = gasManagerService.selectGasManagerList(gasManager);
        return getDataTable(list);
    }

    /**
     * 导出gasmanager列表
     */
    @RequiresPermissions("system:gasmanager:export")
    @Log(title = "gasmanager", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GasManager gasManager)
    {
        List<GasManager> list = gasManagerService.selectGasManagerList(gasManager);
        ExcelUtil<GasManager> util = new ExcelUtil<GasManager>(GasManager.class);
        return util.exportExcel(list, "gasmanager");
    }

    /**
     * 新增gasmanager
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存gasmanager
     */
    @RequiresPermissions("system:gasmanager:add")
    @Log(title = "gasmanager", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GasManager gasManager)
    {
        return toAjax(gasManagerService.insertGasManager(gasManager));
    }

    /**
     * 修改gasmanager
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GasManager gasManager = gasManagerService.selectGasManagerById(id);
        mmap.put("gasManager", gasManager);
        return prefix + "/edit";
    }

    /**
     * 修改保存gasmanager
     */
    @RequiresPermissions("system:gasmanager:edit")
    @Log(title = "gasmanager", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GasManager gasManager)
    {
        return toAjax(gasManagerService.updateGasManager(gasManager));
    }

    /**
     * 删除gasmanager
     */
    @RequiresPermissions("system:gasmanager:remove")
    @Log(title = "gasmanager", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gasManagerService.deleteGasManagerByIds(ids));
    }
}
