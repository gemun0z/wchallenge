package com.accenture.wchallenge.presentation.v1.model.users;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoResponse {

    private String lat;
    private String lng;

}
