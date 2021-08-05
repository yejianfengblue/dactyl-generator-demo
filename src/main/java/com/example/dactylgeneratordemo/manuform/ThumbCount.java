package com.example.dactylgeneratordemo.manuform;

import com.fasterxml.jackson.annotation.JsonValue;

enum ThumbCount {

    TWO,
    THREE,
    THREE_MINI,
    FOUR,
    FIVE,
    SIX;

    @JsonValue
    public String toLowerCase() {
        return toString().toLowerCase().replace('_', '-');
    }
}
