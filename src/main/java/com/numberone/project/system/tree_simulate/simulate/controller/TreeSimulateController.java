package com.numberone.project.system.tree_simulate.simulate.controller;

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
import com.numberone.project.system.tree_simulate.simulate.domain.TreeSimulate;
import com.numberone.project.system.tree_simulate.simulate.service.ITreeSimulateService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.common.utils.StringUtils;
import com.numberone.framework.web.domain.Ztree;

/**
 * 电表管理Controller
 * 
 * @author sqalong
 * @date 2020-11-23
 */
@Controller
@RequestMapping("/tree_simulate/simulate")
public class TreeSimulateController extends BaseController
{
    private String prefix = "tree_simulate/simulate";

    @Autowired
    private ITreeSimulateService treeSimulateService;

    @RequiresPermissions("tree_simulate:simulate:view")
    @GetMapping()
    public String simulate()
    {
        return prefix + "/simulate";
    }

    /**
     * 查询电表管理树列表
     */
    @RequiresPermissions("tree_simulate:simulate:list")
    @PostMapping("/list")
    @ResponseBody
    public List<TreeSimulate> list(TreeSimulate treeSimulate)
    {
        List<TreeSimulate> list = treeSimulateService.selectTreeSimulateList(treeSimulate);
        return list;
    }

    /**
     * 导出电表管理列表
     */
    @RequiresPermissions("tree_simulate:simulate:export")
    @Log(title = "电表管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TreeSimulate treeSimulate)
    {
        List<TreeSimulate> list = treeSimulateService.selectTreeSimulateList(treeSimulate);
        ExcelUtil<TreeSimulate> util = new ExcelUtil<TreeSimulate>(TreeSimulate.class);
        return util.exportExcel(list, "simulate");
    }

    /**
     * 新增电表管理
     */
    @GetMapping(value = { "/add/{tid}", "/add/" })
    public String add(@PathVariable(value = "tid", required = false) Long tid, ModelMap mmap)
    {
        if (StringUtils.isNotNull(tid))
        {
            mmap.put("treeSimulate", treeSimulateService.selectTreeSimulateById(tid));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存电表管理
     */
    @RequiresPermissions("tree_simulate:simulate:add")
    @Log(title = "电表管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TreeSimulate treeSimulate)
    {
        return toAjax(treeSimulateService.insertTreeSimulate(treeSimulate));
    }

    /**
     * 修改电表管理
     */
    @GetMapping("/edit/{tid}")
    public String edit(@PathVariable("tid") Long tid, ModelMap mmap)
    {
        TreeSimulate treeSimulate = treeSimulateService.selectTreeSimulateById(tid);
        mmap.put("treeSimulate", treeSimulate);
        return prefix + "/edit";
    }

    /**
     * 修改保存电表管理
     */
    @RequiresPermissions("tree_simulate:simulate:edit")
    @Log(title = "电表管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TreeSimulate treeSimulate)
    {
        return toAjax(treeSimulateService.updateTreeSimulate(treeSimulate));
    }

    /**
     * 删除
     */
    @RequiresPermissions("tree_simulate:simulate:remove")
    @Log(title = "电表管理", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{tid}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("tid") Long tid)
    {
        return toAjax(treeSimulateService.deleteTreeSimulateById(tid));
    }

    /**
     * 选择电表管理树
     */
    @GetMapping(value = { "/selectSimulateTree/{tid}", "/selectSimulateTree/" })
    public String selectSimulateTree(@PathVariable(value = "tid", required = false) Long tid, ModelMap mmap)
    {
        if (StringUtils.isNotNull(tid))
        {
            mmap.put("treeSimulate", treeSimulateService.selectTreeSimulateById(tid));
        }
        return prefix + "/tree";
    }

    /**
     * 加载电表管理树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = treeSimulateService.selectTreeSimulateTree();
        return ztrees;
    }
}
