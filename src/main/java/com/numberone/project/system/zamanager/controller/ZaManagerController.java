package com.numberone.project.system.zamanager.controller;

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
import com.numberone.project.system.zamanager.domain.ZaManager;
import com.numberone.project.system.zamanager.service.IZaManagerService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 大屏展示数据Controller
 * 
 * @author sqalong
 * @date 2020-12-16
 */
@Controller
@RequestMapping("/system/zamanager")
public class ZaManagerController extends BaseController
{
    private String prefix = "system/zamanager";

    @Autowired
    private IZaManagerService zaManagerService;

    @RequiresPermissions("system:zamanager:view")
    @GetMapping()
    public String zamanager()
    {
        return prefix + "/zamanager";
    }

    /**
     * 查询大屏展示数据列表
     */
    @RequiresPermissions("system:zamanager:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ZaManager zaManager)
    {
        startPage();
        List<ZaManager> list = zaManagerService.selectZaManagerList(zaManager);
        return getDataTable(list);
    }

    /**
     * 导出大屏展示数据列表
     */
    @RequiresPermissions("system:zamanager:export")
    @Log(title = "大屏展示数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ZaManager zaManager)
    {
        List<ZaManager> list = zaManagerService.selectZaManagerList(zaManager);
        ExcelUtil<ZaManager> util = new ExcelUtil<ZaManager>(ZaManager.class);
        return util.exportExcel(list, "zamanager");
    }

    /**
     * 新增大屏展示数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存大屏展示数据
     */
    @RequiresPermissions("system:zamanager:add")
    @Log(title = "大屏展示数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ZaManager zaManager)
    {
        return toAjax(zaManagerService.insertZaManager(zaManager));
    }

    /**
     * 修改大屏展示数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ZaManager zaManager = zaManagerService.selectZaManagerById(id);
        mmap.put("zaManager", zaManager);
        return prefix + "/edit";
    }

    /**
     * 修改保存大屏展示数据
     */
    @RequiresPermissions("system:zamanager:edit")
    @Log(title = "大屏展示数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ZaManager zaManager)
    {
        return toAjax(zaManagerService.updateZaManager(zaManager));
    }

    /**
     * 删除大屏展示数据
     */
    @RequiresPermissions("system:zamanager:remove")
    @Log(title = "大屏展示数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(zaManagerService.deleteZaManagerByIds(ids));
    }
}
