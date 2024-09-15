package com.banana.config;


import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application-dev.properties")
@Profile("dev")
public class ConfigDev {
}
