package com.banana.config;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application-prod.properties")
@Profile("prod")
public class ConfigProd {
}
