package com.numberone.project.system.cnelectric.controller;

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
import com.numberone.project.system.cnelectric.domain.Cnelectric;
import com.numberone.project.system.cnelectric.service.ICnelectricService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 场院电表数据控制台Controller
 * 
 * @author sqalong
 * @date 2021-01-07
 */
@Controller
@RequestMapping("/system/cnelectric")
public class CnelectricController extends BaseController
{
    private String prefix = "system/cnelectric";

    @Autowired
    private ICnelectricService cnelectricService;

    @RequiresPermissions("system:cnelectric:view")
    @GetMapping()
    public String cnelectric()
    {
        return prefix + "/cnelectric";
    }

    /**
     * 查询场院电表数据控制台列表
     */
    @RequiresPermissions("system:cnelectric:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Cnelectric cnelectric)
    {
        startPage();
        List<Cnelectric> list = cnelectricService.selectCnelectricList(cnelectric);
        return getDataTable(list);
    }

    /**
     * 导出场院电表数据控制台列表
     */
    @RequiresPermissions("system:cnelectric:export")
    @Log(title = "场院电表数据控制台", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Cnelectric cnelectric)
    {
        List<Cnelectric> list = cnelectricService.selectCnelectricList(cnelectric);
        ExcelUtil<Cnelectric> util = new ExcelUtil<Cnelectric>(Cnelectric.class);
        return util.exportExcel(list, "cnelectric");
    }

    /**
     * 新增场院电表数据控制台
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存场院电表数据控制台
     */
    @RequiresPermissions("system:cnelectric:add")
    @Log(title = "场院电表数据控制台", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Cnelectric cnelectric)
    {
        return toAjax(cnelectricService.insertCnelectric(cnelectric));
    }

    /**
     * 修改场院电表数据控制台
     */
    @GetMapping("/edit/{region}")
    public String edit(@PathVariable("region") String region, ModelMap mmap)
    {
        Cnelectric cnelectric = cnelectricService.selectCnelectricById(region);
        mmap.put("cnelectric", cnelectric);
        return prefix + "/edit";
    }

    /**
     * 修改保存场院电表数据控制台
     */
    @RequiresPermissions("system:cnelectric:edit")
    @Log(title = "场院电表数据控制台", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Cnelectric cnelectric)
    {
        return toAjax(cnelectricService.updateCnelectric(cnelectric));
    }

    /**
     * 删除场院电表数据控制台
     */
    @RequiresPermissions("system:cnelectric:remove")
    @Log(title = "场院电表数据控制台", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cnelectricService.deleteCnelectricByIds(ids));
    }
}
