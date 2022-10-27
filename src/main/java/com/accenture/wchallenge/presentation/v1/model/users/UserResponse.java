package com.accenture.wchallenge.presentation.v1.model.users;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String id;
    private String name;
    private String username;
    private String email;
    private AddressResponse address;
    private String phone;
    private String website;
    private CompanyResponse company;

}
