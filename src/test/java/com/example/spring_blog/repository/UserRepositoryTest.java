package com.example.spring_blog.repository;

import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.data.repository_.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUserSuccess(){
        User user = new User();
        user.setName("우광우");
        user.setPassword("123");
        user.setEmail("woo@ww.w");
        User result =  userRepository.save(user);
    }
}
