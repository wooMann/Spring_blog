package com.example.spring_blog.data.repository;

import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.data.repository.customRepository.UserCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long>, UserCustomRepository {

}
