package com.numberone.project.student.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.numberone.framework.web.domain.Ztree;
import com.numberone.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.student.mapper.SchoolStudentMapper;
import com.numberone.project.student.domain.SchoolStudent;
import com.numberone.project.student.service.ISchoolStudentService;
import com.numberone.common.utils.text.Convert;

/**
 * 学生Service业务层处理
 * 
 * @author numberone
 * @date 2020-05-04
 */
@Service
public class SchoolStudentServiceImpl implements ISchoolStudentService 
{
    @Autowired
    private SchoolStudentMapper schoolStudentMapper;

    /**
     * 查询学生
     * 
     * @param id 学生ID
     * @return 学生
     */
    @Override
    public SchoolStudent selectSchoolStudentById(Long id)
    {
        return schoolStudentMapper.selectSchoolStudentById(id);
    }

    /**
     * 查询学生列表
     * 
     * @param schoolStudent 学生
     * @return 学生
     */
    @Override
    public List<SchoolStudent> selectSchoolStudentList(SchoolStudent schoolStudent)
    {
        return schoolStudentMapper.selectSchoolStudentList(schoolStudent);
    }

    /**
     * 新增学生
     * 
     * @param schoolStudent 学生
     * @return 结果
     */
    @Override
    public int insertSchoolStudent(SchoolStudent schoolStudent)
    {
        schoolStudent.setCreateTime(DateUtils.getNowDate());
        return schoolStudentMapper.insertSchoolStudent(schoolStudent);
    }

    /**
     * 修改学生
     * 
     * @param schoolStudent 学生
     * @return 结果
     */
    @Override
    public int updateSchoolStudent(SchoolStudent schoolStudent)
    {
        schoolStudent.setUpdateTime(DateUtils.getNowDate());
        return schoolStudentMapper.updateSchoolStudent(schoolStudent);
    }

    /**
     * 删除学生对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSchoolStudentByIds(String ids)
    {
        return schoolStudentMapper.deleteSchoolStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生信息
     * 
     * @param id 学生ID
     * @return 结果
     */
    @Override
    public int deleteSchoolStudentById(Long id)
    {
        return schoolStudentMapper.deleteSchoolStudentById(id);
    }

    /**
     * 查询学生树列表
     * 
     * @return 所有学生信息
     */
    @Override
    public List<Ztree> selectSchoolStudentTree()
    {
        List<SchoolStudent> schoolStudentList = schoolStudentMapper.selectSchoolStudentList(new SchoolStudent());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SchoolStudent schoolStudent : schoolStudentList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(schoolStudent.getId());
            ztree.setpId(schoolStudent.getParentId());
            ztree.setName(schoolStudent.getName());
            ztree.setTitle(schoolStudent.getName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
