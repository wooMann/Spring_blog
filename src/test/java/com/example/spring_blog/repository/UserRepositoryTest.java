package com.example.spring_blog.repository;


import com.example.spring_blog.data.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test(){
        System.out.println(userRepository);
    }


}
