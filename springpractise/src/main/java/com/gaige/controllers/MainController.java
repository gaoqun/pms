package com.gaige.controllers;

import com.gaige.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by gaige on 17/5/25.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/entrance",  method= RequestMethod.GET)
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","你说啥来着");
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/user/info", method=RequestMethod.GET)
    public User getUserInfo(){
        User user = new User();
        user.setAge(20);
        user.setUserName("张三");
        return user;
    }
}
