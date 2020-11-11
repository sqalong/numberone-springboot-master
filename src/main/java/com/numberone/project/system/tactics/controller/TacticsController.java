package com.numberone.project.system.tactics.controller;

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
import com.numberone.project.system.tactics.domain.Tactics;
import com.numberone.project.system.tactics.service.ITacticsService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * tacticsController
 * 
 * @author numberone
 * @date 2020-11-11
 */
@Controller
@RequestMapping("/system/tactics")
public class TacticsController extends BaseController
{
    private String prefix = "system/tactics";

    @Autowired
    private ITacticsService tacticsService;

    @RequiresPermissions("system:tactics:view")
    @GetMapping()
    public String tactics()
    {
        return prefix + "/tactics";
    }

    /**
     * 查询tactics列表
     */
    @RequiresPermissions("system:tactics:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Tactics tactics)
    {
        startPage();
        List<Tactics> list = tacticsService.selectTacticsList(tactics);
        return getDataTable(list);
    }

    /**
     * 导出tactics列表
     */
    @RequiresPermissions("system:tactics:export")
    @Log(title = "tactics", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Tactics tactics)
    {
        List<Tactics> list = tacticsService.selectTacticsList(tactics);
        ExcelUtil<Tactics> util = new ExcelUtil<Tactics>(Tactics.class);
        return util.exportExcel(list, "tactics");
    }

    /**
     * 新增tactics
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存tactics
     */
    @RequiresPermissions("system:tactics:add")
    @Log(title = "tactics", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Tactics tactics)
    {
        return toAjax(tacticsService.insertTactics(tactics));
    }

    /**
     * 修改tactics
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Tactics tactics = tacticsService.selectTacticsById(id);
        mmap.put("tactics", tactics);
        return prefix + "/edit";
    }

    /**
     * 修改保存tactics
     */
    @RequiresPermissions("system:tactics:edit")
    @Log(title = "tactics", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Tactics tactics)
    {
        return toAjax(tacticsService.updateTactics(tactics));
    }

    /**
     * 删除tactics
     */
    @RequiresPermissions("system:tactics:remove")
    @Log(title = "tactics", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tacticsService.deleteTacticsByIds(ids));
    }
}
