package com.example.spring_blog.data.dto.post;


import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.data.mapper.PostMapper;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDTO {

    private Integer id;
    private String body;
    private String title;
    private User user;
    private Long userId;

    public Post makePost(){
        return Post.builder()
                .id(getId())
                .body(getBody())
                .title(getTitle())
                .user(User.builder().id(getUserId()).build())
                .build();
    }




}
