package com.example.spring_blog.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false, unique = true)
    private Long id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "body")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_at")
    private Date deletedAt;
    @OneToMany(mappedBy = "post",fetch =FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();
    public void addComments(Comment comment){
        comment.setPost(this);
        this.comments.add(comment);
    }

    @OneToMany(mappedBy = "post")
    private List<PostTag> postTags = new ArrayList<>();
}
