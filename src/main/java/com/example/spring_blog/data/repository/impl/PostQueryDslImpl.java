package com.example.spring_blog.data.repository.impl;

import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.entity.QPost;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class PostQueryDslImpl {

    private final JPAQueryFactory jpaQueryFactory;

    public PostQueryDslImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Post> findAllInnerJoinComment(){
        QPost post = QPost.post;
        return jpaQueryFactory
                .selectFrom(post)
                .innerJoin(post.comments)
                .fetchJoin()
                .fetch();
    }
}
