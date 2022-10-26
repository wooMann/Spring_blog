package com.example.spring_blog.data.repository;

import com.example.spring_blog.data.dto.user.UserDTO;
import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.data.repository.impl.UserQueryDslImpl;
import com.example.spring_blog.util.Sha256HashGenerator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserQueryDslImplTest {

    @Autowired
    UserQueryDslImpl userQueryDsl;

    @Test
    void userLoginSuccess(){
        UserDTO dto = UserDTO.builder()
                .email("123")
                .password(Sha256HashGenerator.hashGenerate("123"))
                .build();
        User result = userQueryDsl.findByEmailAndPassword(dto);
        System.out.println(result);
    }

    @Test
    void userLoginFailed(){
        UserDTO dto = UserDTO.builder()
                .email("123")
                .password(Sha256HashGenerator.hashGenerate("321"))
                .build();
        User result = userQueryDsl.findByEmailAndPassword(dto);
        System.out.println(result);
    }
}