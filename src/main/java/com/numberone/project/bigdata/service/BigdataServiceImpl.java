package com.numberone.project.bigdata.service;

import com.numberone.common.constant.UserConstants;
import com.numberone.common.utils.StringUtils;
import com.numberone.common.utils.security.ShiroUtils;
import com.numberone.common.utils.text.Convert;
import com.numberone.project.bigdata.domain.Zsum;
import com.numberone.project.bigdata.mapper.BigdataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 参数配置 服务层实现
 * 
 * @author numberone
 */
@Service
public class BigdataServiceImpl implements IBigdataService
{
    @Autowired
    private BigdataMapper configMapper;

    @Override
    public List<Zsum> zsum() {
        return configMapper.zsum();
    }
}
