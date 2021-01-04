package com.numberone.project.system.punctuation.controller;

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
import com.numberone.project.system.punctuation.domain.MapPunctuation;
import com.numberone.project.system.punctuation.service.IMapPunctuationService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 地图驻点Controller
 * 
 * @author sqalong
 * @date 2021-01-04
 */
@Controller
@RequestMapping("/system/punctuation")
public class MapPunctuationController extends BaseController
{
    private String prefix = "system/punctuation";

    @Autowired
    private IMapPunctuationService mapPunctuationService;

    @RequiresPermissions("system:punctuation:view")
    @GetMapping()
    public String punctuation()
    {
        return prefix + "/punctuation";
    }

    /**
     * 查询地图驻点列表
     */
    @RequiresPermissions("system:punctuation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MapPunctuation mapPunctuation)
    {
        startPage();
        List<MapPunctuation> list = mapPunctuationService.selectMapPunctuationList(mapPunctuation);
        return getDataTable(list);
    }

    /**
     * 导出地图驻点列表
     */
    @RequiresPermissions("system:punctuation:export")
    @Log(title = "地图驻点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MapPunctuation mapPunctuation)
    {
        List<MapPunctuation> list = mapPunctuationService.selectMapPunctuationList(mapPunctuation);
        ExcelUtil<MapPunctuation> util = new ExcelUtil<MapPunctuation>(MapPunctuation.class);
        return util.exportExcel(list, "punctuation");
    }

    /**
     * 新增地图驻点
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存地图驻点
     */
    @RequiresPermissions("system:punctuation:add")
    @Log(title = "地图驻点", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MapPunctuation mapPunctuation)
    {
        return toAjax(mapPunctuationService.insertMapPunctuation(mapPunctuation));
    }

    /**
     * 修改地图驻点
     */
    @GetMapping("/edit/{name}")
    public String edit(@PathVariable("name") String name, ModelMap mmap)
    {
        MapPunctuation mapPunctuation = mapPunctuationService.selectMapPunctuationById(name);
        mmap.put("mapPunctuation", mapPunctuation);
        return prefix + "/edit";
    }

    /**
     * 修改保存地图驻点
     */
    @RequiresPermissions("system:punctuation:edit")
    @Log(title = "地图驻点", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MapPunctuation mapPunctuation)
    {
        return toAjax(mapPunctuationService.updateMapPunctuation(mapPunctuation));
    }

    /**
     * 删除地图驻点
     */
    @RequiresPermissions("system:punctuation:remove")
    @Log(title = "地图驻点", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mapPunctuationService.deleteMapPunctuationByIds(ids));
    }
}
