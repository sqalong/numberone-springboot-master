package com.numberone.project.system.punctuation.mapper;

import java.util.List;
import com.numberone.project.system.punctuation.domain.MapPunctuation;

/**
 * 地图驻点Mapper接口
 * 
 * @author sqalong
 * @date 2021-01-11
 */
public interface MapPunctuationMapper 
{
    /**
     * 查询地图驻点
     * 
     * @param name 地图驻点ID
     * @return 地图驻点
     */
    public MapPunctuation selectMapPunctuationById(String name);

    /**
     * 查询地图驻点列表
     * 
     * @param mapPunctuation 地图驻点
     * @return 地图驻点集合
     */
    public List<MapPunctuation> selectMapPunctuationList(MapPunctuation mapPunctuation);

    /**
     * 新增地图驻点
     * 
     * @param mapPunctuation 地图驻点
     * @return 结果
     */
    public int insertMapPunctuation(MapPunctuation mapPunctuation);

    /**
     * 修改地图驻点
     * 
     * @param mapPunctuation 地图驻点
     * @return 结果
     */
    public int updateMapPunctuation(MapPunctuation mapPunctuation);

    /**
     * 删除地图驻点
     * 
     * @param name 地图驻点ID
     * @return 结果
     */
    public int deleteMapPunctuationById(String name);

    /**
     * 批量删除地图驻点
     * 
     * @param names 需要删除的数据ID
     * @return 结果
     */
    public int deleteMapPunctuationByIds(String[] names);
}
