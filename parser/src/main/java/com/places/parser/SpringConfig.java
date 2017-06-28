package com.places.parser;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author : Alexander Serebriyan
 */
@Configuration
@Import(com.places.model.SpringConfig.class)
@ComponentScan(basePackages = "com.places.parser")
public class SpringConfig {
}
