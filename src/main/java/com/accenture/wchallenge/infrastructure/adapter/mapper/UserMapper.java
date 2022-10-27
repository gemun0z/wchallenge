package com.accenture.wchallenge.infrastructure.adapter.mapper;

import com.accenture.wchallenge.domain.users.User;
import com.accenture.wchallenge.infrastructure.adapter.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "address.street", target = "street")
    @Mapping(source = "address.suite", target = "suite")
    @Mapping(source = "address.city", target = "city")
    @Mapping(source = "address.zipcode", target = "zipcode")
    @Mapping(source = "address.geo.lat", target = "lat")
    @Mapping(source = "address.geo.lng", target = "lng")
    @Mapping(source = "company.name", target = "companyName")
    @Mapping(source = "company.catchPhrase", target = "catchPhrase")
    @Mapping(source = "company.bs", target = "bs")
    UserEntity toEntity(User user);

    @Mapping(source = "street", target = "address.street")
    @Mapping(source = "suite", target = "address.suite")
    @Mapping(source = "city", target = "address.city")
    @Mapping(source = "zipcode", target = "address.zipcode")
    @Mapping(source = "lat", target = "address.geo.lat")
    @Mapping(source = "lng", target = "address.geo.lng")
    @Mapping(source = "companyName", target = "company.name")
    @Mapping(source = "catchPhrase", target = "company.catchPhrase")
    @Mapping(source = "bs", target = "company.bs")
    User toDomain(UserEntity userEntity);

}
