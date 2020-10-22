package com.numberone.project.system.day.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.project.system.day.domain.Day;
import com.numberone.project.system.day.service.IDayService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * VIEWController
 * 
 * @author numberone
 * @date 2020-10-22
 */
@Controller
@RequestMapping("/system/day")
public class DayController extends BaseController
{
    private String prefix = "system/day";

    @Autowired
    private IDayService dayService;

    @RequiresPermissions("system:day:view")
    @GetMapping()
    public String day()
    {
        return prefix + "/day";
    }

    /**
     * 查询VIEW列表
     */
    @RequiresPermissions("system:day:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Day day)
    {
        startPage();
        List<Day> list = dayService.selectDayList(day);
        return getDataTable(list);
    }

    /**
     * 导出VIEW列表
     */
    @RequiresPermissions("system:day:export")
    @Log(title = "VIEW", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Day day)
    {
        List<Day> list = dayService.selectDayList(day);
        ExcelUtil<Day> util = new ExcelUtil<Day>(Day.class);
        return util.exportExcel(list, "day");
    }

    /**
     * 新增VIEW
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存VIEW
     */
    @RequiresPermissions("system:day:add")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Day day)
    {
        return toAjax(dayService.insertDay(day));
    }

    /**
     * 修改VIEW
     */
    @GetMapping("/edit/{name}")
    public String edit(@PathVariable("name") String name, ModelMap mmap)
    {
        Day day = dayService.selectDayById(name);
        mmap.put("day", day);
        return prefix + "/edit";
    }

    /**
     * 修改保存VIEW
     */
    @RequiresPermissions("system:day:edit")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Day day)
    {
        return toAjax(dayService.updateDay(day));
    }

    /**
     * 删除VIEW
     */
    @RequiresPermissions("system:day:remove")
    @Log(title = "VIEW", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dayService.deleteDayByIds(ids));
    }
}
