package com.numberone.project.system.punctuation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.punctuation.mapper.MapPunctuationMapper;
import com.numberone.project.system.punctuation.domain.MapPunctuation;
import com.numberone.project.system.punctuation.service.IMapPunctuationService;
import com.numberone.common.utils.text.Convert;

/**
 * 地图驻点Service业务层处理
 * 
 * @author sqalong
 * @date 2021-01-11
 */
@Service
public class MapPunctuationServiceImpl implements IMapPunctuationService 
{
    @Autowired
    private MapPunctuationMapper mapPunctuationMapper;

    /**
     * 查询地图驻点
     * 
     * @param name 地图驻点ID
     * @return 地图驻点
     */
    @Override
    public MapPunctuation selectMapPunctuationById(String name)
    {
        return mapPunctuationMapper.selectMapPunctuationById(name);
    }

    /**
     * 查询地图驻点列表
     * 
     * @param mapPunctuation 地图驻点
     * @return 地图驻点
     */
    @Override
    public List<MapPunctuation> selectMapPunctuationList(MapPunctuation mapPunctuation)
    {
        return mapPunctuationMapper.selectMapPunctuationList(mapPunctuation);
    }

    /**
     * 新增地图驻点
     * 
     * @param mapPunctuation 地图驻点
     * @return 结果
     */
    @Override
    public int insertMapPunctuation(MapPunctuation mapPunctuation)
    {
        return mapPunctuationMapper.insertMapPunctuation(mapPunctuation);
    }

    /**
     * 修改地图驻点
     * 
     * @param mapPunctuation 地图驻点
     * @return 结果
     */
    @Override
    public int updateMapPunctuation(MapPunctuation mapPunctuation)
    {
        return mapPunctuationMapper.updateMapPunctuation(mapPunctuation);
    }

    /**
     * 删除地图驻点对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMapPunctuationByIds(String ids)
    {
        return mapPunctuationMapper.deleteMapPunctuationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除地图驻点信息
     * 
     * @param name 地图驻点ID
     * @return 结果
     */
    @Override
    public int deleteMapPunctuationById(String name)
    {
        return mapPunctuationMapper.deleteMapPunctuationById(name);
    }
}
