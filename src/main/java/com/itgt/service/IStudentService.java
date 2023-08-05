package com.itgt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itgt.domain.Student;

import java.util.List;

public interface IStudentService extends IService<Student> {
    IPage<Student> getStudentPage(int currentPage, int pageSize);
    IPage<Student> getStudentPageBySearch(int currentPage, int pageSize, Student student);
    List<Object> getAllZymc();
    List<Object> getAllxy();
    List<Object> getAllrxrq();
}
