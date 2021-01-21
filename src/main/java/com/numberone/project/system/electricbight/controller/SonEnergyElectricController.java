package com.numberone.project.system.electricbight.controller;

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
import com.numberone.project.system.electricbight.domain.SonEnergyElectric;
import com.numberone.project.system.electricbight.service.ISonEnergyElectricService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 子地区用电曲线图数据Controller
 * 
 * @author sqalong
 * @date 2021-01-13
 */
@Controller
@RequestMapping("/system/electricbight")
public class SonEnergyElectricController extends BaseController
{
    private String prefix = "system/electricbight";

    @Autowired
    private ISonEnergyElectricService sonEnergyElectricService;

    @RequiresPermissions("system:electricbight:view")
    @GetMapping()
    public String electricbight()
    {
        return prefix + "/electricbight";
    }

    /**
     * 查询子地区用电曲线图数据列表
     */
    @RequiresPermissions("system:electricbight:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SonEnergyElectric sonEnergyElectric)
    {
        startPage();
        List<SonEnergyElectric> list = sonEnergyElectricService.selectSonEnergyElectricList(sonEnergyElectric);
        return getDataTable(list);
    }

    /**
     * 导出子地区用电曲线图数据列表
     */
    @RequiresPermissions("system:electricbight:export")
    @Log(title = "子地区用电曲线图数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SonEnergyElectric sonEnergyElectric)
    {
        List<SonEnergyElectric> list = sonEnergyElectricService.selectSonEnergyElectricList(sonEnergyElectric);
        ExcelUtil<SonEnergyElectric> util = new ExcelUtil<SonEnergyElectric>(SonEnergyElectric.class);
        return util.exportExcel(list, "electricbight");
    }

    /**
     * 新增子地区用电曲线图数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存子地区用电曲线图数据
     */
    @RequiresPermissions("system:electricbight:add")
    @Log(title = "子地区用电曲线图数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SonEnergyElectric sonEnergyElectric)
    {
        return toAjax(sonEnergyElectricService.insertSonEnergyElectric(sonEnergyElectric));
    }

    /**
     * 修改子地区用电曲线图数据
     */
    @GetMapping("/edit/{pname}")
    public String edit(@PathVariable("pname") String pname, ModelMap mmap)
    {
        SonEnergyElectric sonEnergyElectric = sonEnergyElectricService.selectSonEnergyElectricById(pname);
        mmap.put("sonEnergyElectric", sonEnergyElectric);
        return prefix + "/edit";
    }

    /**
     * 修改保存子地区用电曲线图数据
     */
    @RequiresPermissions("system:electricbight:edit")
    @Log(title = "子地区用电曲线图数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SonEnergyElectric sonEnergyElectric)
    {
        return toAjax(sonEnergyElectricService.updateSonEnergyElectric(sonEnergyElectric));
    }

    /**
     * 删除子地区用电曲线图数据
     */
    @RequiresPermissions("system:electricbight:remove")
    @Log(title = "子地区用电曲线图数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sonEnergyElectricService.deleteSonEnergyElectricByIds(ids));
    }
}
