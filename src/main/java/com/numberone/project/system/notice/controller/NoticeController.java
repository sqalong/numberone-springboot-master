package com.numberone.project.system.notice.controller;

import java.util.HashMap;
import java.util.List;

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
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.system.notice.domain.Notice;
import com.numberone.project.system.notice.service.INoticeService;

/**
 * 公告 信息操作处理
 * 
 * @author numberone
 */
@Controller
@RequestMapping("/system/notice")
public class NoticeController extends BaseController
{
    private String prefix = "system/notice";

    @Autowired
    private INoticeService noticeService;


    @Autowired
    private IUserService userservice;

    @RequiresPermissions("system:notice:view")
    @GetMapping()
    public String notice()
    {
        return prefix + "/notice";
    }

    /**
     * 查询公告列表
     */
    @RequiresPermissions("system:notice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Notice notice)
    {
        startPage();
        List<Notice> list = noticeService.selectNoticeList(notice);
        return getDataTable(list);
    }

    /**
     * 新增公告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公告
     */
    @RequiresPermissions("system:notice:add")
    @Log(title = "通知公告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Notice notice)
    {
        AjaxResult ll =  toAjax(noticeService.insertNotice(notice));

        /**
         * 给所有用户添加消息
         */
        //查询所有用户对应的ID
        List<User> list = userservice.getAllUser();
        //查询插入公告表里最后一条公告的ID
        List<Notice> no = noticeService.getnoticeids();

        Long noid =23L;
        for(Notice t : no){
            noid = t.getNoticeId();
        }


        for(User u : list){
            u.setDeptId(noid);
        }


        int nos = noid.intValue();
        int rs = noticeService.addmessage(list);
//        System.out.println(noticeid);

        return ll;
    }

    /**
     * 修改公告
     */
    @GetMapping("/edit/{noticeId}")
    public String edit(@PathVariable("noticeId") Long noticeId, ModelMap mmap)
    {
        mmap.put("notice", noticeService.selectNoticeById(noticeId));
        return prefix + "/edit";
    }

    /**
     * 修改保存公告
     */
    @RequiresPermissions("system:notice:edit")
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Notice notice)
    {
        return toAjax(noticeService.updateNotice(notice));
    }

    /**
     * 删除公告
     */
    @RequiresPermissions("system:notice:remove")
    @Log(title = "通知公告", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(noticeService.deleteNoticeByIds(ids));
    }

    /**
     * 给所有用户添加消息
     */




//    /**
//     * 添加
//     */
//    @PostMapping( "/remove")
//    @ResponseBody
//    public int remove(String ids)
//    {
//        // 取身份信息
//        User user = getSysUser();
//        String username = user.getLoginName();
//        User name = noticeService.getNameId(username);
//        Long nameids = name.getUserId();
//        return messageService.upMessage(ids,nameids);
//
//    }
}
