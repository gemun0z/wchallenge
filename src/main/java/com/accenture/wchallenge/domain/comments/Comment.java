package com.accenture.wchallenge.domain.comments;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Comment {

    String id;
    String postId;
    String name;
    String email;
    String body;

}
