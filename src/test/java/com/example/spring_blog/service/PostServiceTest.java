package com.example.spring_blog.service;

import com.example.spring_blog.data.dto.post.PostDTO;
import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.mapper.PostMapperStructure;
import com.example.spring_blog.data.mapper.PostMapperStructureImpl;
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
        Post post = new Post();
        post.setId(7L);
        Optional<Post> result = postRepository.findById(post.getId());
     //   PostDTO dto = PostMapperStructureImpl.MAPPING.entityToDto(result.get());
        assertTrue(result.isPresent());
       // assertTrue(dto != null);
        System.out.println(result.get().getComments().size());
        System.out.println(result.get().getComments().get(1).getBody());
        result.get().getComments().stream().forEach(comment -> System.out.println(comment.getBody()));

    }
    @Test

    public void findByPostIdSFail() {
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