package com.example.spring_blog.data.mapper;

import com.example.spring_blog.data.dto.post.PostDTO;
import com.example.spring_blog.data.entity.Post;
import javafx.geometry.Pos;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapperStructure {
    PostMapperStructure MAPPING = Mappers.getMapper(PostMapperStructure.class);

    PostDTO entityToDto(Post post);
}
