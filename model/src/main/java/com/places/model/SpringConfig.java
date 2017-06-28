package com.places.model;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author : Alexander Serebriyan
 */
@Configuration
@ComponentScan(basePackages = "com.places.model")
@PropertySource("classpath:mongo.properties")
public class SpringConfig {

    @Value("${mongo.host}")
    private String mongoHost;


    @Value("${mongo.db.name}")
    private String mongoDbName;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(new MongoClient(mongoHost), mongoDbName);
    }
}
