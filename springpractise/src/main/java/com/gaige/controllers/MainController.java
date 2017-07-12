package com.gaige.controllers;

import com.alibaba.fastjson.JSON;
import com.gaige.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaige on 17/5/25.
 */
@Controller
@RequestMapping(value = "/test")
public class MainController {

    @RequestMapping(value = "text",method= RequestMethod.GET)
    public ModelAndView index() throws IOException{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","获取数据列表：");
        Map<String,Object> map = new HashMap<>();
        User user1 = new User("李四啊",11);
        User user2 = new User("呵呵啊",23);
        map.put("userInfo1",user1.hashCode());
        System.out.println("*****json****");
        String json = JSON.toJSONString(user2);
        map.put("userInfo2",json);
        modelAndView.addObject("infoList",map);
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping(value = "userInfo",method= RequestMethod.GET)
    public User getUserInfo() throws IOException{
        User user = new User();
        user.setAge(20);
        user.setUserName("张三");
        return user;
    }

     @RequestMapping(value = "",method= RequestMethod.GET)
    public ModelAndView getUserInfo1() throws IOException{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
