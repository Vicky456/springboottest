package com.springsample.login.demo.project.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class login {


    @RequestMapping("/login")
    public String loginPage(){
        return "login_page";
    }

}
