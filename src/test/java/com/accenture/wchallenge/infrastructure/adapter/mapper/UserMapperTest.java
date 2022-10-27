package com.accenture.wchallenge.infrastructure.adapter.mapper;

import com.accenture.wchallenge.domain.users.User;
import com.accenture.wchallenge.infrastructure.adapter.repository.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    private UserMapper mapper = UserMapper.INSTANCE;

    @Test
    void toEntity() {
        UserEntity userEntity = mapper.toEntity(buildUser());

        assertThat(userEntity).isNotNull();
    }

    @Test
    void toDomain() {
        User user = mapper.toDomain(buildUserEntity());

        assertThat(user).isNotNull();
    }

    private User buildUser() {
        return User.builder().build();
    }

    private UserEntity buildUserEntity() {
        return UserEntity.builder().build();
    }
}