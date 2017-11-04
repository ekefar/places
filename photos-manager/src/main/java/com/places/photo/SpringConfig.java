package com.places.photo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author : Alexander Serebriyan
 */
@Configuration
@Import(com.places.model.SpringConfig.class)
@ComponentScan(basePackages = "com.places")
@PropertySource({"classpath:parser.properties"})
public class SpringConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public AmazonS3 amazonS3() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAJG63Q7VU7FGD6YNQ",
                "/97OKgifZH47hH8dePLRU8J80VLhfADMWIS3s4Jq");
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.EU_WEST_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
    }
}