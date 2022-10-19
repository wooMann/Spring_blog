package com.example.spring_blog.service;


import com.example.spring_blog.data.dto.comment.CommentDTO;
import com.example.spring_blog.data.entity.Comment;
import com.example.spring_blog.data.entity.Post;
import com.example.spring_blog.data.mapper.CommentMapper;
import com.example.spring_blog.data.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CommentService {

    final CommentRepository commentRepository;

    public Optional<Comment> createComment(CommentDTO dto) {
        return Optional.ofNullable(commentRepository.save(CommentMapper.dtoToEntity(dto)));
    }

    public Optional<Comment>  updateComment(CommentDTO dto) {
        Comment comment = CommentMapper.dtoToEntity(dto);
        comment.setUserIp(dto.getUserIp());
        comment.setId(dto.getCommentId());

        return Optional.ofNullable(commentRepository.save(comment));
    }

    public List<Comment> findAllByPostId(Long postId) {
        return commentRepository.findAllByPost(Post.builder().id(postId).build());
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
