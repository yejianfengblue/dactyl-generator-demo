package com.example.dactylgeneratordemo;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SwitchType {

    MX,
    MX_SNAP_IN,
    BOX,
    ALPS,
    CHOC,
    KAILH,
    ;

    @JsonValue
    public String toLowerCase() {
        return toString().toLowerCase().replace('_', '-');
    }
}
