package com.accenture.wchallenge.presentation.v1.mapper;

import com.accenture.wchallenge.domain.photos.Photo;
import com.accenture.wchallenge.presentation.v1.model.photos.PhotoResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PhotoMapperTest {

    private PhotoMapper mapper = PhotoMapper.INSTANCE;

    @Test
    void toModel() {
        PhotoResponse response = mapper.toModel(Photo.builder().build());

        assertThat(response).isNotNull();
    }
}