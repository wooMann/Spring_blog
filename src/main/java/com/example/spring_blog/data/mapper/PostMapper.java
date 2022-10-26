package com.example.spring_blog.data.mapper;


import com.example.spring_blog.data.dto.post.PostDTO;
import com.example.spring_blog.data.entity.Post;


public class PostMapper {
    public static Post dtoToEntity(PostDTO dto){
        Post post = new Post();
        post.setId(dto.getId());
        post.setBody(dto.getBody());
        post.setUser(dto.getUser());
        post.setTitle(dto.getTitle());
        return post;
    }
}
