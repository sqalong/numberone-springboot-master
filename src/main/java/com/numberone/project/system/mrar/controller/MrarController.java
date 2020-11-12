package com.numberone.project.system.mrar.controller;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.project.system.mrar.domain.Mrar;
import com.numberone.project.system.mrar.service.IMrarService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * 表具抄表录入Controller
 * 
 * @author numberone
 * @date 2020-11-12
 */
@Controller
@RequestMapping("/system/mrar")
public class MrarController extends BaseController
{
    private String prefix = "system/mrar";

    @Autowired
    private IMrarService mrarService;

    @RequiresPermissions("system:mrar:view")
    @GetMapping()
    public String mrar()
    {
        return prefix + "/mrar";
    }


    /**
     * 导入excel
     */
    @RequestMapping("/import")
    @ResponseBody
    public String excelImport(@RequestParam(value="filename") MultipartFile file, HttpSession session){

//		String fileName = file.getOriginalFilename();

        int result = 0;

        try {
            result = mrarService.addMrar(file);
        } catch (Exception e) {

            e.printStackTrace();
        }

        if(result > 0){
            return "<script language='javascript'>alert('导入成功！');history.go(-1);</script>";

        }else{
            return "excel数据导入失败！";
        }

    }


    /**
     * 查询表具抄表录入列表
     */
    @RequiresPermissions("system:mrar:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Mrar mrar)
    {
        startPage();
        List<Mrar> list = mrarService.selectMrarList(mrar);
        return getDataTable(list);
    }

    /**
     * 导出表具抄表录入列表
     */
    @RequiresPermissions("system:mrar:export")
    @Log(title = "表具抄表录入", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Mrar mrar)
    {
        List<Mrar> list = mrarService.selectMrarList(mrar);
        ExcelUtil<Mrar> util = new ExcelUtil<Mrar>(Mrar.class);
        return util.exportExcel(list, "mrar");
    }

    /**
     * 新增表具抄表录入
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存表具抄表录入
     */
    @RequiresPermissions("system:mrar:add")
    @Log(title = "表具抄表录入", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Mrar mrar)
    {
        return toAjax(mrarService.insertMrar(mrar));
    }

    /**
     * 修改表具抄表录入
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        Mrar mrar = mrarService.selectMrarById(id);
        mmap.put("mrar", mrar);
        return prefix + "/edit";
    }

    /**
     * 修改保存表具抄表录入
     */
    @RequiresPermissions("system:mrar:edit")
    @Log(title = "表具抄表录入", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Mrar mrar)
    {
        return toAjax(mrarService.updateMrar(mrar));
    }

    /**
     * 删除表具抄表录入
     */
    @RequiresPermissions("system:mrar:remove")
    @Log(title = "表具抄表录入", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mrarService.deleteMrarByIds(ids));
    }
}
