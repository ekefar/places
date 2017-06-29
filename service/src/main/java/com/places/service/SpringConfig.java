package com.places.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : Alexander Serebriyan
 */
@Configuration
@Import(com.places.model.SpringConfig.class)
@ComponentScan(basePackages = "com.places.service")
public class SpringConfig {
}
