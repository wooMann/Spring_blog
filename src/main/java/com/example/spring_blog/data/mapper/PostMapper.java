package com.example.spring_blog.data.mapper;

import com.example.spring_blog.data.dto.post.PostDTO;
import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


public class PostMapper {

    public static Post dtoToEntity(PostDTO dto){
        return Post.builder()
                .id(dto.getId())
                .body(dto.getBody())
                .title(dto.getTitle())
                .user(User.builder().id(dto.getUserId()).build())
                .build();
    }

    public static PostDTO entityToDto(Post post){
        return PostDTO.builder()
                .id(post.getId())
                .body(post.getBody())
                .title(post.getTitle())
                .user(post.getUser())
                .build();
    }

    PostMapper mapping = Mappers.getMapper(PostMapper.class);




}
