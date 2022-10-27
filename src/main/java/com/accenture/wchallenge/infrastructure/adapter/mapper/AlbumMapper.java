package com.accenture.wchallenge.infrastructure.adapter.mapper;

import com.accenture.wchallenge.domain.albums.Album;
import com.accenture.wchallenge.infrastructure.adapter.repository.entity.AlbumEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlbumMapper {

    AlbumMapper INSTANCE = Mappers.getMapper(AlbumMapper.class);

    AlbumEntity toEntity(Album album);
}
