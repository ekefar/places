package com.places.model.repository;

import com.mongodb.BasicDBObject;
import com.places.model.entity.Place;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class PlacesRepository {

    private final MongoTemplate mongoTemplate;

    @Inject
    public PlacesRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(Place place) {
        mongoTemplate.save(place);
    }

    public void save(Collection<Place> places) {
        mongoTemplate.insert(places, Place.class);
    }

    public Place find(String id) {
        return mongoTemplate.findOne(query(where("_id").is(id)), Place.class);
    }

    public List<Place> findAll() {
        return mongoTemplate.findAll(Place.class);
    }

    public List<Place> findByCity(String city, Pageable pagable) {
        return mongoTemplate.find(query(where("city").regex(city, "i")).with(pagable), Place.class);
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
}
