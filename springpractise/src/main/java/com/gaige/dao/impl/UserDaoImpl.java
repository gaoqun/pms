package com.gaige.dao.impl;

import com.gaige.dao.UserDao;
import com.gaige.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by gaige on 2017/7/12.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public User getUser() {
        return new User();
    }
}
