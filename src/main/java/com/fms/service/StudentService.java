package com.fms.service;

import com.fms.bo.StudentBo;
import com.fms.pojo.Student;
import com.fms.util.PageResult;

/**
 * @author liang
 * @create 2020/6/25 20:22
 */
public interface StudentService {
    /**
     * 新增学生信息
     * @param studentBo
     */
    void add(StudentBo studentBo);

    void edit(Student student);

    PageResult<Student> queryAllStudent(String key, Integer page, Integer rows);

    Student queryBySid(Integer sid);

    Student queryStudentByAid(Integer aid);

    void updateStudentByAid(Student student);
}
