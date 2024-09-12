package com.myshoppingcart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.myshoppingcart.persistence", "com.myshoppingcart.service" })
@PropertySource("classpath:application.properties")
public class SpringConfig {

}
