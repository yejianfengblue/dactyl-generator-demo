package com.example.dactylgeneratordemo;

import com.fasterxml.jackson.annotation.JsonValue;

enum ConnectorType {

    RJ9,
    TRRS,
    NONE;

    @JsonValue
    public String toLowerCase() {
        return toString().toLowerCase();
    }
}
