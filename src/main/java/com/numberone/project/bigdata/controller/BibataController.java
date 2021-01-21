package com.numberone.project.bigdata.controller;

import com.numberone.framework.web.controller.BaseController;
import com.numberone.project.bigdata.domain.AreaRatio;
import com.numberone.project.bigdata.domain.Contrast;
import com.numberone.project.bigdata.domain.Mapss;
import com.numberone.project.bigdata.domain.Zsum;
import com.numberone.project.bigdata.service.IBigdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/bigdata")
    public String bigdatas()
    {
        return "bigdata/bigdata";
    }

    @RequestMapping("/zongsum")
    @ResponseBody
    public List<Zsum> zongsum(){
        return bs.zsum();
    }

    /**
     * 查询数据库展示指定数据
     *
     * 参数地区名称
     * */
    @RequestMapping("areabigdata")
    public String areabigdata(@RequestParam("largeareaname") String largeareaname, Model model){

        model.addAttribute("largeareaname",largeareaname);

        return "bigdata/area_templates";
    }

    /**
    * 总耗能查询*/
    @GetMapping("/areagross")
    @ResponseBody
    public Zsum areagross(@RequestParam("largeareaname") String largeareaname){
        return bs.areagross(largeareaname);
    }


    /*
    * 子地区点击查询指定场院的表格
    * */
    @GetMapping("/arearatio")
    @ResponseBody
    public List<AreaRatio> arearatio(@RequestParam("table") String table,@RequestParam("largeareaname") String largeareaname){
        return bs.arearatio(table,largeareaname);
    }

    @RequestMapping("/dd")
    public String dd()
    {
        return "/bigdata/dd";
    }

    /*
     * 地图点位查询
     * */
    @GetMapping("/addmappt")
    @ResponseBody
    public List<Mapss> addmappt(){
        return bs.addmappt();
    }

    /*
     * 大屏展示用能占比曲线json
     * */
    @GetMapping("/addcurve")
    @ResponseBody
    public List<Contrast> addcurve(@RequestParam("table") String table){
        return bs.addcurve(table);
    }


    /*
     * 子地区大屏展示用能占比曲线json
     * */
    @GetMapping("/areaaddcurve")
    @ResponseBody
    public List<Contrast> areaaddcurve(@RequestParam("largeareaname") String largeareaname, @RequestParam("table") String table){
        return bs.areaaddcurve(largeareaname,table);
    }





}
