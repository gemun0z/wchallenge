package com.accenture.wchallenge.domain.users;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Company {

    String name;
    String catchPhrase;
    String bs;
}
