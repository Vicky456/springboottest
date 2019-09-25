package com.springsample.login.demo.project.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class search {
    @RequestMapping("/search")
    public String loginPage(){
        return "search_page";
    }
}
