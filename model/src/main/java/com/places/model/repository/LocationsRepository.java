package com.places.model.repository;

import com.mongodb.BasicDBObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class LocationsRepository {


    private final MongoTemplate mongoTemplate;

    @Inject
    public LocationsRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Set<String> findCitiesByCountry(String country) {

        final List cities = mongoTemplate.getCollection("places")
                .distinct("city", new BasicDBObject("country", Pattern.compile(country, Pattern.CASE_INSENSITIVE)));

        return new LinkedHashSet<String>(cities);
    }


    public Set<String> findCitiesByState(String state) {

        final List cities = mongoTemplate.getCollection("places")
                .distinct("city", new BasicDBObject("state", Pattern.compile(state, Pattern.CASE_INSENSITIVE)));

        return new LinkedHashSet<String>(cities);
    }

    public Set<String> findDistrictsByCity(String city) {
        final List cities = mongoTemplate.getCollection("places")
                .distinct("district", new BasicDBObject("city", Pattern.compile(city, Pattern.CASE_INSENSITIVE)));

        return new LinkedHashSet<String>(cities);
    }
}
