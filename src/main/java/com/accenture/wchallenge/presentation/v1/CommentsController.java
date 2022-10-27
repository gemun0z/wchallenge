package com.accenture.wchallenge.presentation.v1;

import com.accenture.wchallenge.domain.port.WChallengePort;
import com.accenture.wchallenge.presentation.v1.mapper.CommentMapper;
import com.accenture.wchallenge.presentation.v1.model.comments.CommentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class CommentsController {

    private final WChallengePort port;
    private CommentMapper mapper = CommentMapper.INSTANCE;

    @GetMapping(path = "/comments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentResponse>> comments() {
        List<CommentResponse> responses = port.getComments()
                .stream()
                .map(comment -> mapper.toModel(comment))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);

    }

    @GetMapping(path = "/comments/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentResponse>> commentsByName(@PathVariable String name) {
        List<CommentResponse> responses = port.getCommentsByName(name)
                .stream()
                .map(comment -> mapper.toModel(comment))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);

    }

}
