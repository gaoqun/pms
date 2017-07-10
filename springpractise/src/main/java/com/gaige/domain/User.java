package com.gaige.domain;


import org.springframework.stereotype.Component;

/**
 * Created by gaige on 2017/7/3.
 */
@Component
public class User {

    private String userName;
    private int age;

    public User() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
