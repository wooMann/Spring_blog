package com.example.spring_blog.service;

import com.example.spring_blog.data.dto.post.PostDTO;
import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.mapper.PostMapper;
import com.example.spring_blog.data.repository.CommentRepository;
import com.example.spring_blog.data.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    final PostRepository postRepository;
    final CommentRepository commentRepository;

    public Optional<Post> createPost(PostDTO dto){
        Post post = dto.makePost();
        post.setCreatedAt(new Date());
        return Optional.ofNullable(postRepository.save(post));
    }

    public Optional<Post> updatePost(PostDTO dto){
        Post post = PostMapper.dtoToEntity(dto);
        post.setId(dto.getId());
        post.setUpdatedAt(new Date());
        return Optional.ofNullable(postRepository.save(post));
    }

    public Optional<Post> findById(Long id){
        Optional<Post> post = postRepository.findById(id);
        post.get().setComments(commentRepository.findAllByPost(post.get()));
        return post;
    }

    public List<Post> finaAllPost(){
       return postRepository.findAll();
    }


}
