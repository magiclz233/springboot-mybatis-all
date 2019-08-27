package com.magic.RedisCache;

import com.magic.dto.User;
import com.magic.mapper.UserMapper;
import com.magic.service.impl.RedisServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RedisCacheTest
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/27 9:42
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisServiceImpl redisService;

    @Test
    public void valuePutAndGet(){
        User user = userMapper.selectByPrimaryKey(1);

        System.out.println(user.toString());

        redisService.valuePut("user1",user);
        System.out.println("------------------成功--------------------");
        System.out.println(redisService.getValue("user1"));
    }

    @Test
    public void listPutAndGet(){
        List<User> userList = userMapper.selectAll();
        for (User user : userList) {
            System.out.println(user.toString());
            redisService.listRightPush("userList1",user);
        }
        System.out.println("------------------成功--------------------");
        List redisList1 = redisService.listFindAll("userList1");
        for (int i = 0; i < redisList1.size(); i++) {
            System.out.println(redisList1.get(i).toString());

        }
    }

    @Test
    public void findList(){
        List list = redisService.listFindAll("userList1");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.toString());
        }
    }

    @Test
    public void map(){
        List<User> userList = userMapper.selectAll();
        for (User user : userList) {

            System.out.println(user.toString());
            Integer id = user.getId();
            String hashKey = id.toString();
            redisService.hashPut("userMap1",hashKey,user.toString());
        }
        System.out.println("------------------成功--------------------");
        Map userMap1 = redisService.hashFindAll("userMap1");
        userMap1.forEach((k,v) -> System.out.println("key:value = "+ k +":" + v));
    }

    @Test
    public void mapSelect(){
        String userMap1 = (String) redisService.hashGet("userMap1", "1");
        System.out.println(userMap1);
    }
}
