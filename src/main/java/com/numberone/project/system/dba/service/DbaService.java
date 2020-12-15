package com.numberone.project.system.dba.service;

import com.numberone.project.system.dba.domain.Dba;
import com.numberone.project.system.dba.domain.Type;
import com.numberone.project.system.real.domain.Real;
import com.numberone.project.system.real.domain.Treee;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * 实时遥测曲线Service接口
 * 
 * @author numberone
 * @date 2020-11-24
 */
public interface DbaService
{
    List<Dba> DbaList();

    List<Type>  typetreelist();


}
