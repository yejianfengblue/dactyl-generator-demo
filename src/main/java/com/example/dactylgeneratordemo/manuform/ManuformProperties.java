package com.example.dactylgeneratordemo.manuform;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties("manuform")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManuformProperties {

    /**
     * Dactyl manuform API URL.
     * https://dactyl.siskam.link/api/manuform or http://localhost:3030/api/manuform if you run server locally.
     */
    URI url = URI.create("https://dactyl.siskam.link/api/manuform");

    /**
     * Whether save parameters to JSON file.
     */
    boolean generateJson = true;

    /**
     * Whether request API to generate SCAD file.
     * If {@link #generatePng} or {@link #generateStl} is set to {@code true}, make sure this value is also set to
     * {@code true} or the SCAD file with same filename was generated in previous run.
     */
    boolean generateScad = true;

    /**
     * Whether export preview PNG images from SCAD file.
     */
    boolean generatePng = false;

    /**
     * Whether render SCAD file and export STL file.
     */
    boolean generateStl = false;

}
