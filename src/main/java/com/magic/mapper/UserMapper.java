package com.magic.mapper;

import com.github.pagehelper.Page;
import com.magic.dto.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

   Page<User> userPageAll();
}