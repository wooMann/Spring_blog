package com.example.spring_blog.data.repository;

import com.example.spring_blog.data.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
