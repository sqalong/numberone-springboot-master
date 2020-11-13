package com.numberone.project.system.reduce.service;

import com.numberone.project.system.reduce.domain.Reduce;
import com.numberone.project.system.reduce.mapper.ReduceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReduceServicelmpl implements IReduceService {
    @Autowired
    private ReduceMapper reduceMapper;

    @Override
    public List<Reduce> selectAll() {

        return reduceMapper.selectAll();
    }
}
