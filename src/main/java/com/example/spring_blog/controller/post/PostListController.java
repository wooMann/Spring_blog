package com.example.spring_blog.controller.post;


import com.example.spring_blog.data.dto.post.PostDTO;
import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.mapper.PostMapper;
import com.example.spring_blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostListController{
    final PostService postService;

    @GetMapping("/list")
    public String doGet(Model model) {

        List<Post> postList =  postService.finaAllPost();
        List<PostDTO> postDTOList = postList.stream().map(post -> PostMapper.entityToDto(post)).collect(Collectors.toList());
        model.addAttribute("postList",postDTOList);
        return "post/postList";
    }


}
