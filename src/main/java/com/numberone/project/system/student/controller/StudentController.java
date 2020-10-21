package com.numberone.project.system.student.controller;

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
import com.numberone.project.system.student.domain.Student;
import com.numberone.project.system.student.service.IStudentService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * StudentManagerController
 *
 * @author numberone
 * @date 2020-10-20
 */
@Controller
@RequestMapping("/system/student")
public class StudentController extends BaseController {
    private String prefix = "system/student";

    @Autowired
    private IStudentService studentService;

    @RequiresPermissions("system:student:view")
    @GetMapping()
    public String student() {
        return prefix + "/student";
    }

    /**
     * 查询StudentManager列表
     */
    @RequiresPermissions("system:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Student student) {
        startPage();
        List<Student> list = studentService.selectStudentList(student);
        return getDataTable(list);
    }

    /**
     * 导出StudentManager列表
     */
    @RequiresPermissions("system:student:export")
    @Log(title = "StudentManager", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Student student) {
        List<Student> list = studentService.selectStudentList(student);
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
        return util.exportExcel(list, "student");
    }

    /**
     * 新增StudentManager
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存StudentManager
     */
    @RequiresPermissions("system:student:add")
    @Log(title = "StudentManager", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Student student) {
        return toAjax(studentService.insertStudent(student));
    }

    /**
     * 修改StudentManager
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Student student = studentService.selectStudentById(id);
        mmap.put("student", student);
        return prefix + "/edit";
    }

    /**
     * 修改保存StudentManager
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "StudentManager", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Student student) {
        return toAjax(studentService.updateStudent(student));
    }

    /**
     * 删除StudentManager
     */
    @RequiresPermissions("system:student:remove")
    @Log(title = "StudentManager", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(studentService.deleteStudentByIds(ids));
    }
}
