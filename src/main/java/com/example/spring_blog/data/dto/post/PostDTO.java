package com.example.spring_blog.data.dto.post;


import com.example.spring_blog.data.dto.comment.CommentDTO;
import com.example.spring_blog.data.entity.Comment;
import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.entity.PostTag;
import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.data.mapper.PostMapper;
import lombok.*;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDTO {

    private Long id;
    private String body;
    private String title;
    private User user;
    private Long userId;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private List<CommentDTO> comments = new ArrayList<>();
    //private List<PostTag> postTags = new ArrayList<>();

    public Post makePost(){
        return Post.builder()
                .id(getId())
                .body(getBody())
                .title(getTitle())
                .user(User.builder().id(getUserId()).build())
                .build();
    }




}
