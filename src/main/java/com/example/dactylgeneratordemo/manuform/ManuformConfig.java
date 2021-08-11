package com.example.dactylgeneratordemo.manuform;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(ManuformProperties.class)
public class ManuformConfig {
}
