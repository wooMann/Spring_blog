package com.example.spring_blog.controller.user;
import com.example.spring_blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@RequiredArgsConstructor
public class UserListController  {

    final UserService userService ;
    @GetMapping("/list")
    public String doGet(HttpServletRequest request, Model model) {

        model.addAttribute("userList",userService.findAllUser());
        return "userList";
    }




}
