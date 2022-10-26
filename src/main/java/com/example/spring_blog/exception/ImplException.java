package com.example.spring_blog.exception;


import org.apache.log4j.Level;

public class ImplException extends BlogCustomException{
    public ImplException(String message, Level level) {
        super(message, level);
    }
}
