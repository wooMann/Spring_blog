package com.example.spring_blog.data.repository.impl;

import com.example.spring_blog.data.dto.user.UserDTO;
import com.example.spring_blog.data.entity.QUser;
import com.example.spring_blog.data.entity.User;
import com.example.spring_blog.data.repository.customRepository.UserCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;



@Repository
public class UserQueryDslImpl implements UserCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public UserQueryDslImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public User findByEmailAndPassword(UserDTO dto) {
        QUser user = QUser.user;
        return jpaQueryFactory
                .selectFrom(user)
                .where(user.email.eq(dto.getEmail()),QUser.user.password.eq(dto.getPassword()))
                .fetchFirst();
    }

    @Override
    public User findByEmail(UserDTO dto) {
        QUser user = QUser.user;
        return jpaQueryFactory
                .selectFrom(user)
                .where(user.email.eq(dto.getEmail()))
                .fetchFirst();
    }
}
