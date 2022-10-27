package com.accenture.wchallenge.presentation.v1.mapper;

import com.accenture.wchallenge.domain.users.User;
import com.accenture.wchallenge.presentation.v1.model.users.UserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    private UserMapper mapper = UserMapper.INSTANCE;

    @Test
    void toModel() {
        UserResponse response = mapper.toModel(User.builder().build());

        assertThat(response).isNotNull();
    }
}