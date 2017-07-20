package com.gaige.pms.service.impl;

import com.gaige.pms.dao.UserDao;
import com.gaige.pms.domain.User;
import com.gaige.pms.service.PmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsServiceImpl implements PmsService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        return userDao.selectByLoginNameAndPassword(username, password);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> findUser() {
        return null;
    }

    @Override
    public void removeUser(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void modifyUser(User user) {
        userDao.update(user);
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }
}
