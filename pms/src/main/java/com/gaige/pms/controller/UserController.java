package com.gaige.pms.controller;

import com.gaige.pms.domain.User;
import com.gaige.pms.service.PmsService;
import com.gaige.pms.service.impl.PmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static com.gaige.pms.common.PmsConstants.USER_SESSION;

@Controller
public class UserController {

    @Autowired
    private PmsServiceImpl pmsService;

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam("loginname") String username,
                              @RequestParam("password") String password,
                              HttpSession httpSession,
                              ModelAndView modelAndView) {
        User user = pmsService.login(username, password);
        if (user != null) {
            httpSession.setAttribute(USER_SESSION, user);
            modelAndView.setViewName("main");
        } else {
            modelAndView.addObject("message", "登录名或密码错误！请重新输入！");
            modelAndView.setViewName("forward:/loginForm");
        }
        return modelAndView;
    }

    @RequestMapping("/login1")
    public String login1(){
        return "loginForm";
    }


}
