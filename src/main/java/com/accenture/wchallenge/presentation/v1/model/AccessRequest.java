package com.accenture.wchallenge.presentation.v1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessRequest {

    private boolean read;
    private boolean write;
}
