package com.magic.controller;

import com.magic.dto.User;
import com.magic.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/20 16:34
 * @Version 1.0
 */

@RestController
@Api(value = "test",tags = "test")
public class TestController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/hello")
    public String hello(){
        return "H.M.E";
    }

    @GetMapping("/")
    public String test(){
        return "连接成功！";
    }

    @RequestMapping("/he")
    @Cacheable(value = "helloCache",condition = "#name.length() > 4")
    public String cacheTest(String name){
        System.out.println("没有走缓存！");
        return "hello"+name;
    }


    @Cacheable(value = "userCache",condition = "#id > 1")
    @GetMapping("/userCache")
    public String userCache(Integer id){
        System.out.println("数据库查询");
        User user = userMapper.selectByPrimaryKey(id);
        return user.toString();
    }
}
