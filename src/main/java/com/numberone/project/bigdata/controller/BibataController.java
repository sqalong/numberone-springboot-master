package com.numberone.project.bigdata.controller;

import com.numberone.common.constant.UserConstants;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.bigdata.domain.Bigdata;
import com.numberone.project.bigdata.service.IBigdataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
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
    private String prefix = "system/bigdata";

    @RequestMapping("bigdata")
    public String bigdata()
    {
        return "bigdata";
    }


}
