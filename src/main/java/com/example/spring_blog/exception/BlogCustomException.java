package com.example.spring_blog.exception;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

public class BlogCustomException extends RuntimeException{
    private Logger logger = Logger.getLogger("log4j.appender.userLog");
    public BlogCustomException(String message, Level level) {
        super(message);
        logger.log(level,message);
    }
}
