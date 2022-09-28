package com.example.spring_blog.controller;


import com.example.spring_blog.data.dto.user.UserDTO;
import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.manager.SessionManager;
import com.example.spring_blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

import java.util.Optional;

@Controller
public class LoginController {

    @GetMapping("login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("loginProc")
    public String loginProc(UserDTO dto, BindingResult bindingResult, HttpSession session){
        UserService userService = new UserService();
        Optional<User> result =  userService.login(dto);

        if (result.isPresent()){
            SessionManager.setSessionInfo(session,result.get());
            return "main";
        }
        bindingResult.reject("로그인실패");
        return "redirect:login";
    }
}
