package com.numberone.project.bigdata.controller;

import com.numberone.framework.web.controller.BaseController;
import com.numberone.project.bigdata.domain.AreaRatio;
import com.numberone.project.bigdata.domain.Zsum;
import com.numberone.project.bigdata.service.IBigdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 参数配置 信息操作处理
 * 
 * @author numberone
 */
@Controller
@RequestMapping("/system/bigdata")
public class BibataController extends BaseController
{
    @Autowired
    private IBigdataService bs;
    private String prefix = "system/bigdata";

    @RequestMapping("bigdata")
    public String bigdata()
    {
        return "/bigdata/bigdata";
    }

    @RequestMapping("/zongsum")
    @ResponseBody
    public List<Zsum> zongsum(){
        return bs.zsum();
    }

    @RequestMapping("areabigdata")
    public ModelAndView areabigdata(@RequestParam("largeareaname") String largeareaname){
        ModelAndView model = new ModelAndView();
        model.addObject("largeareaname", largeareaname);
        model.setViewName("/bigdata/area_templates");
        return model;
    }

    @GetMapping("/areagross")
    @ResponseBody
    public Zsum areagross(@RequestParam("largeareaname") String largeareaname){
        return bs.areagross(largeareaname);
    }


    @GetMapping("/arearatio")
    @ResponseBody
    public List<AreaRatio> arearatio(@RequestParam("table") String table,@RequestParam("largeareaname") String largeareaname){
        return bs.arearatio(table,largeareaname);
    }
}
