package com.accenture.wchallenge.presentation.v1;

import com.accenture.wchallenge.domain.port.WChallengePort;
import com.accenture.wchallenge.presentation.v1.mapper.UserMapper;
import com.accenture.wchallenge.presentation.v1.model.AccessEnum;
import com.accenture.wchallenge.presentation.v1.model.users.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class UsersController {

    private final WChallengePort port;
    private UserMapper mapper = UserMapper.INSTANCE;

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponse>> users() {
        List<UserResponse> responses = port.getUsers()
                .stream()
                .map(user -> mapper.toModel(user))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);
    }

    @GetMapping(path = "/users/access/{access}/album/{albumId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponse>> getUserByAccessAndAlbumId(@PathVariable AccessEnum access, @PathVariable String albumId) {
        List<UserResponse> responses = port.getUserByAccessAndAlbumId(access.toString(), albumId)
                .stream()
                .map(user -> mapper.toModel(user))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);
    }
}
