package com.example.spring_blog.data.repository;

import com.example.spring_blog.data.entity.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

import static com.example.spring_blog.data.entity.QPost.post;
@Repository
public class PostQueryDslImpl {

    private final JPAQueryFactory jpaQueryFactory;

    public PostQueryDslImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Post> findAllInnerJoinComment(){
        return jpaQueryFactory
                .selectFrom(post)
                .innerJoin(post.comments)
                .fetchJoin()
                .fetch();
    }
}
