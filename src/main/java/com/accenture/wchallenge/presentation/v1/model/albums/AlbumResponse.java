package com.accenture.wchallenge.presentation.v1.model.albums;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlbumResponse {

    private String id;
    private String userId;
    private String title;

}
