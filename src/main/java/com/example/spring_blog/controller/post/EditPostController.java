package com.example.spring_blog.controller.post;

import com.example.spring_blog.data.dto.post.PostDTO;
import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.mapper.ResponseManager;
import com.example.spring_blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@RequestMapping("/post")
@RequiredArgsConstructor
public class EditPostController  {
    final PostService postService;

    @GetMapping("/edit")
    public String doGet(HttpServletRequest request, HttpServletResponse response) {

        Long postId = Long.valueOf(request.getParameter("id"));
        Optional<Post> result =  postService.findById(postId);

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null) ip = request.getRemoteAddr();

        if(result.isPresent()){
            request.setAttribute("post",result.get());
            request.setAttribute("user_ip",ip);
            return "post";
        }else {
            ResponseManager.responseFailWithMessageAndPath(request,"존재하지 않는 게시물입니다","/post/list");
            return "pathHandler";
        }
    }
    @PostMapping("/edit")
    public String doPost(HttpServletRequest request, PostDTO dto) {

        Optional<Post> result = postService.updatePost(dto);
        if (result.isPresent()){
            ResponseManager.responsePath(request,"/post/edit?id="+result.get().getId());
        }else {
            ResponseManager.responseFailWithMessage(request,"글 수정에 실패 했습니다.");
        }
        return "pathHandler";
    }



}
