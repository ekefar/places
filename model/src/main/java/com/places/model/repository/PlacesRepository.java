package com.places.model.repository;

import com.places.model.entity.Place;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;

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

    public void save(Collection<Place> place) {
        mongoTemplate.save(place);
    }

    public Place find(String id) {
        return mongoTemplate.findOne(query(where("id").is(id)), Place.class);
    }

}
