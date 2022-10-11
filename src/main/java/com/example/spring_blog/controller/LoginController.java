package com.example.spring_blog.controller;


import com.example.spring_blog.data.dto.user.UserDTO;
import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.manager.SessionManager;
import com.example.spring_blog.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {


    private final UserService userService;

    @GetMapping("login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("loginProc")
    public String login(UserDTO dto, BindingResult bindingResult, HttpSession session){

        Optional<User> result =  userService.login(dto);

        if (result.isPresent()){
            SessionManager.setSessionInfo(session,result.get());
            System.out.println(session.getAttribute("SESSION_USER_ID"));
            System.out.println(session.getAttribute("SESSION_USER_NAME"));
            return "redirect:main";
        }
        bindingResult.reject("로그인실패");
        return "redirect:login";
    }
}
