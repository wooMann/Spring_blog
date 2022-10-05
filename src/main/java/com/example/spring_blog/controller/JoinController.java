package com.example.spring_blog.controller;

import com.example.spring_blog.data.dto.user.UserDTO;
import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final UserService userService;


    @GetMapping("join")
    public String joinPage() {

        return "join";
    }

    @PostMapping("join")
    public String joinProc(UserDTO dto, BindingResult bindingResult) {
        User findResult = userService.findUserByEmail(dto);
        if (findResult == null) {
            Optional<User> joinResult = userService.join(dto);
            if (joinResult == null) {
                bindingResult.reject("가입실패");
                return "join";
            }
            return "login";
        }else{
            bindingResult.reject("이미 존재하는 메일");
            return "join";
        }
    }


}
