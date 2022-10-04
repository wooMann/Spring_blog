package com.example.spring_blog.data.repository_;

import com.example.spring_blog.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

    public User findByEmailAndPassword(String email , String password);

}
