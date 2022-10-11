package com.example.spring_blog.data.repository;

import com.example.spring_blog.data.entity.Post;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostQueryDslRepositoryImplTest {

    final PostQueryDslImpl postQueryDslRepository;

    public PostQueryDslRepositoryImplTest(PostQueryDslImpl postQueryDslRepository) {
        this.postQueryDslRepository = postQueryDslRepository;
    }

    @Test
    void findAllTest(){
        List<Post> result = postQueryDslRepository.findAllInnerJoinComment();
        System.out.println(result);
    }
}