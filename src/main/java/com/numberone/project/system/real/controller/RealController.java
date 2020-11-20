package com.numberone.project.system.real.controller;

import java.util.List;

import com.numberone.project.system.real.domain.Treee;
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
import com.numberone.project.system.real.domain.Real;
import com.numberone.project.system.real.service.IRealService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 实时遥测曲线Controller
 * 
 * @author numberone
 * @date 2020-10-26
 */
@Controller
@RequestMapping("/system/real")
public class RealController extends BaseController
{
    private String prefix = "system/real";

    @Autowired
    private IRealService realService;


    @RequestMapping("lists")
    @ResponseBody
    public List<Real> lists(){
        Real r = new Real();
        List<Real> list = realService.selectRealList(r);
        return list;
    }

    @RequiresPermissions("system:real:view")
    @GetMapping()
    public String real()
    {
        return prefix + "/real";
    }

    /**
     * 查询实时遥测曲线列表
     */
    @RequiresPermissions("system:real:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Real real)
    {
        startPage();
        List<Real> list = realService.selectRealList(real);
        return getDataTable(list);
    }

    /**
     * 导出实时遥测曲线列表
     */
    @RequiresPermissions("system:real:export")
    @Log(title = "实时遥测曲线", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Real real)
    {
        List<Real> list = realService.selectRealList(real);
        ExcelUtil<Real> util = new ExcelUtil<Real>(Real.class);
        return util.exportExcel(list, "real");
    }

    /**
     * 新增实时遥测曲线
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存实时遥测曲线
     */
    @RequiresPermissions("system:real:add")
    @Log(title = "实时遥测曲线", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Real real)
    {
        return toAjax(realService.insertReal(real));
    }

    /**
     * 修改实时遥测曲线
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Real real = realService.selectRealById(id);
        mmap.put("real", real);
        return prefix + "/edit";
    }

    /**
     * 修改保存实时遥测曲线
     */
    @RequiresPermissions("system:real:edit")
    @Log(title = "实时遥测曲线", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Real real)
    {
        return toAjax(realService.updateReal(real));
    }

    /**
     * 删除实时遥测曲线
     */
    @RequiresPermissions("system:real:remove")
    @Log(title = "实时遥测曲线", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(realService.deleteRealByIds(ids));
    }


    @GetMapping("/treelist")
    @ResponseBody
    public List<Treee> treeList(){
        return realService.treelist();
    }


    @RequestMapping("/t")
    public String tr(){
        return "dd";
    }
}
