package com.example.spring_blog.exception;


import org.apache.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BlogCustomSlf4jException extends RuntimeException{
   private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BlogCustomSlf4jException(String message) {
        super(message);

        logger.info(message);
    }
}
