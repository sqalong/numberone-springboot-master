package com.numberone.project.system.plate.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.project.system.plate.domain.ExpectedPlate;
import com.numberone.project.system.plate.service.IExpectedPlateService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.common.utils.StringUtils;
import com.numberone.framework.web.domain.Ztree;

/**
 * 子地区小版块数据后台Controller
 * 
 * @author sqalong
 * @date 2021-01-12
 */
@Controller
@RequestMapping("/system/plate")
public class ExpectedPlateController extends BaseController
{
    private String prefix = "system/plate";

    @Autowired
    private IExpectedPlateService expectedPlateService;

    @RequiresPermissions("system:plate:view")
    @GetMapping()
    public String plate()
    {
        return prefix + "/plate";
    }

    /**
     * 查询子地区小版块数据后台树列表
     */
    @RequiresPermissions("system:plate:list")
    @PostMapping("/list")
    @ResponseBody
    public List<ExpectedPlate> list(ExpectedPlate expectedPlate)
    {
        List<ExpectedPlate> list = expectedPlateService.selectExpectedPlateList(expectedPlate);
        return list;
    }





    /**
     * 导出子地区小版块数据后台列表
     */
    @RequiresPermissions("system:plate:export")
    @Log(title = "子地区小版块数据后台", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ExpectedPlate expectedPlate)
    {
        List<ExpectedPlate> list = expectedPlateService.selectExpectedPlateList(expectedPlate);
        ExcelUtil<ExpectedPlate> util = new ExcelUtil<ExpectedPlate>(ExpectedPlate.class);
        return util.exportExcel(list, "plate");
    }

    /**
     * 新增子地区小版块数据后台
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("expectedPlate", expectedPlateService.selectExpectedPlateById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存子地区小版块数据后台
     */
    @RequiresPermissions("system:plate:add")
    @Log(title = "子地区小版块数据后台", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ExpectedPlate expectedPlate)
    {
        return toAjax(expectedPlateService.insertExpectedPlate(expectedPlate));
    }

    /**
     * 修改子地区小版块数据后台
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ExpectedPlate expectedPlate = expectedPlateService.selectExpectedPlateById(id);
        mmap.put("expectedPlate", expectedPlate);
        return prefix + "/edit";
    }

    /**
     * 修改保存子地区小版块数据后台
     */
    @RequiresPermissions("system:plate:edit")
    @Log(title = "子地区小版块数据后台", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ExpectedPlate expectedPlate)
    {
        return toAjax(expectedPlateService.updateExpectedPlate(expectedPlate));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:plate:remove")
    @Log(title = "子地区小版块数据后台", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        return toAjax(expectedPlateService.deleteExpectedPlateById(id));
    }

    /**
     * 选择子地区小版块数据后台树
     */
    @GetMapping(value = { "/selectPlateTree/{id}", "/selectPlateTree/" })
    public String selectPlateTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("expectedPlate", expectedPlateService.selectExpectedPlateById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载子地区小版块数据后台树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = expectedPlateService.selectExpectedPlateTree();
        return ztrees;
    }

    /**
     * 查询子地区小版块数据后台树列表
     */
    @GetMapping("/lists")
    @ResponseBody
    public List<ExpectedPlate> lists(@RequestParam("largeareaname") String largeareaname)
    {
        List<ExpectedPlate> list = expectedPlateService.selectExpectedPlateLists(largeareaname);
        return list;
    }
}
