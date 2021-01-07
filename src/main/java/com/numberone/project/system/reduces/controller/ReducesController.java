package com.numberone.project.system.reduces.controller;

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
import com.numberone.project.system.reduces.domain.Reduces;
import com.numberone.project.system.reduces.service.IReducesService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 减少排碳Controller
 * 
 * @author sqalong
 * @date 2021-01-07
 */
@Controller
@RequestMapping("/system/reduces")
public class ReducesController extends BaseController
{
    private String prefix = "system/reduces";

    @Autowired
    private IReducesService reducesService;

    @RequiresPermissions("system:reduces:view")
    @GetMapping()
    public String reduces()
    {
        return prefix + "/reduces";
    }

    /**
     * 查询减少排碳列表
     */
    @RequiresPermissions("system:reduces:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Reduces reduces)
    {
        startPage();
        List<Reduces> list = reducesService.selectReducesList(reduces);
        return getDataTable(list);
    }

    /**
     * 导出减少排碳列表
     */
    @RequiresPermissions("system:reduces:export")
    @Log(title = "减少排碳", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Reduces reduces)
    {
        List<Reduces> list = reducesService.selectReducesList(reduces);
        ExcelUtil<Reduces> util = new ExcelUtil<Reduces>(Reduces.class);
        return util.exportExcel(list, "reduces");
    }

    /**
     * 新增减少排碳
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存减少排碳
     */
    @RequiresPermissions("system:reduces:add")
    @Log(title = "减少排碳", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Reduces reduces)
    {
        return toAjax(reducesService.insertReduces(reduces));
    }

    /**
     * 修改减少排碳
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Reduces reduces = reducesService.selectReducesById(id);
        mmap.put("reduces", reduces);
        return prefix + "/edit";
    }

    /**
     * 修改保存减少排碳
     */
    @RequiresPermissions("system:reduces:edit")
    @Log(title = "减少排碳", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Reduces reduces)
    {
        return toAjax(reducesService.updateReduces(reduces));
    }

    /**
     * 删除减少排碳
     */
    @RequiresPermissions("system:reduces:remove")
    @Log(title = "减少排碳", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(reducesService.deleteReducesByIds(ids));
    }
}
