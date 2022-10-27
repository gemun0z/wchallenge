package com.accenture.wchallenge.domain.users;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Geo {

    String lat;
    String lng;

}
