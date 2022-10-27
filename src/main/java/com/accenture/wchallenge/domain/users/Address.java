package com.accenture.wchallenge.domain.users;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Address {

    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;

}
