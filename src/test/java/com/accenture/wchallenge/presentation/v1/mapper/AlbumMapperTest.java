package com.accenture.wchallenge.presentation.v1.mapper;

import com.accenture.wchallenge.domain.albums.Album;
import com.accenture.wchallenge.presentation.v1.model.albums.AlbumResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AlbumMapperTest {

    private AlbumMapper mapper = AlbumMapper.INSTANCE;

    @Test
    void toModel() {
        AlbumResponse response = mapper.toModel(Album.builder().build());

        assertThat(response).isNotNull();
    }
}