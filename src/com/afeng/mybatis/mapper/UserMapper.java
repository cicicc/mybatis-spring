package com.afeng.mybatis.mapper;

import com.afeng.mybatis.pojo.User;

public interface UserMapper {

    User findUserById(Integer id);

    void saveUser(User user);
}
