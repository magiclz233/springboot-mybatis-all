package com.magic.mybatisMapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.magic.dto.Student;
import com.magic.dto.User;
import com.magic.mapper.StudentMapper;
import com.magic.mapper.UserMapper;
import com.magic.pojo.StudentScore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void addStudent() throws ParseException {
        for (int i = 0; i < 100 ; i++) {
            if(i%3 == 0){
                User user = new User();
                user.setUserName("刘备"+i);
                user.setSex("男");
                user.setAddress("西安市");
                user.setBirthday("1985");
               userMapper.insert(user);
            }else if(i%3 == 1){
                User user = new User();
                user.setUserName("妲己"+i);
                user.setSex("女");
                user.setAddress("上海市");
                user.setBirthday("1995");
                userMapper.insert(user);
            }else {
                User user = new User();
                user.setUserName("李白"+i);
                user.setSex("男");
                user.setAddress("上海市");
                user.setBirthday("2005");
                userMapper.insert(user);
            }
        }
    }

    @Test
    public void pageList(){
        PageHelper.startPage(0,5);
        Page<User> userPage = userMapper.userPageAll();
        userPage.forEach(System.out::println);
    }

    @Test
    public void user(){

        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.toString());
    }
}
