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
    @Cacheable(value = "user",key = "#id")
    public User findUserById(Integer id) {
        System.out.println("从数据库中根据id查询的User");
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(value = "users",key = "users")
    public List<User> findAllUser() {
        System.out.println("从数据库中查询的所有User");
        return userMapper.selectAll();
    }

    @Override
    @CacheEvict(value = "user",key = "# id")
    public int deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    @CachePut(value = "user",key = "#user.id")
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
