package com.example.dactylgeneratordemo.manuform;

import com.example.dactylgeneratordemo.SwitchType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class Manuform {

    Keys keys;

    Curve curve;

    Connector connector;

    Form form;

    Misc misc;

    @Data
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    static class Keys {

        int columns;

        int rows;

        ThumbCount thumbCount;

        LastRow lastRow;

        InnerColumn innerColumn;

        boolean hideLastPinky;

        SwitchType switchType;
    }

    @Data
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    static class Curve {

        @JsonProperty("alpha")
        int columnCurvature;

        @JsonProperty("pinky-alpha")
        int pinkyColumnCurvature;

        @JsonProperty("beta")
        int rowCurvature;

        /**
         * center of the curvature for the column
         * <ul>
         * <li>1: index finger column</li>
         * <li>2: middle finger column</li>
         * <li>3: ring finger column</li>
         * <li>4: pinky finger column</li>
         * </ul>
         */
        @JsonProperty("centercol")
        int centerCol;

        int tenting;

        /**
         * rotation around row axis
         */
        @JsonProperty("rotate-x")
        int rotateX;
    }

    @Data
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    static class Connector {

        boolean external;

        ConnectorType type;

        @JsonProperty("micro-usb")
        boolean microusb;
    }

    @Data
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    static class Form {

        boolean hotswap;

        @JsonProperty("thumb-cluster-offset-x")
        double thumbClusterOffsetX;

        @JsonProperty("thumb-cluster-offset-y")
        double thumbClusterOffsetY;

        @JsonProperty("thumb-cluster-offset-z")
        double thumbClusterOffsetZ;

        // todo custom thumb cluster

        boolean stagger;

        @JsonProperty("stagger-index-y")
        double staggerIndexY;

        @JsonProperty("stagger-index-z")
        double staggerIndexZ;

        @JsonProperty("stagger-middle-y")
        double staggerMiddleY;

        @JsonProperty("stagger-middle-z")
        double staggerMiddleZ;

        double staggerRingY;

        double staggerRingZ;

        double staggerPinkyY;

        double staggerPinkyZ;

        boolean widePinky;

        int heightOffset;

        boolean wirePost;

        boolean screwInserts;
    }

    @Data
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    static class Misc {

        boolean keycaps;

        boolean rightSide;
    }
}
