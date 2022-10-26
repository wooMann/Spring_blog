package com.example.spring_blog.service;

import com.example.spring_blog.data.dto.post.PostDTO;
import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.mapper.PostMapper;
import com.example.spring_blog.data.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostServiceTest {
    @Autowired
    PostRepository postRepository;

    @Test
    @Transactional
    public void findByPostIdSuccess() {
        PostDTO dto = new PostDTO();
        dto.setId(7L);
        Post post = PostMapper.dtoToEntity(dto);
        Optional<Post> result = postRepository.findById(post.getId());

        assertTrue(result.isPresent());
    }
    @Test

    public void findByPostIdsFailed() {
        Post post = new Post();
        post.setId(0L);
        Optional<Post> result = postRepository.findById(post.getId());
        assertTrue(result.isPresent());
    }


    @Test
    public void findAllPost(){
        List<Post> posts = postRepository.findAll();
        System.out.println(posts.size());
    }
}