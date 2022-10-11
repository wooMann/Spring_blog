package com.example.spring_blog.data.repository;

import com.example.spring_blog.data.dto.user.UserDTO;
import com.example.spring_blog.data.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import com.example.spring_blog.data.entity.QUser;

@Repository
public class UserQueryDslImpl {
    private final JPAQueryFactory jpaQueryFactory;

    public UserQueryDslImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public User findByEmailAndPassword(UserDTO dto){
        return jpaQueryFactory
                .selectFrom(QUser.user)
                .where(QUser.user.email.eq(dto.getEmail()),QUser.user.password.eq(dto.getPassword()))
                .fetchFirst();
    }


}
