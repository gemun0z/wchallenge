package com.accenture.wchallenge.presentation.v1.mapper;

import com.accenture.wchallenge.domain.albums.Album;
import com.accenture.wchallenge.presentation.v1.model.albums.AlbumResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlbumMapper {

    AlbumMapper INSTANCE = Mappers.getMapper(AlbumMapper.class);

    AlbumResponse toModel(Album album);
}
