package com.example.spring_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping(value = {"","main"})
    public String mainPage(Model model, HttpSession session){

        if (session.getAttribute("SESSION_USER_ID") == null){
            return "login";
        }
        model.addAttribute("test","test");
        return "main";
    }



}
