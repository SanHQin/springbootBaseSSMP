package com.itgt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itgt.dao.StudentDao;
import com.itgt.domain.Student;
import com.itgt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl_02 implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Boolean saveStudent(Student student) {
        return studentDao.insert(student) > 0;
    }

    @Override
    public Boolean deleteStudent(String sid) {
        return studentDao.deleteById(sid) > 0;
    }

    @Override
    public Boolean updateStudent(Student student) {
        return studentDao.updateById(student) > 0;
    }

    @Override
    public Student getStudentById(String sid) {
        return studentDao.selectById(sid);
    }

    @Override
    public List<Student> getStudentList() {
        return studentDao.selectList(null);
    }

    @Override
    public IPage<Student> getStudentByPage(int currentPage, int pageSize) {
        IPage<Student> ipage = new Page(currentPage,pageSize);
        return studentDao.selectPage(ipage,null);
    }
}
