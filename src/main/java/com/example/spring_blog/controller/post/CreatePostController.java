package com.example.spring_blog.controller.post;
import com.example.spring_blog.data.dto.post.PostDTO;
import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.mapper.ResponseManager;
import com.example.spring_blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class CreatePostController{

    final PostService postService;

    @GetMapping("/create")
    public String createPage() {
        return "post/post";
    }

    @PostMapping("/create")
    public String create(HttpServletRequest request, PostDTO dto) {

        Optional<Post> result =  postService.createPost(dto);
        if (result.isPresent()){
            ResponseManager.responsePath(request,"/post/list");
        }else {
            ResponseManager.responseFailWithMessage(request,"글 등록에 실패했습니다");
        }
        return "pathHandler";
    }




}
