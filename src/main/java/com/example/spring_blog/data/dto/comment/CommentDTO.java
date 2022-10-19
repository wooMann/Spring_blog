package com.example.spring_blog.data.dto.comment;


import com.example.spring_blog.data.entity.Comment;
import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO {

    private Integer id;
    private String body;
    private Long postId;
    private Long userId;
    private Integer commentId;
    private String userIp;

    public Comment makeComment(){
        Comment comment = new Comment();
        comment.setBody(getBody());
        Post post = new Post();
        post.setId(getPostId());
        comment.setPost(post);

        if(getUserId() != null){
            User user = new User();
            user.setId(getUserId());
            comment.setUser(user);
        }
        comment.setUserIp(getUserIp());
        return comment;
    }
}
