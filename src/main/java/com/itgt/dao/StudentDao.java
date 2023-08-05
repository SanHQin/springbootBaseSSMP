package com.itgt.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itgt.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentDao extends BaseMapper<Student> {

    @Select("select * from ssmp_student where xh = #{sxh}")
    Student getStudentByXH1(String sxh);

    @Select("call select_GetStudentByXH(#{sxh})")
    Student getStudentByXH2(String sxh);

    @Select("SELECT zymc FROM `ssmp_student` GROUP BY zymc;")
    List<Object> getAllZymc();

    @Select("SELECT xy FROM `ssmp_student` GROUP BY xy;")
    List<Object> getAllxy();

    @Select("SELECT rxrq FROM `ssmp_student` GROUP BY rxrq;")
    List<Object> getAllrxrq();

}
