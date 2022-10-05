package com.example.spring_blog.data.repository;

import com.example.spring_blog.data.entity.EmailTokens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<EmailTokens,Long> {
}
