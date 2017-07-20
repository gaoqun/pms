package com.gaige.pms.service;

import com.gaige.pms.domain.User;

import java.util.List;

public interface PmsService {
    //用户登录
    User login(String username,String password);

    //根据id查询用户
    User findUserById(Integer id);

    //获取所以用户
    List<User> findUser();

    //根据id删除user
    void removeUser(Integer id);

    //修改用户
    void modifyUser(User user);

    //添加用户
    void addUser(User user);
}
