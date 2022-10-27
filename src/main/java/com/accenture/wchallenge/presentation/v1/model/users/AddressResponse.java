package com.accenture.wchallenge.presentation.v1.model.users;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponse {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoResponse geo;

}
