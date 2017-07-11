package com.gaige.domain;


import java.io.Serializable;

/**
 * Created by gaige on 2017/7/3.
 */
public class User implements Serializable{

    private static final long serialVersionUID = -4158630817359321626L;
    private String userName;
    private int age;

    public User() {
    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
