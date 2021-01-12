package com.numberone.project.system.areagas.controller;

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
import com.numberone.project.system.areagas.domain.Areagas;
import com.numberone.project.system.areagas.service.IAreagasService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.common.utils.StringUtils;
import com.numberone.framework.web.domain.Ztree;

/**
 * 子地区气表数据Controller
 * 
 * @author sqalong
 * @date 2021-01-12
 */
@Controller
@RequestMapping("/system/areagas")
public class AreagasController extends BaseController
{
    private String prefix = "system/areagas";

    @Autowired
    private IAreagasService areagasService;

    @RequiresPermissions("system:areagas:view")
    @GetMapping()
    public String areagas()
    {
        return prefix + "/areagas";
    }

    /**
     * 查询子地区气表数据树列表
     */
    @RequiresPermissions("system:areagas:list")
    @PostMapping("/list")
    @ResponseBody
    public List<Areagas> list(Areagas areagas)
    {
        List<Areagas> list = areagasService.selectAreagasList(areagas);
        return list;
    }

    /**
     * 导出子地区气表数据列表
     */
    @RequiresPermissions("system:areagas:export")
    @Log(title = "子地区气表数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Areagas areagas)
    {
        List<Areagas> list = areagasService.selectAreagasList(areagas);
        ExcelUtil<Areagas> util = new ExcelUtil<Areagas>(Areagas.class);
        return util.exportExcel(list, "areagas");
    }

    /**
     * 新增子地区气表数据
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("areagas", areagasService.selectAreagasById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存子地区气表数据
     */
    @RequiresPermissions("system:areagas:add")
    @Log(title = "子地区气表数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Areagas areagas)
    {
        return toAjax(areagasService.insertAreagas(areagas));
    }

    /**
     * 修改子地区气表数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Areagas areagas = areagasService.selectAreagasById(id);
        mmap.put("areagas", areagas);
        return prefix + "/edit";
    }

    /**
     * 修改保存子地区气表数据
     */
    @RequiresPermissions("system:areagas:edit")
    @Log(title = "子地区气表数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Areagas areagas)
    {
        return toAjax(areagasService.updateAreagas(areagas));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:areagas:remove")
    @Log(title = "子地区气表数据", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        return toAjax(areagasService.deleteAreagasById(id));
    }

    /**
     * 选择子地区气表数据树
     */
    @GetMapping(value = { "/selectAreagasTree/{id}", "/selectAreagasTree/" })
    public String selectAreagasTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("areagas", areagasService.selectAreagasById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载子地区气表数据树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = areagasService.selectAreagasTree();
        return ztrees;
    }
}
