package com.example.dactylgeneratordemo;

import com.fasterxml.jackson.annotation.JsonValue;

enum LastRow {

    ZERO,
    TWO,
    FULL;

    @JsonValue
    public String toLowerCase() {
        return toString().toLowerCase();
    }
}
