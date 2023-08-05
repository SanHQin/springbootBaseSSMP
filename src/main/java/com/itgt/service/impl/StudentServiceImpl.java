package com.itgt.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itgt.dao.StudentDao;
import com.itgt.domain.Student;
import com.itgt.service.IStudentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements IStudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public IPage<Student> getStudentPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);

        return studentDao.selectPage(page,null);
    }

    @Override
    public IPage<Student> getStudentPageBySearch(int currentPage, int pageSize, Student student) {
        IPage<Student> page = new Page<>(currentPage,pageSize);
        LambdaQueryWrapper<Student> lqw = new LambdaQueryWrapper<Student>();
        lqw.like(Strings.isNotEmpty(student.getXh()),Student::getXh,student.getXh());
        lqw.like(Strings.isNotEmpty(student.getXm()),Student::getXm,student.getXm());
        lqw.eq(Strings.isNotEmpty(student.getXb()),Student::getXb,student.getXb());
        lqw.eq(Strings.isNotEmpty(student.getXy()),Student::getXy,student.getXy());
        lqw.eq(Strings.isNotEmpty(student.getZymc()),Student::getZymc,student.getZymc());
        lqw.eq(Strings.isNotEmpty(student.getRxrq()),Student::getRxrq,student.getRxrq());

        return studentDao.selectPage(page,lqw);
    }

    @Override
    public List<Object> getAllZymc() {
        return studentDao.getAllZymc();
//        return null;
    }

    @Override
    public List<Object> getAllxy() {
        return studentDao.getAllxy();
    }

    @Override
    public List<Object> getAllrxrq() {
        return studentDao.getAllrxrq();
    }
}
