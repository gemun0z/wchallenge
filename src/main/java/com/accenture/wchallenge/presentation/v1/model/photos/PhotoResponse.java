package com.accenture.wchallenge.presentation.v1.model.photos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhotoResponse {

    private String id;
    private String albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

}
