package com.magic.RedisCache;

import com.magic.dto.User;
import com.magic.mapper.UserMapper;
import com.magic.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName RedisCacheTest
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/27 16:59
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisCacheTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void userCacheRedisSelect(){

        User userById = userService.findUserById(1);
        System.out.println(userById.toString());
    }

    @Test
    public void userUpdateRedisCache(){
        User user = new User();
        user.setId(1);
        user.setUserName("magic");
        user.setAddress("西安市");
        user.setBirthday("1997");
        user.setSex("女");
        User user1 = userService.updateUser(user);
        if (user1 == null){
            System.out.println("没有找到该用户，无法修改");
        }else {
            System.out.println(user1.toString());
        }
    }

    @Test
    public void selectAllUser(){
        List<User> allUser = userService.findAllUser();
        allUser.forEach(System.out::println);
    }
}
