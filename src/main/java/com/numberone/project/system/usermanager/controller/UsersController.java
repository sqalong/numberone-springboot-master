package com.numberone.project.system.usermanager.controller;

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
import com.numberone.project.system.usermanager.domain.Users;
import com.numberone.project.system.usermanager.service.IUsersService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 用户信息Controller
 * 
 * @author sqalong
 * @date 2020-12-29
 */
@Controller
@RequestMapping("/system/usermanager")
public class UsersController extends BaseController
{
    private String prefix = "system/usermanager";

    @Autowired
    private IUsersService usersService;

    @RequiresPermissions("system:usermanager:view")
    @GetMapping()
    public String usermanager()
    {
        return prefix + "/usermanager";
    }

    /**
     * 查询用户信息列表
     */
    @RequiresPermissions("system:usermanager:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Users users)
    {
        startPage();
        List<Users> list = usersService.selectUsersList(users);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @RequiresPermissions("system:usermanager:export")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Users users)
    {
        List<Users> list = usersService.selectUsersList(users);
        ExcelUtil<Users> util = new ExcelUtil<Users>(Users.class);
        return util.exportExcel(list, "usermanager");
    }

    /**
     * 新增用户信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户信息
     */
    @RequiresPermissions("system:usermanager:add")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Users users)
    {
        return toAjax(usersService.insertUsers(users));
    }

    /**
     * 修改用户信息
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        Users users = usersService.selectUsersById(userId);
        mmap.put("users", users);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户信息
     */
    @RequiresPermissions("system:usermanager:edit")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Users users)
    {
        return toAjax(usersService.updateUsers(users));
    }

    /**
     * 删除用户信息
     */
    @RequiresPermissions("system:usermanager:remove")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(usersService.deleteUsersByIds(ids));
    }
}
