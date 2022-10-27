package com.accenture.wchallenge.presentation.v1;

import com.accenture.wchallenge.domain.albums.Album;
import com.accenture.wchallenge.domain.photos.Photo;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PhotosController.class)
class PhotosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WChallengeService service;

    @Test
    void photos() throws Exception {
        when(service.getPhotos()).thenReturn(List.of(Photo.builder().build()));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/photos")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}