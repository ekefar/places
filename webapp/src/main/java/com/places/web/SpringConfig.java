package com.places.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : Alexander Serebriyan
 */
@Configuration
@Import(com.places.service.SpringConfig.class)
public class SpringConfig {
}
