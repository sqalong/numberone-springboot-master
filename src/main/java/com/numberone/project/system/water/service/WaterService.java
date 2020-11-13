package com.numberone.project.system.water.service;

import com.numberone.project.system.user.domain.UserRole;
import com.numberone.project.system.water.domain.Water;

import java.util.List;
import java.util.Set;


public interface WaterService
{

    List<Water> selectWaterList();


    Water wsum();
}
