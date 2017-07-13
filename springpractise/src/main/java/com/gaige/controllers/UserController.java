package com.gaige.controllers;

import com.gaige.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaige on 2017/7/13.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private List<User> userList;
    private static final Log log = LogFactory.getLog(UserController.class);

    public UserController() {
        super();
        userList = new ArrayList<>();
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerForm() {
        log.info("registerForm****");
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@RequestParam(value = "username") String userName, @RequestParam(value = "password") String password) {
        log.info("register****username=" + userName + "password=" + password + "list size=" + userList.size());
        for (User user : userList) {
            if (user.getUserName().equals(userName)) {
                return "registered";
            }
        }

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        userList.add(user);
        return "loginForm";

    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") String userName,
                        @RequestParam(value = "password") String password,
                         Model model) {
        log.info("login****userId=");
        if (userList != null) {
            for (User user : userList) {
                if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                    model.addAttribute("user", user);
                    return "welcome";
                }
            }
        }
        return "loginForm";
    }

}
