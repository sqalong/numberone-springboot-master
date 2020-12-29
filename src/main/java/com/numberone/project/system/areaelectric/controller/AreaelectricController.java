package com.numberone.project.system.areaelectric.controller;

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
import com.numberone.project.system.areaelectric.domain.Areaelectric;
import com.numberone.project.system.areaelectric.service.IAreaelectricService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.common.utils.StringUtils;
import com.numberone.framework.web.domain.Ztree;

/**
 * areaelectricController
 * 
 * @author sqalong
 * @date 2020-12-29
 */
@Controller
@RequestMapping("/system/areaelectric")
public class AreaelectricController extends BaseController
{
    private String prefix = "system/areaelectric";

    @Autowired
    private IAreaelectricService areaelectricService;

    @RequiresPermissions("system:areaelectric:view")
    @GetMapping()
    public String areaelectric()
    {
        return prefix + "/areaelectric";
    }

    /**
     * 查询areaelectric树列表
     */
    @RequiresPermissions("system:areaelectric:list")
    @PostMapping("/list")
    @ResponseBody
    public List<Areaelectric> list(Areaelectric areaelectric)
    {
        List<Areaelectric> list = areaelectricService.selectAreaelectricList(areaelectric);
        return list;
    }

    /**
     * 导出areaelectric列表
     */
    @RequiresPermissions("system:areaelectric:export")
    @Log(title = "areaelectric", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Areaelectric areaelectric)
    {
        List<Areaelectric> list = areaelectricService.selectAreaelectricList(areaelectric);
        ExcelUtil<Areaelectric> util = new ExcelUtil<Areaelectric>(Areaelectric.class);
        return util.exportExcel(list, "areaelectric");
    }

    /**
     * 新增areaelectric
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("areaelectric", areaelectricService.selectAreaelectricById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存areaelectric
     */
    @RequiresPermissions("system:areaelectric:add")
    @Log(title = "areaelectric", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Areaelectric areaelectric)
    {
        return toAjax(areaelectricService.insertAreaelectric(areaelectric));
    }

    /**
     * 修改areaelectric
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Areaelectric areaelectric = areaelectricService.selectAreaelectricById(id);
        mmap.put("areaelectric", areaelectric);
        return prefix + "/edit";
    }

    /**
     * 修改保存areaelectric
     */
    @RequiresPermissions("system:areaelectric:edit")
    @Log(title = "areaelectric", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Areaelectric areaelectric)
    {
        return toAjax(areaelectricService.updateAreaelectric(areaelectric));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:areaelectric:remove")
    @Log(title = "areaelectric", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        return toAjax(areaelectricService.deleteAreaelectricById(id));
    }

    /**
     * 选择areaelectric树
     */
    @GetMapping(value = { "/selectAreaelectricTree/{id}", "/selectAreaelectricTree/" })
    public String selectAreaelectricTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("areaelectric", areaelectricService.selectAreaelectricById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载areaelectric树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = areaelectricService.selectAreaelectricTree();
        return ztrees;
    }
}
