package com.accenture.wchallenge.presentation.v1;

import com.accenture.wchallenge.domain.port.WChallengePort;
import com.accenture.wchallenge.presentation.v1.mapper.AlbumMapper;
import com.accenture.wchallenge.presentation.v1.model.albums.AlbumResponse;
import com.accenture.wchallenge.presentation.v1.model.AccessRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class AlbumsController {

    private final WChallengePort port;
    private AlbumMapper mapper = AlbumMapper.INSTANCE;

    @GetMapping(path = "/albums", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlbumResponse>> albums() {
        List<AlbumResponse> responses = port.getAlbums()
                .stream()
                .map(album -> mapper.toModel(album))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);

    }

    @GetMapping(path = "/albums/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlbumResponse>> albumsByUserId(@PathVariable String userId) {
        List<AlbumResponse> responses = port.getAlbumsByUserId(userId)
                .stream()
                .map(album -> mapper.toModel(album))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);

    }

    @PostMapping(path = "/albums/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveAlbumAndUserByAlbumId(@PathVariable String id, @RequestBody AccessRequest request) {
        port.saveAlbumAndUserByAlbumId(id, request.isRead(), request.isWrite());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping(path = "/albums/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAccessByAlbumId(@PathVariable String id, @RequestBody AccessRequest request) {
        port.updateAccessByAlbumId(id, request.isRead(), request.isWrite());
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
