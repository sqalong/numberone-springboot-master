package com.numberone.project.system.sondata.controller;

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
import com.numberone.project.system.sondata.domain.SonData;
import com.numberone.project.system.sondata.service.ISonDataService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 子地区基本信息Controller
 * 
 * @author sqalong
 * @date 2021-01-12
 */
@Controller
@RequestMapping("/system/sondata")
public class SonDataController extends BaseController
{
    private String prefix = "system/sondata";

    @Autowired
    private ISonDataService sonDataService;

    @RequiresPermissions("system:sondata:view")
    @GetMapping()
    public String sondata()
    {
        return prefix + "/sondata";
    }

    /**
     * 查询子地区基本信息列表
     */
    @RequiresPermissions("system:sondata:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SonData sonData)
    {
        startPage();
        List<SonData> list = sonDataService.selectSonDataList(sonData);
        return getDataTable(list);
    }

    /**
     * 导出子地区基本信息列表
     */
    @RequiresPermissions("system:sondata:export")
    @Log(title = "子地区基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SonData sonData)
    {
        List<SonData> list = sonDataService.selectSonDataList(sonData);
        ExcelUtil<SonData> util = new ExcelUtil<SonData>(SonData.class);
        return util.exportExcel(list, "sondata");
    }

    /**
     * 新增子地区基本信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存子地区基本信息
     */
    @RequiresPermissions("system:sondata:add")
    @Log(title = "子地区基本信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SonData sonData)
    {
        return toAjax(sonDataService.insertSonData(sonData));
    }

    /**
     * 修改子地区基本信息
     */
    @GetMapping("/edit/{pname}")
    public String edit(@PathVariable("pname") String pname, ModelMap mmap)
    {
        SonData sonData = sonDataService.selectSonDataById(pname);
        mmap.put("sonData", sonData);
        return prefix + "/edit";
    }

    /**
     * 修改保存子地区基本信息
     */
    @RequiresPermissions("system:sondata:edit")
    @Log(title = "子地区基本信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SonData sonData)
    {
        return toAjax(sonDataService.updateSonData(sonData));
    }

    /**
     * 删除子地区基本信息
     */
    @RequiresPermissions("system:sondata:remove")
    @Log(title = "子地区基本信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sonDataService.deleteSonDataByIds(ids));
    }




    @GetMapping( "/lists")
    @ResponseBody
    public SonData lists(String name)
    {
        return sonDataService.selectSonDataBypname(name);
    }
}
