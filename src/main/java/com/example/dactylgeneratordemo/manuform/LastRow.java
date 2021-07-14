package com.example.dactylgeneratordemo.manuform;

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
