package com.magic.service.impl;

import com.magic.configuration.RedisCacheConfig;
import com.magic.dto.User;
import com.magic.mapper.UserMapper;
import com.magic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/27 15:25
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "user",key = "'user'.concat(#id.toString())")
    public User findUserById(Integer id) {
        System.out.println("从数据库中根据id查询的User");
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(value = "users",key = "methodName")
    public List<User> findAllUser() {
        System.out.println("从数据库中查询的所有User");
        return userMapper.selectAll();
    }

    @Override
    @CacheEvict(value = "user",key = "'user'.concat(#id.toString())")
    public int deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    @CachePut(value = "user,users",key = "'user'.concat(#user.id.toString())")
    public User updateUser(User user) {
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        if(user1 == null){
            return null;
        }else {
            int i = userMapper.updateByPrimaryKey(user);
            if(i == 1){
                System.out.println("修改成功！");
                return userMapper.selectByPrimaryKey(user.getId());
            }
        }
        return null;
    }
}
