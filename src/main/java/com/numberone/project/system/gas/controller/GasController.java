package com.numberone.project.system.gas.controller;


import com.numberone.framework.web.controller.BaseController;
import com.numberone.project.system.gas.domain.Gas;
import com.numberone.project.system.gas.service.GasService;
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
@RequestMapping("/system/gas")
public class GasController extends BaseController
{

    private String prefix = "system/gas";

    @Autowired
    private GasService gas;

    @RequestMapping("/list")
    @ResponseBody
    public List<Gas> list() {
        List<Gas> list = gas.selectGasList();
//        for(Gas w: list){
//            System.out.println("值:"+w.getValue()+"名:"+w.getName()+"id:"+w.getId());
//        }

        return list;
    }

}