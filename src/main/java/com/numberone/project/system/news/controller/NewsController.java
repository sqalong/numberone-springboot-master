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
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(News news)
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
     @GetMapping("/remove")
    @ResponseBody
    public int remove(String ids) {
         System.out.println(ids);

         // 取身份信息
        User user = getSysUser();
        String username = user.getLoginName();
        System.out.println("用户名字"+username);

        User name = userService.getNameId(username);
        System.out.println("111111111111111111111111"+name);

        Long nameids = name.getUserId();
         System.out.println("2222222222222222222"+nameids);

        return newsService.upMessage(ids, nameids);
    }
}
