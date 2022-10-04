package com.example.spring_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
