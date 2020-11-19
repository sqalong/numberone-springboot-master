package com.numberone.project.bigdata.service;

import com.numberone.project.bigdata.domain.AreaRatio;
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

    @Override
    public Zsum areagross(String largeareaname) {
        return configMapper.areagross(largeareaname);
    }

    @Override
    public List<AreaRatio> arearatio(String table, String largeareaname) {
        return configMapper.arearatio(table,largeareaname);
    }
}
