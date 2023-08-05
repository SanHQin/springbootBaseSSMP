package com.itgt.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itgt.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDaoTestCase {

    @Autowired
    private StudentDao StudentDao;

    @Test
    void Test(){
        String zy = "2019互联网技术G5-1";
//        System.out.println("11111");
//        System.out.println(Studen  tDao.getStudentByXH2("201901766"));
//        System.out.println(StudentDao.selectById("201901766"));

        System.out.println("分页查询");
        IPage page = new Page(1,50);

//        QueryWrapper qw = new QueryWrapper();
        LambdaQueryWrapper<Student> lqw = new LambdaQueryWrapper<Student>();
        lqw.eq(zy!=null,Student::getXzb,zy);
//        qw.eq("xzb","2019互联网技术G5-1");
//        qw.eq("xh","201901766");
        StudentDao.selectPage(page,lqw);
        System.out.println(page.getRecords());
//        System.out.println(page.getPages());
//        System.out.println(page.getCurrent());
//        System.out.println(page.getSize());
//        System.out.println(page.getTotal());
//        System.out.println(page.getRecords());
//        System.out.println(StudentDao.selectList(null));
    }
}
