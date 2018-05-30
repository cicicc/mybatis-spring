package com.afeng.mybatis.dao;

import com.afeng.mybatis.pojo.User;

public interface UserDao {

    User findUserById(Integer id);


    void saveUser(User user);
}
