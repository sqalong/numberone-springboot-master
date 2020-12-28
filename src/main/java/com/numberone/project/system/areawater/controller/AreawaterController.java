package com.numberone.project.system.areawater.controller;

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
import com.numberone.project.system.areawater.domain.Areawater;
import com.numberone.project.system.areawater.service.IAreawaterService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * areawaterController
 * 
 * @author sqalong
 * @date 2020-12-28
 */
@Controller
@RequestMapping("/system/areawater")
public class AreawaterController extends BaseController
{
    private String prefix = "system/areawater";

    @Autowired
    private IAreawaterService areawaterService;

    @RequiresPermissions("system:areawater:view")
    @GetMapping()
    public String areawater()
    {
        return prefix + "/areawater";
    }

    /**
     * 查询areawater列表
     */
    @RequiresPermissions("system:areawater:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Areawater areawater)
    {
        startPage();
        List<Areawater> list = areawaterService.selectAreawaterList(areawater);
        return getDataTable(list);
    }

    /**
     * 导出areawater列表
     */
    @RequiresPermissions("system:areawater:export")
    @Log(title = "areawater", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Areawater areawater)
    {
        List<Areawater> list = areawaterService.selectAreawaterList(areawater);
        ExcelUtil<Areawater> util = new ExcelUtil<Areawater>(Areawater.class);
        return util.exportExcel(list, "areawater");
    }

    /**
     * 新增areawater
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存areawater
     */
    @RequiresPermissions("system:areawater:add")
    @Log(title = "areawater", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Areawater areawater)
    {
        return toAjax(areawaterService.insertAreawater(areawater));
    }

    /**
     * 修改areawater
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Areawater areawater = areawaterService.selectAreawaterById(id);
        mmap.put("areawater", areawater);
        return prefix + "/edit";
    }

    /**
     * 修改保存areawater
     */
    @RequiresPermissions("system:areawater:edit")
    @Log(title = "areawater", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Areawater areawater)
    {
        return toAjax(areawaterService.updateAreawater(areawater));
    }

    /**
     * 删除areawater
     */
    @RequiresPermissions("system:areawater:remove")
    @Log(title = "areawater", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(areawaterService.deleteAreawaterByIds(ids));
    }
}
