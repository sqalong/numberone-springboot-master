package com.numberone.project.system.reduce.controller;

import com.numberone.project.system.reduce.domain.Reduce;
import com.numberone.project.system.reduce.service.IReduceService;
import com.numberone.project.system.reduce.service.ReduceServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/system/reduce")
public class ReduceController {
    @Autowired
    private IReduceService iReduceService;
    @RequestMapping("/lists")
    @ResponseBody
    public List<Reduce> selectreduce(){
        List<Reduce> list=iReduceService.selectAll();
        return list;
    }

}
