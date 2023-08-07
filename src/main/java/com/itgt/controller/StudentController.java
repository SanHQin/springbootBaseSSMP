package com.itgt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itgt.controller.utils.R;
import com.itgt.domain.Student;
import com.itgt.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;


    //获取所有的学生
    @GetMapping
    public R getAllStudent(){
        return new R(true,iStudentService.list());
    }

    //添加一名学生
    @PostMapping
    public R saveStudent(@RequestBody Student student){
        student.setId(student.getXh());
        return new R(iStudentService.save(student));
    }

    //修改一名学生
    @PutMapping
    public R updateStudent(@RequestBody Student student){
        return new R(iStudentService.updateById(student));
    }

    //删除一名学生
    @DeleteMapping("{sid}")
    public R deleteStudent(@PathVariable String sid){
        return new R(iStudentService.removeById(sid));
    }

    //通过id查询单个学生
    @GetMapping("{sid}")
    public R getStudent(@PathVariable String sid){
        return new R(true,iStudentService.getById(sid));
    }

    //通过分页获取数据
    @GetMapping("/{currentPage}/{pageSize}")
    public R getStudentByIPage(@PathVariable int currentPage, @PathVariable int pageSize,Student student){
        log.info(student.toString());
        System.out.println(student);
        IPage<Student> page = iStudentService.getStudentPageBySearch(currentPage,pageSize,student);
        if(currentPage>page.getPages()){
            page = iStudentService.getStudentPageBySearch((int)page.getPages(),pageSize,student);
        }
        return new R(true,page);
    }

    //获取所有的专业
    @GetMapping("/zymc")
    public R getAllZymc(){
        return new R(true,iStudentService.getAllZymc());
    }

    //获取所有的学院
    @GetMapping("/xy")
    public R getAllxy(){
        return new R(true,iStudentService.getAllxy());
    }

    //获取所有的年级
    @GetMapping("/rxrq")
    public R getAllrxrq(){
        return new R(true,iStudentService.getAllrxrq());
    }

}
