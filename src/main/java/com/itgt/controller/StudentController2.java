package com.itgt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itgt.domain.Student;
import com.itgt.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/students")
public class StudentController2 {

    @Autowired
    private IStudentService iStudentService;


    //获取所有的学生
    @GetMapping
    public List<Student> getAllStudent(){
        return iStudentService.list();
    }

    //添加一名学生
    @PostMapping
    public Boolean saveStudent(@RequestBody Student student){
        return iStudentService.save(student);
    }

    //修改一名学生
    @PutMapping
    public Boolean updateStudent(@RequestBody Student student){
        return iStudentService.updateById(student);
    }

    //删除一名学生
    @DeleteMapping("{sid}")
    public Boolean deleteStudent(@PathVariable String sid){
        return iStudentService.removeById(sid);
    }

    //通过id查询单个学生
    @GetMapping("{sid}")
    public Student getStudent(@PathVariable String sid){
        return iStudentService.getById(sid);
    }

    //通过分页获取数据
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Student> getStudentByIPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return iStudentService.getStudentPage(currentPage,pageSize);
    }

}
