package com.example.dactylgeneratordemo.manuform;

import com.fasterxml.jackson.annotation.JsonValue;

enum InnerColumn {

    NORMIE,  // normal
    OUTIE,  // use inner column (like ergodox)
    INNIE;  // without

    @JsonValue
    public String toLowerCase() {
        return toString().toLowerCase();
    }
}
