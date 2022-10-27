package com.accenture.wchallenge.presentation.v1.mapper;

import com.accenture.wchallenge.domain.comments.Comment;
import com.accenture.wchallenge.presentation.v1.model.comments.CommentResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CommentMapperTest {

    private CommentMapper mapper = CommentMapper.INSTANCE;

    @Test
    void toModel() {
        CommentResponse response = mapper.toModel(Comment.builder().build());

        assertThat(response).isNotNull();
    }
}