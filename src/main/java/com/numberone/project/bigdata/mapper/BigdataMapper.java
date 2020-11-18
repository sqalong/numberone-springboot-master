package com.numberone.project.bigdata.mapper;

import com.numberone.project.bigdata.domain.AreaRatio;
import com.numberone.project.bigdata.domain.Zsum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 参数配置 数据层
 *
 * @author numberone
 */

public interface BigdataMapper {

    List<Zsum> zsum();

    Zsum areagross(@Param("largeareaname") String largeareaname);

    List<AreaRatio> arearatio(@Param("table")String table, @Param("largeareaname") String largeareaname);
}