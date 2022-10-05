package com.example.spring_blog.controller.comment;



import com.example.spring_blog.data.dto.comment.CommentDTO;
import com.example.spring_blog.data.entity.Comment;
import com.example.spring_blog.data.mapper.ResponseManager;
import com.example.spring_blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CreateCommentController  {

    final CommentService commentService;
    @PostMapping("create")
    public String createComment(HttpServletRequest request, CommentDTO dto) {

        Optional<Comment> result = commentService.createComment(dto);
        if(result.isPresent()){
            ResponseManager.responsePath(request,"/post/edit?id="+result.get().getPost().getId());
        }else {
            ResponseManager.responseFailWithMessageAndPath(request,"댓글 등록 실패","/post/edit?id="+result.get().getPost().getId());
        }
        return "pathHandler";
    }


}
