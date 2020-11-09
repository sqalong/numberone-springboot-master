package com.numberone.project.system.water.controller;


import com.numberone.framework.web.controller.BaseController;

import com.numberone.project.system.water.domain.Water;
import com.numberone.project.system.water.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 水
 * 
 * @author numberone
 */
@Controller
@RequestMapping("/system/water")
public class WaterController extends BaseController
{

    private String prefix = "system/water";

    @Autowired
    private WaterService ws;

    @RequestMapping("/list")
    @ResponseBody
    public List<Water> list() {
        System.out.println("11111111111111111111111111111111111");
        List<Water> list = ws.selectWaterList();
        for(Water w: list){
            System.out.println(w.getValue());
        }

        return list;
    }

}