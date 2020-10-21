package com.numberone.project.system.student.service;

import java.util.List;
import com.numberone.project.system.student.domain.Student;

/**
 * StudentManagerService接口
 * 
 * @author numberone
 * @date 2020-10-20
 */
public interface IStudentService 
{
    /**
     * 查询StudentManager
     * 
     * @param id StudentManagerID
     * @return StudentManager
     */
    public Student selectStudentById(Long id);

    /**
     * 查询StudentManager列表
     * 
     * @param student StudentManager
     * @return StudentManager集合
     */
    public List<Student> selectStudentList(Student student);

    /**
     * 新增StudentManager
     * 
     * @param student StudentManager
     * @return 结果
     */
    public int insertStudent(Student student);

    /**
     * 修改StudentManager
     * 
     * @param student StudentManager
     * @return 结果
     */
    public int updateStudent(Student student);

    /**
     * 批量删除StudentManager
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStudentByIds(String ids);

    /**
     * 删除StudentManager信息
     * 
     * @param id StudentManagerID
     * @return 结果
     */
    public int deleteStudentById(Long id);
}
