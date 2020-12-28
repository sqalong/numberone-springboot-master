package com.numberone.project.system.message.controller;

import java.util.List;

import com.numberone.project.system.menu.domain.Menu;
import com.numberone.project.system.user.domain.User;
import com.numberone.project.system.user.service.IUserService;
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
import com.numberone.project.system.message.domain.Message;
import com.numberone.project.system.message.service.IMessageService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * VIEWController
 * 
 * @author sqalong
 * @date 2020-12-23
 */
@Controller
@RequestMapping("/system/message")
public class MessageController extends BaseController
{
    private String prefix = "system/message";

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IUserService userService;

    @RequiresPermissions("system:message:view")
    @GetMapping()
    public String message()
    {
        return prefix + "/message";
    }
    /**
     * 查询VIEW列表
     */
    @RequiresPermissions("system:message:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Message message)
    {
        startPage();
        List<Message> list = messageService.selectMessageList(message);
        System.out.print(list);
        return getDataTable(list);
    }

    /**
     * 返回json数据
     * */
    @RequiresPermissions("system:message:lists")
    @GetMapping("/lists")
    @ResponseBody
    public List<Message> lists(Message message)
    {
        startPage();
        List<Message> list = messageService.selectMessageList(message);
        System.out.print(list);
        return list;
    }

    /**
     * 导出VIEW列表
     */
    @RequiresPermissions("system:message:export")
    @Log(title = "VIEW", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Message message)
    {
        List<Message> list = messageService.selectMessageList(message);
        ExcelUtil<Message> util = new ExcelUtil<Message>(Message.class);
        return util.exportExcel(list, "message");
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
    @RequiresPermissions("system:message:add")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Message message)
    {
        return toAjax(messageService.insertMessage(message));
    }

    /**
     * 修改VIEW
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Message message = messageService.selectMessageById(id);
        mmap.put("message", message);
        return prefix + "/edit";
    }

    /**
     * 修改保存VIEW
     */
    @RequiresPermissions("system:message:edit")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Message message)
    {
        return toAjax(messageService.updateMessage(message));
    }

    /**
     * 修改信息状态
     */
    @PostMapping( "/remove")
    @ResponseBody
    public int remove(String ids)
    {
        // 取身份信息
        User user = getSysUser();
        String username = user.getLoginName();
        User name = userService.getNameId(username);
        Long nameids = name.getUserId();
        return messageService.upMessage(ids,nameids);

    }
}
