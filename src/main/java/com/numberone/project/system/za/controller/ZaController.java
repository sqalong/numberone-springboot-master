package com.numberone.project.system.za.controller;


import com.numberone.framework.web.controller.BaseController;
import com.numberone.project.system.za.domain.Za;
import com.numberone.project.system.za.service.ZaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 水
 * 
 * @author numberone
 */
@Controller
@RequestMapping("/system/za")
public class ZaController extends BaseController
{

    private String prefix = "system/water";

    @Autowired
    private ZaService zs;

    @RequestMapping("/list")
    @ResponseBody
    public List<Za> list() {
        List<Za> list = zs.selectZaList();
//        for(Water w: list){
//            System.out.println(w.getValue());
//        }
        return list;
    }

}