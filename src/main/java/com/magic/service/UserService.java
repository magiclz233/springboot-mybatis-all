package com.magic.service;

import com.magic.dto.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/27 15:07
 * @Version 1.0
 */
public interface UserService {
    User findUserById(Integer id);

    List<User> findAllUser();


    int deleteUser(Integer id);

    int addUser(User user);

    int updateUser(User user);

}
