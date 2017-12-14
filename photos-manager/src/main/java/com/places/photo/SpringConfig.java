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
@Import({com.places.model.SpringConfig.class,
        com.places.service.SpringConfig.class})
@ComponentScan(basePackages = "com.places.photo")
@PropertySource({"classpath:photos.properties"})
public class SpringConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public AmazonS3 amazonS3() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("BKIAJG63Q7VU7FGD6YNQ",
                "8a0Up8OjmeVAeJPploV1gC/zorfN3qNusAvggRV4");
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.EU_WEST_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
    }
}
