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
import com.numberone.common.utils.StringUtils;
import com.numberone.framework.web.domain.Ztree;

/**
 * 子地区水表数据Controller
 * 
 * @author sqalong
 * @date 2021-01-12
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
     * 查询子地区水表数据树列表
     */
    @RequiresPermissions("system:areawater:list")
    @PostMapping("/list")
    @ResponseBody
    public List<Areawater> list(Areawater areawater)
    {
        List<Areawater> list = areawaterService.selectAreawaterList(areawater);
        return list;
    }

    /**
     * 导出子地区水表数据列表
     */
    @RequiresPermissions("system:areawater:export")
    @Log(title = "子地区水表数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Areawater areawater)
    {
        List<Areawater> list = areawaterService.selectAreawaterList(areawater);
        ExcelUtil<Areawater> util = new ExcelUtil<Areawater>(Areawater.class);
        return util.exportExcel(list, "areawater");
    }

    /**
     * 新增子地区水表数据
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("areawater", areawaterService.selectAreawaterById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存子地区水表数据
     */
    @RequiresPermissions("system:areawater:add")
    @Log(title = "子地区水表数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Areawater areawater)
    {
        return toAjax(areawaterService.insertAreawater(areawater));
    }

    /**
     * 修改子地区水表数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Areawater areawater = areawaterService.selectAreawaterById(id);
        mmap.put("areawater", areawater);
        return prefix + "/edit";
    }

    /**
     * 修改保存子地区水表数据
     */
    @RequiresPermissions("system:areawater:edit")
    @Log(title = "子地区水表数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Areawater areawater)
    {
        return toAjax(areawaterService.updateAreawater(areawater));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:areawater:remove")
    @Log(title = "子地区水表数据", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        return toAjax(areawaterService.deleteAreawaterById(id));
    }

    /**
     * 选择子地区水表数据树
     */
    @GetMapping(value = { "/selectAreawaterTree/{id}", "/selectAreawaterTree/" })
    public String selectAreawaterTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("areawater", areawaterService.selectAreawaterById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载子地区水表数据树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = areawaterService.selectAreawaterTree();
        return ztrees;
    }
}
