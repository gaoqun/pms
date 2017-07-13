package com.gaige.controllers;

import com.gaige.dao.impl.UserDaoImpl;
import com.gaige.domain.User;
import com.gaige.service.HelloService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by gaige on 2017/7/12.
 */
@Controller
//consumes="application/json"只接受json请求的数据
//produces="application/json"指定返回的数据类型为json，必须是请求头中所包含的类型
//params = "name=zhangsan" 请求参数中必须包含name=zhangsan才能正常请求，才能让方法处理
@RequestMapping(value = "/hello",name = "hello1",method = {RequestMethod.GET,RequestMethod.POST}/*,consumes = "application/json"*/,params = "name=zhangsan")
public class HelloController {
    Log log = LogFactory.getLog(HelloController.class);

    @Autowired
    HelloService helloService;
    @Autowired
    User user;
    @Autowired
    UserDaoImpl userDao;

    @RequestMapping(value = "user1")
    public ModelAndView hello()throws Exception{
        helloService.hello();
        log.info("hello方法被调用！");
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

    @ModelAttribute//会优先调用
    public void getUser(String userName,int password,Model model){
        log.info("getUser()");
        User user = new User(userName,password);
        model.addAttribute("userInfo",user);
    }

    @RequestMapping(value = "testModel")
    public String testModel(Model model){
        log.info("调用testModel()");
        User user = (User) model.asMap().get("userInfo");
        if (user!=null){
            log.info("user's hashCode is "+user.hashCode());
        }
        return "userInfo";
    }




}
