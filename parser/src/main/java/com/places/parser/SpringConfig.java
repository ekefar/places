package com.places.parser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author : Alexander Serebriyan
 */
@Configuration
@Import(com.places.model.SpringConfig.class)
@ComponentScan(basePackages = "com.places.parser")
@PropertySource("classpath:mongo.properties")
public class SpringConfig {


    @Value("${active.bucket}")
    private String bucket;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
