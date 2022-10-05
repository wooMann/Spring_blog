package com.example.spring_blog.controller.user;


import com.example.spring_blog.data.dto.user.UserDTO;
import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.data.mapper.ResponseManager;
import com.example.spring_blog.manager.SessionConstant;
import com.example.spring_blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequestMapping("/post")
@RequiredArgsConstructor
public class UserEditController{

    final UserService userService;
    @GetMapping("edit")
    public String userPage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        Optional<User> result = userService.findById((Long) session.getAttribute(SessionConstant.SESSION_ID));
        if(result.isPresent()){
            request.setAttribute("user",result.get());
            return "redirect:userList";
        }else {
            ResponseManager.responseFailWithMessageAndPath(request,"찾을 수 없는 사용자 입니다.","/userList");
            return "pathHandler";
        }
    }

    @PostMapping("edit")
    public String userUpdate(HttpServletRequest request, UserDTO dto) {

        if(dto.getPassword().equals("")) dto.setPassword(
                userService.findById(dto.getId()).get().getPassword()
        );

        Optional<User> result =  userService.updateUser(dto);
        if (result.isPresent()){
            return "userList";
        }else {
            ResponseManager.responseFailWithMessage(request,"사용자 수정에 실패했습니다");
            return "pathHandler";
        }

    }


}
