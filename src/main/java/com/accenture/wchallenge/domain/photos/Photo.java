package com.accenture.wchallenge.domain.photos;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Photo {

    String id;
    String albumId;
    String title;
    String url;
    String thumbnailUrl;

}
