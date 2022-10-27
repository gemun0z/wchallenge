package com.accenture.wchallenge.presentation.v1;

import com.accenture.wchallenge.domain.port.WChallengePort;
import com.accenture.wchallenge.presentation.v1.mapper.PhotoMapper;
import com.accenture.wchallenge.presentation.v1.model.photos.PhotoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class PhotosController {

    private final WChallengePort port;
    private PhotoMapper mapper = PhotoMapper.INSTANCE;

    @GetMapping(path = "/photos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PhotoResponse>> photos() {
        List<PhotoResponse> responses = port.getPhotos()
                .stream()
                .map(photo -> mapper.toModel(photo))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(responses);

    }

}
