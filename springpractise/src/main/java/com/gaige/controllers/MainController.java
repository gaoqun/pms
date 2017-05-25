package com.gaige.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gaige on 17/5/25.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String index(){
        return "index";
    }
}
