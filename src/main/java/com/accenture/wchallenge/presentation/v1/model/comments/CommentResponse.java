package com.accenture.wchallenge.presentation.v1.model.comments;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentResponse {

    private String id;
    private String postId;
    private String name;
    private String email;
    private String body;

}
