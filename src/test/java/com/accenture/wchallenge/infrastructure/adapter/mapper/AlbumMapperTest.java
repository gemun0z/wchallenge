package com.accenture.wchallenge.infrastructure.adapter.mapper;

import com.accenture.wchallenge.domain.albums.Album;
import com.accenture.wchallenge.infrastructure.adapter.repository.entity.AlbumEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AlbumMapperTest {

    private AlbumMapper mapper = AlbumMapper.INSTANCE;

    @Test
    void toEntity() {

        AlbumEntity entity = mapper.toEntity(buildAlbum());

        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isEqualTo(buildAlbum().getId());
        assertThat(entity.getTitle()).isEqualTo(buildAlbum().getTitle());
        assertThat(entity.getUserId()).isEqualTo(buildAlbum().getUserId());

    }

    private Album buildAlbum() {
        return Album.builder()
                .id("some-id")
                .title("some-title")
                .userId("some-user-id")
                .build();
    }
}