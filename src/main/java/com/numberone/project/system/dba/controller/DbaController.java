package com.numberone.project.system.dba.controller;

import com.numberone.framework.web.controller.BaseController;
import com.numberone.project.bigdata.domain.AreaRatio;
import com.numberone.project.bigdata.domain.Zsum;
import com.numberone.project.bigdata.service.IBigdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("/dd")
    public String dd()
    {
        return "/dba/dd";
    }



}
