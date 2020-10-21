package com.numberone.project.system.student.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.system.student.mapper.StudentMapper;
import com.numberone.project.system.student.domain.Student;
import com.numberone.project.system.student.service.IStudentService;
import com.numberone.common.utils.text.Convert;

/**
 * StudentManagerService业务层处理
 * 
 * @author numberone
 * @date 2020-10-20
 */
@Service
public class StudentServiceImpl implements IStudentService 
{
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询StudentManager
     * 
     * @param id StudentManagerID
     * @return StudentManager
     */
    @Override
    public Student selectStudentById(Long id)
    {
        return studentMapper.selectStudentById(id);
    }

    /**
     * 查询StudentManager列表
     * 
     * @param student StudentManager
     * @return StudentManager
     */
    @Override
    public List<Student> selectStudentList(Student student)
    {
        return studentMapper.selectStudentList(student);
    }

    /**
     * 新增StudentManager
     * 
     * @param student StudentManager
     * @return 结果
     */
    @Override
    public int insertStudent(Student student)
    {
        return studentMapper.insertStudent(student);
    }

    /**
     * 修改StudentManager
     * 
     * @param student StudentManager
     * @return 结果
     */
    @Override
    public int updateStudent(Student student)
    {
        return studentMapper.updateStudent(student);
    }

    /**
     * 删除StudentManager对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStudentByIds(String ids)
    {
        return studentMapper.deleteStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除StudentManager信息
     * 
     * @param id StudentManagerID
     * @return 结果
     */
    @Override
    public int deleteStudentById(Long id)
    {
        return studentMapper.deleteStudentById(id);
    }
}
