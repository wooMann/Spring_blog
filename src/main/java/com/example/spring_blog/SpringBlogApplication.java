package com.example.spring_blog;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;


@SpringBootApplication
public class SpringBlogApplication {

    Logger logger = LoggerFactory.getLogger(SpringBootApplication.class);

    public void test(){
        logger.debug("test");
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringBlogApplication.class, args);


    }


}
