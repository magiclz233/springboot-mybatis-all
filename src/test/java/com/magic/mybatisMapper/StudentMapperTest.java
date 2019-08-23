package com.magic.mybatisMapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.magic.dto.Student;
import com.magic.mapper.StudentMapper;
import com.magic.pojo.StudentScore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @ClassName StudentMapperTest
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/21 9:19
 * @Version 1.0
 */


@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void test1(){
        PageHelper.startPage(1,3);
        Page<Student> studentPage  = (Page<Student>) studentMapper.selectAll();
        for (Student stu : studentPage) {
            System.out.println(stu.toString());
        }
    }

    @Test
    public void test2(){
        Student stu = studentMapper.selectByPrimaryKey(901);

            System.out.println(stu.toString());
    }

    @Test
    public void test3(){
        List<StudentScore> stu = studentMapper.selectStudentScore();

        stu.forEach(System.out::println);
    }
    @Test
    public void test4(){
        List<Student> stu = studentMapper.selectByAll(null
                ,"张");

        stu.forEach(System.out::println);
    }

    @Test
    public void test5(){
        Student stu = studentMapper.selectByIdOrName(null
                ,"张三");

        System.out.println(stu.toString());
    }

    @Test
    public void test6(){
        List<Student> stu = studentMapper.pageStudent(0,3);

        stu.forEach(System.out::println);
    }

    @Test
    public void addStudent() throws ParseException {
        for (int i = 0; i < 100 ; i++) {
            if(i%3 == 0){
                Student student = new Student();
                student.setName("刘备"+i);
                student.setSex("男");
                student.setAddress("西安市");

                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy");
                Date date = dateformat.parse("1985");
                student.setBirthday(date);
                student.setDepartment("计算机系");
                studentMapper.insert(student);
            }else if(i%3 == 1){
                Student student = new Student();
                student.setName("妲己"+i);
                student.setSex("女");
                student.setAddress("上海市");
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy");
                Date date = dateformat.parse("1995");
                student.setBirthday(date);
                student.setDepartment("英语系");
                studentMapper.insert(student);
            }else {
                Student student = new Student();
                student.setName("李白"+i);
                student.setSex("男");
                student.setAddress("北京市");
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy");
                Date date = dateformat.parse("2005");
                student.setBirthday(date);
                student.setDepartment("中文系");
                studentMapper.insert(student);
            }


        }

    }
}
