package com.accenture.wchallenge.presentation.v1.mapper;

import com.accenture.wchallenge.domain.users.User;
import com.accenture.wchallenge.presentation.v1.model.users.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse toModel(User user);
}
