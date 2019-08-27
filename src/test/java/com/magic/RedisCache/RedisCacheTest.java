package com.magic.RedisCache;

import com.magic.dto.User;
import com.magic.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        int i = userService.updateUser(user);

        if(i  == 1){
            System.out.println("修改成功。");
        }
    }
}
