package com.example.spring_blog.manager;

import com.example.spring_blog.data.entity.User;

import javax.servlet.http.HttpSession;

public class SessionManager {
    public static void setSessionInfo(HttpSession session , User user){
        session.setAttribute("SESSION_USER_Id",user.getId());
        session.setAttribute("SESSION_USER_NAME",user.getName());
    }
}
