package com.numberone.project.system.electric.controller;


import com.numberone.framework.web.controller.BaseController;
import com.numberone.project.system.electric.domain.Electric;
import com.numberone.project.system.electric.service.ElectricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 水
 * 
 * @author numberone
 */
@Controller
@RequestMapping("/system/electric")
public class ElectricController extends BaseController
{

    private String prefix = "system/electric";

    @Autowired
    private ElectricService ws;

    @RequestMapping("/list")
    @ResponseBody
    public List<Electric> list() {
        List<Electric> list = ws.selectElectricList();
//        for(Electric w: list){
//            System.out.println("值:"+w.getValue()+"名:"+w.getName()+"id"+w.getId());
//        }

        return list;
    }

}