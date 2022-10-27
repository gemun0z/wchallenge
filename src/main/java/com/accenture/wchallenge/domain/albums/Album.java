package com.accenture.wchallenge.domain.albums;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Album {

    String id;
    String userId;
    String title;

}
