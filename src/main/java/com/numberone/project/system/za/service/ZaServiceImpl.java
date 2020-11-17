package com.numberone.project.system.za.service;

import com.numberone.project.system.za.domain.Za;
import com.numberone.project.system.za.mapper.ZaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色 业务层处理
 * 
 * @author numberone
 */
@Service
public class ZaServiceImpl implements ZaService
{
    @Autowired
    private ZaMapper zm;

    @Override
    public List<Za> selectZaList() {
        return zm.selectZaList();
    }
}
