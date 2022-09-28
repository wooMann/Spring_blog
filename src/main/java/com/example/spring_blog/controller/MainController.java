package com.example.spring_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"","main"})
    public String mainPage(Model model){
        model.addAttribute("test","test");
        return "main";
    }



}
