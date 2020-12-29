package com.numberone.project.system.warning.controller;

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
import com.numberone.project.system.warning.domain.WarningNotice;
import com.numberone.project.system.warning.service.IWarningNoticeService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 告警通知Controller
 * 
 * @author sqalong
 * @date 2020-12-09
 */
@Controller
@RequestMapping("/system/warning")
public class WarningNoticeController extends BaseController
{
    private String prefix = "system/warning";

    @Autowired
    private IWarningNoticeService warningNoticeService;

    @RequiresPermissions("system:warning:view")
    @GetMapping()
    public String warning()
    {
        return prefix + "/warning";
    }

    /**
     * 查询告警通知列表
     */
    @RequiresPermissions("system:warning:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WarningNotice warningNotice)
    {
        startPage();
        List<WarningNotice> list = warningNoticeService.selectWarningNoticeList(warningNotice);
        return getDataTable(list);
    }

    /**
     * 导出告警通知列表
     */
    @RequiresPermissions("system:warning:export")
    @Log(title = "告警通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WarningNotice warningNotice)
    {
        List<WarningNotice> list = warningNoticeService.selectWarningNoticeList(warningNotice);
        ExcelUtil<WarningNotice> util = new ExcelUtil<WarningNotice>(WarningNotice.class);
        return util.exportExcel(list, "warning");
    }

    /**
     * 新增告警通知
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存告警通知
     */
    @RequiresPermissions("system:warning:add")
    @Log(title = "告警通知", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WarningNotice warningNotice)
    {
        return toAjax(warningNoticeService.insertWarningNotice(warningNotice));
    }

    /**
     * 修改告警通知
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WarningNotice warningNotice = warningNoticeService.selectWarningNoticeById(id);
        mmap.put("warningNotice", warningNotice);
        return prefix + "/edit";
    }

    /**
     * 修改保存告警通知
     */
    @RequiresPermissions("system:warning:edit")
    @Log(title = "告警通知", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WarningNotice warningNotice)
    {
        return toAjax(warningNoticeService.updateWarningNotice(warningNotice));
    }

    /**
     * 删除告警通知
     */
    @RequiresPermissions("system:warning:remove")
    @Log(title = "告警通知", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(warningNoticeService.deleteWarningNoticeByIds(ids));
    }







}
