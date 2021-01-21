package com.numberone.project.system.cngas.controller;

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
import com.numberone.project.system.cngas.domain.EnergyContrastGas;
import com.numberone.project.system.cngas.service.IEnergyContrastGasService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 场院曲线数据--气表Controller
 * 
 * @author sqalong
 * @date 2021-01-13
 */
@Controller
@RequestMapping("/system/cngas")
public class EnergyContrastGasController extends BaseController
{
    private String prefix = "system/cngas";

    @Autowired
    private IEnergyContrastGasService energyContrastGasService;

    @RequiresPermissions("system:cngas:view")
    @GetMapping()
    public String cngas()
    {
        return prefix + "/cngas";
    }

    /**
     * 查询场院曲线数据--气表列表
     */
    @RequiresPermissions("system:cngas:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EnergyContrastGas energyContrastGas)
    {
        startPage();
        List<EnergyContrastGas> list = energyContrastGasService.selectEnergyContrastGasList(energyContrastGas);
        return getDataTable(list);
    }

    /**
     * 导出场院曲线数据--气表列表
     */
    @RequiresPermissions("system:cngas:export")
    @Log(title = "场院曲线数据--气表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(EnergyContrastGas energyContrastGas)
    {
        List<EnergyContrastGas> list = energyContrastGasService.selectEnergyContrastGasList(energyContrastGas);
        ExcelUtil<EnergyContrastGas> util = new ExcelUtil<EnergyContrastGas>(EnergyContrastGas.class);
        return util.exportExcel(list, "cngas");
    }

    /**
     * 新增场院曲线数据--气表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存场院曲线数据--气表
     */
    @RequiresPermissions("system:cngas:add")
    @Log(title = "场院曲线数据--气表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EnergyContrastGas energyContrastGas)
    {
        return toAjax(energyContrastGasService.insertEnergyContrastGas(energyContrastGas));
    }

    /**
     * 修改场院曲线数据--气表
     */
    @GetMapping("/edit/{region}")
    public String edit(@PathVariable("region") String region, ModelMap mmap)
    {
        EnergyContrastGas energyContrastGas = energyContrastGasService.selectEnergyContrastGasById(region);
        mmap.put("energyContrastGas", energyContrastGas);
        return prefix + "/edit";
    }

    /**
     * 修改保存场院曲线数据--气表
     */
    @RequiresPermissions("system:cngas:edit")
    @Log(title = "场院曲线数据--气表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EnergyContrastGas energyContrastGas)
    {
        return toAjax(energyContrastGasService.updateEnergyContrastGas(energyContrastGas));
    }

    /**
     * 删除场院曲线数据--气表
     */
    @RequiresPermissions("system:cngas:remove")
    @Log(title = "场院曲线数据--气表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(energyContrastGasService.deleteEnergyContrastGasByIds(ids));
    }
}
