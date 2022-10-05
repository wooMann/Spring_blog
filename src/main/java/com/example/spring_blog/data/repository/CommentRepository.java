package com.example.spring_blog.data.repository;

import com.example.spring_blog.data.entity.Comment;
import com.example.spring_blog.data.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
     List<Comment> findAllByPost(Post post);
}
