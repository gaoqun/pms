package com.gaige.controllers;

import com.gaige.dao.impl.UserDaoImpl;
import com.gaige.domain.User;
import com.gaige.service.HelloService;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by gaige on 2017/7/12.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    HelloService helloService;
    @Autowired
    User user;
    @Autowired
    UserDaoImpl userDao;

    @RequestMapping(value = "user1",method= RequestMethod.GET)
    public ModelAndView hello()throws Exception{
        helloService.hello();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "json",method = RequestMethod.GET)
    public User fetchJson()throws IOException{
        user.setUserName("hello 老王！");
        user.setAge(43);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);
        return user;
    }

    @RequestMapping(value = "getUserHashCode",method = RequestMethod.GET)
    public ModelAndView getUserHashCode(){
        User user1 = userDao.getUser();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hashCode",user1.hashCode());
        System.out.println(user1.hashCode());
        modelAndView.setViewName("userInfo");
        return modelAndView;
    }


}
