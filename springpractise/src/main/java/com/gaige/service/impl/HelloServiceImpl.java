package com.gaige.service.impl;

import com.gaige.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by gaige on 2017/7/12.
 */
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public void hello() {
        System.out.println("HelloServiceImpl");

    }
}
