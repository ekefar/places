package com.places.model.repository;

import com.mongodb.BasicDBObject;
import com.places.model.entity.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;
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

    public void remove(Place place) {
        mongoTemplate.remove(place);
    }

    public void saveOrUpdate(Place place) {
        mongoTemplate.save(place);
    }

    public void save(Collection<Place> places) {
        mongoTemplate.insert(places, Place.class);
    }

    public void saveOrUpdate(Collection<Place> places) {
        for (Place place : places) {
            mongoTemplate.save(place);
        }
    }

    public Place find(String id) {
        return mongoTemplate.findOne(query(where("_id").is(id)), Place.class);
    }

    public List<Place> findAll() {
        return mongoTemplate.findAll(Place.class);
    }

    public Page<Place> findByState(String state, Pageable pagable) {
        final Query query = query(where("state").regex(streightEquals(state), "i"));
        return getPage(pagable, query);
    }


    public Page<Place> findByCity(String city, Pageable pagable) {
        final Query query = query(where("city").regex(streightEquals(city), "i"));
        return getPage(pagable, query);
    }

    public Page<Place> findByCityAndDistrict(String city, String district, Pageable pagable) {
        final Query query = query(where("city")
                .regex(streightEquals(city), "i")
                .and("district").regex(streightEquals(district), "i"));
        return getPage(pagable, query);
    }

    private Page<Place> getPage(Pageable pagable, Query query) {
        final List<Place> items = mongoTemplate.find(query.with(pagable), Place.class);
        final long count = mongoTemplate.count(query, Place.class);
        return new PageImpl<>(items, pagable, count);
    }

    private String streightEquals(String value) {
        return "^" + value + "$";
    }


    public Set<String> findCitiesByState(String state, String startsWith) {

        final HashMap<String, Object> queryMap = new HashMap<>();
        queryMap.put("state", Pattern.compile(state, Pattern.CASE_INSENSITIVE));

        final HashMap<String, Object> regex = new HashMap<>();
        regex.put("$regex", "^" + startsWith);  // like 'query%'
        queryMap.put("city", regex);
        final List cities = mongoTemplate.getCollection("places")
                .distinct("city", new BasicDBObject(queryMap));

        return new LinkedHashSet<String>(cities);
    }
}
