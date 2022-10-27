package com.accenture.wchallenge.domain.users;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {

    String id;
    String name;
    String username;
    String email;
    Address address;
    String phone;
    String website;
    Company company;

}
