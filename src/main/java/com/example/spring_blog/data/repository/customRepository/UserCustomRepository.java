package com.example.spring_blog.data.repository.customRepository;

import com.example.spring_blog.data.dto.user.UserDTO;
import com.example.spring_blog.data.entity.User;

public interface UserCustomRepository {
    User findByEmailAndPassword(UserDTO dto);
    User findByEmail(UserDTO dto);
}
