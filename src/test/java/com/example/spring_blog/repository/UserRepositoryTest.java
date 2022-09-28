package com.example.spring_blog.repository;

import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.data.repository_.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void createUserSuccess(){
        User user = new User();
        user.setName("우광우");
        user.setPassword("123");
        user.setEmail("woo@ww.w");
        User result =  userRepository.save(user);
    }
}
