package com.accenture.wchallenge.presentation.v1;

import com.accenture.wchallenge.domain.albums.Album;
import com.accenture.wchallenge.infrastructure.service.WChallengeService;
import com.accenture.wchallenge.presentation.v1.model.AccessRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AlbumsController.class)
class AlbumsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WChallengeService service;

    @Test
    void albums() throws Exception {
        when(service.getAlbums()).thenReturn(List.of(Album.builder().build()));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/albums")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void albumsByUserId() throws Exception {
        when(service.getAlbumsByUserId(anyString())).thenReturn(List.of(Album.builder().build()));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/albums", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveAlbumAndUserByAlbumId() throws Exception {
        doNothing().when(service).saveAlbumAndUserByAlbumId(anyString(), anyBoolean(), anyBoolean());

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/albums/1")
                        .content(asJsonString(AccessRequest
                                .builder()
                                .read(true)
                                .write(true)
                                .build()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updateAccessByAlbumId() throws Exception {
        doNothing().when(service).updateAccessByAlbumId(anyString(), anyBoolean(), anyBoolean());

        mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/v1/albums/1")
                        .content(asJsonString(AccessRequest
                                .builder()
                                .read(true)
                                .write(true)
                                .build()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}