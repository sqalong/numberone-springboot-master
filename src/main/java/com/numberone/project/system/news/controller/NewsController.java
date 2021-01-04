package com.numberone.project.system.news.controller;

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
import com.numberone.project.system.news.domain.News;
import com.numberone.project.system.news.service.INewsService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 消息提醒Controller
 * 
 * @author sqalong
 * @date 2020-12-28
 */
@Controller
@RequestMapping("/system/news")
public class NewsController extends BaseController
{
    private String prefix = "system/news";

    @Autowired
    private INewsService newsService;

    @Autowired
    private IUserService userService;

    @RequiresPermissions("system:news:view")
    @GetMapping()
    public String news()
    {
        return prefix + "/news";
    }

    /**
     * 查询消息提醒列表
     */
    @RequiresPermissions("system:news:list")
    @PostMapping("/lists")
    @ResponseBody
    public TableDataInfo list(News news)
    {
        startPage();

        User user = getSysUser();
        String username = user.getLoginName();
//        System.out.println("当前用户名字"+username);

        User name = userService.getNameId(username);
//        System.out.println("用户表当前用户对象"+name);

        Long nameids = name.getUserId();
//        System.out.println("当前用户对应id"+nameids);
        news.setUserId(nameids);
        Long id = news.getId();
//        System.out.println("消息ID"+id);
        List<News> list = newsService.selectNewsList(news);

        return getDataTable(list);
    }





    /**
     * 查询用户消息提醒列表
     */
    @RequiresPermissions("system:news:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo lists(News news)
    {
        startPage();
        List<News> list = newsService.selectNewsList(news);
        return getDataTable(list);
    }



    /**
     * 导出消息提醒列表
     */
    @RequiresPermissions("system:news:export")
    @Log(title = "消息提醒", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(News news)
    {
        List<News> list = newsService.selectNewsList(news);
        ExcelUtil<News> util = new ExcelUtil<News>(News.class);
        return util.exportExcel(list, "news");
    }

    /**
     * 新增消息提醒
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存消息提醒
     */
    @RequiresPermissions("system:news:add")
    @Log(title = "消息提醒", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(News news)
    {
        return toAjax(newsService.insertNews(news));
    }

    /**
     * 修改消息提醒
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        News news = newsService.selectNewsById(id);
        mmap.put("news", news);
        return prefix + "/edit";
    }

    /**
     * 修改保存消息提醒
     */
    @RequiresPermissions("system:news:edit")
    @Log(title = "消息提醒", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(News news)
    {
        return toAjax(newsService.updateNews(news));
    }

    /**
     * 修改消息提醒
     */
     @GetMapping(value = {"/remove","news/remove","news/news/remove","news/news/news/remove","news/news/news/news/remove","news/news/news/news/news/remove","news/news/news/news/news/news/remove","news/news/news/news/news/news/news/remove"})
    public String removes(String ids) {
//         System.out.println(ids);

         // 取身份信息
        User user = getSysUser();
        String username = user.getLoginName();
//        System.out.println("用户名字"+username);

        User name = userService.getNameId(username);
//        System.out.println("111111111111111111111111"+name);

        Long nameids = name.getUserId();
//         System.out.println("消息ID---------------"+nameids);
         int i = newsService.upMessage(ids, nameids);

         return prefix + "/news";
     }


    /**
     * 删除消息
     */
    @GetMapping("/removenews")
    public String removess(String ids) {
        System.out.println(ids);

        // 取身份信息
        User user = getSysUser();
        String username = user.getLoginName();
//        System.out.println("用户名字"+username);

        User name = userService.getNameId(username);
//        System.out.println("111111111111111111111111"+name);

        Long nameids = name.getUserId();
        System.out.println("消息ID---------------"+nameids);
        int i = newsService.deleteMessage(ids, nameids);

        return prefix + "/news";
    }


//    /**
//     * 修改消息提醒
//     */
//    @GetMapping("news/news/remove")
//    public String removesss(String ids) {
//        System.out.println(ids);
//
//        // 取身份信息
//        User user = getSysUser();
//        String username = user.getLoginName();
////        System.out.println("用户名字"+username);
//
//        User name = userService.getNameId(username);
////        System.out.println("111111111111111111111111"+name);
//
//        Long nameids = name.getUserId();
//        System.out.println("消息ID---------------"+nameids);
//        int i = newsService.upMessage(ids, nameids);
//
//        return prefix + "/news";
//    }

//    /**
//     * 删除消息提醒
//     */
//    @RequiresPermissions("system:news:remove")
//    @Log(title = "消息提醒", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids)
//    {
//        return toAjax(newsService.deleteNewsByIds(ids));
//    }




}
