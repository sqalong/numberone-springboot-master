package com.numberone.project.student.controller;

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
import com.numberone.project.student.domain.SchoolStudent;
import com.numberone.project.student.service.ISchoolStudentService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.common.utils.StringUtils;
import com.numberone.framework.web.domain.Ztree;

/**
 * 学生Controller
 * 
 * @author numberone
 * @date 2020-05-04
 */
@Controller
@RequestMapping("/school/student")
public class SchoolStudentController extends BaseController
{
    private String prefix = "school/student";

    @Autowired
    private ISchoolStudentService schoolStudentService;

    @RequiresPermissions("school:student:view")
    @GetMapping()
    public String student()
    {
        return prefix + "/student";
    }

    /**
     * 查询学生树列表
     */
    @RequiresPermissions("school:student:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SchoolStudent> list(SchoolStudent schoolStudent)
    {
        List<SchoolStudent> list = schoolStudentService.selectSchoolStudentList(schoolStudent);
        return list;
    }

    /**
     * 导出学生列表
     */
    @RequiresPermissions("school:student:export")
    @Log(title = "学生", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SchoolStudent schoolStudent)
    {
        List<SchoolStudent> list = schoolStudentService.selectSchoolStudentList(schoolStudent);
        ExcelUtil<SchoolStudent> util = new ExcelUtil<SchoolStudent>(SchoolStudent.class);
        return util.exportExcel(list, "student");
    }

    /**
     * 新增学生
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("schoolStudent", schoolStudentService.selectSchoolStudentById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存学生
     */
    @RequiresPermissions("school:student:add")
    @Log(title = "学生", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SchoolStudent schoolStudent)
    {
        return toAjax(schoolStudentService.insertSchoolStudent(schoolStudent));
    }

    /**
     * 修改学生
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SchoolStudent schoolStudent = schoolStudentService.selectSchoolStudentById(id);
        mmap.put("schoolStudent", schoolStudent);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生
     */
    @RequiresPermissions("school:student:edit")
    @Log(title = "学生", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SchoolStudent schoolStudent)
    {
        return toAjax(schoolStudentService.updateSchoolStudent(schoolStudent));
    }

    /**
     * 删除
     */
    @RequiresPermissions("school:student:remove")
    @Log(title = "学生", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        return toAjax(schoolStudentService.deleteSchoolStudentById(id));
    }

    /**
     * 选择学生树
     */
    @GetMapping(value = { "/selectStudentTree/{id}", "/selectStudentTree/" })
    public String selectStudentTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("schoolStudent", schoolStudentService.selectSchoolStudentById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载学生树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = schoolStudentService.selectSchoolStudentTree();
        return ztrees;
    }
}
