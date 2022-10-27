package com.accenture.wchallenge.presentation.v1.mapper;

import com.accenture.wchallenge.domain.comments.Comment;
import com.accenture.wchallenge.presentation.v1.model.comments.CommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentResponse toModel(Comment comment);

}
