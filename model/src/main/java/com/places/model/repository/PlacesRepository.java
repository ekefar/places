package com.places.model.repository;

import com.places.model.entity.Place;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

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

}
