package com.example.spring_blog.data.mapper;

import javax.servlet.http.HttpServletRequest;

public class ResponseManager {

    public static void responseFailWithMessage(HttpServletRequest request,String message){
        request.setAttribute("path","javascript:history.back()");
        request.setAttribute("message",message);
    }

    public static void responseFailWithMessageAndPath(HttpServletRequest request,String message,String path){
        request.setAttribute("path",path);
        request.setAttribute("message",message);
    }
    public static void responsePath(HttpServletRequest request,String path){
        request.setAttribute("path",path);
    }
}
