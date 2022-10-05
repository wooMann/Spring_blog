package com.example.spring_blog.data.mapper;

import com.example.spring_blog.data.dto.comment.CommentDTO;
import com.example.spring_blog.data.entity.Comment;
import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.entity.User;

public class CommentMapper {

    public static Comment dtoToEntity(CommentDTO dto){
        return Comment.builder()
                .id(dto.getId())
                .body(dto.getBody())
                .post(Post.builder().id(dto.getPostId()).build())
                .user(User.builder().id(dto.getUserId()).build())
                .userIp(dto.getUserIp())
                .build();
    }

    public static CommentDTO entityToDto(Comment comment){
        return CommentDTO.builder()
                .id(comment.getId())
                .body(comment.getBody())
                .userId(comment.getUser().getId())
                .postId(comment.getPost().getId())
                .userIp(comment.getUserIp())
                .build();
    }
}
