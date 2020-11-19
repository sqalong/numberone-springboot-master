package com.numberone.project.bigdata.service;

import com.numberone.project.bigdata.domain.AreaRatio;
import com.numberone.project.bigdata.domain.Zsum;

import java.util.List;

/**
 * 参数配置 服务层
 * 
 * @author numberone
 */
public interface IBigdataService
{
    List<Zsum> zsum();

    Zsum areagross(String largeareaname);

    List<AreaRatio> arearatio(String table, String largeareaname);
}
