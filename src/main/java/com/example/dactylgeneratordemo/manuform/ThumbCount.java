package com.example.dactylgeneratordemo.manuform;

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
