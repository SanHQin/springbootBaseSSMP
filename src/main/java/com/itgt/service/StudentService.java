package com.itgt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itgt.domain.Student;

import java.util.List;

public interface StudentService {
    Boolean saveStudent(Student student);
    Boolean deleteStudent(String sid);
    Boolean updateStudent(Student student);
    Student getStudentById(String sid);
    List<Student> getStudentList();
    IPage<Student> getStudentByPage(int currentPage, int pageSize);
}
