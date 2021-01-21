package com.numberone.project.system.cnwater.controller;

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
import com.numberone.project.system.cnwater.domain.EnergyContrastWater;
import com.numberone.project.system.cnwater.service.IEnergyContrastWaterService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 场院曲线数据--水表Controller
 * 
 * @author sqalong
 * @date 2021-01-13
 */
@Controller
@RequestMapping("/system/cnwater")
public class EnergyContrastWaterController extends BaseController
{
    private String prefix = "system/cnwater";

    @Autowired
    private IEnergyContrastWaterService energyContrastWaterService;

    @RequiresPermissions("system:cnwater:view")
    @GetMapping()
    public String cnwater()
    {
        return prefix + "/cnwater";
    }

    /**
     * 查询场院曲线数据--水表列表
     */
    @RequiresPermissions("system:cnwater:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EnergyContrastWater energyContrastWater)
    {
        startPage();
        List<EnergyContrastWater> list = energyContrastWaterService.selectEnergyContrastWaterList(energyContrastWater);
        return getDataTable(list);
    }

    /**
     * 导出场院曲线数据--水表列表
     */
    @RequiresPermissions("system:cnwater:export")
    @Log(title = "场院曲线数据--水表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EnergyContrastWater energyContrastWater)
    {
        List<EnergyContrastWater> list = energyContrastWaterService.selectEnergyContrastWaterList(energyContrastWater);
        ExcelUtil<EnergyContrastWater> util = new ExcelUtil<EnergyContrastWater>(EnergyContrastWater.class);
        return util.exportExcel(list, "cnwater");
    }

    /**
     * 新增场院曲线数据--水表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存场院曲线数据--水表
     */
    @RequiresPermissions("system:cnwater:add")
    @Log(title = "场院曲线数据--水表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EnergyContrastWater energyContrastWater)
    {
        return toAjax(energyContrastWaterService.insertEnergyContrastWater(energyContrastWater));
    }

    /**
     * 修改场院曲线数据--水表
     */
    @GetMapping("/edit/{region}")
    public String edit(@PathVariable("region") String region, ModelMap mmap)
    {
        EnergyContrastWater energyContrastWater = energyContrastWaterService.selectEnergyContrastWaterById(region);
        mmap.put("energyContrastWater", energyContrastWater);
        return prefix + "/edit";
    }

    /**
     * 修改保存场院曲线数据--水表
     */
    @RequiresPermissions("system:cnwater:edit")
    @Log(title = "场院曲线数据--水表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EnergyContrastWater energyContrastWater)
    {
        return toAjax(energyContrastWaterService.updateEnergyContrastWater(energyContrastWater));
    }

    /**
     * 删除场院曲线数据--水表
     */
    @RequiresPermissions("system:cnwater:remove")
    @Log(title = "场院曲线数据--水表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(energyContrastWaterService.deleteEnergyContrastWaterByIds(ids));
    }
}
