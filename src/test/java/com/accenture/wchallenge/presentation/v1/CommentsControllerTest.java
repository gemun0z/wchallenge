package com.accenture.wchallenge.presentation.v1;

import com.accenture.wchallenge.domain.albums.Album;
import com.accenture.wchallenge.domain.comments.Comment;
import com.accenture.wchallenge.infrastructure.service.WChallengeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CommentsController.class)
class CommentsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WChallengeService service;

    @Test
    void comments() throws Exception {
        when(service.getComments()).thenReturn(List.of(Comment.builder().build()));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/comments")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void commentsByName() throws Exception {
        when(service.getCommentsByName(anyString())).thenReturn(List.of(Comment.builder().build()));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/comments", "some-name")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}