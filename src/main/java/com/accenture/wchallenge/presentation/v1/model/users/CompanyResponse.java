package com.accenture.wchallenge.presentation.v1.model.users;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyResponse {

    private String name;
    private String catchPhrase;
    private String bs;

}
