package com.numberone.project.system.dba.controller;

import com.numberone.framework.web.controller.BaseController;
import com.numberone.project.bigdata.domain.AreaRatio;
import com.numberone.project.bigdata.domain.Zsum;
import com.numberone.project.bigdata.service.IBigdataService;
import com.numberone.project.system.dba.domain.Dba;
import com.numberone.project.system.dba.service.DbaService;
import com.numberone.project.system.energy.service.IProductEnergyService;
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
@RequestMapping("/dba")
public class DbaController extends BaseController
{
    @Autowired
    private DbaService dbaservice;

    @RequestMapping("/dd")
    public String dd()
    {
        return "/dba/dd";
    }
    @PostMapping("list")
//    @GetMapping("/list")
    @ResponseBody
    public List<Dba> Dbalist(){
        return  dbaservice.DbaList();
    }



}
