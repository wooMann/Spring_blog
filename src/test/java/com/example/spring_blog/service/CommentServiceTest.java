package com.example.spring_blog.service;


import com.example.spring_blog.data.repository.CommentRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    CommentRepository commentRepository;
}
