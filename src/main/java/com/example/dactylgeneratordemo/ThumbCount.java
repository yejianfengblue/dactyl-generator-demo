package com.example.dactylgeneratordemo;

import com.fasterxml.jackson.annotation.JsonValue;

enum ThumbCount {

    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX;

    @JsonValue
    public String toLowerCase() {
        return toString().toLowerCase();
    }
}
