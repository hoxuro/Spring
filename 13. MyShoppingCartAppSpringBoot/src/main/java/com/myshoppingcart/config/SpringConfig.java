package com.myshoppingcart.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.myshoppingcart.persistence", "com.myshoppingcart.service" })
@PropertySource("classpath:application.yml")
@EntityScan("com.myshoppingcart.model")
public class SpringConfig {

}
