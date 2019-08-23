package com.magic.mapper;

import com.magic.dto.Student;
import com.magic.pojo.StudentScore;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    Student selectByPrimaryKey(Integer id);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);

    List<StudentScore> selectStudentScore();

    List<Student> selectByAll(@Param("id") Integer studentId,@Param("name") String studentName);

    Student selectByIdOrName(@Param("id") Integer id,@Param("name") String name);

    List<Student> pageStudent(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
}