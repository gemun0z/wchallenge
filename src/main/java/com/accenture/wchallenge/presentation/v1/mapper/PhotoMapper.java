package com.accenture.wchallenge.presentation.v1.mapper;

import com.accenture.wchallenge.domain.photos.Photo;
import com.accenture.wchallenge.presentation.v1.model.photos.PhotoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhotoMapper {

    PhotoMapper INSTANCE = Mappers.getMapper(PhotoMapper.class);

    PhotoResponse toModel(Photo photo);

}
