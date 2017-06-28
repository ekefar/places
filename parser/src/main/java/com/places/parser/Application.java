package com.places.parser;


import com.mongodb.MongoClient;
import com.places.model.entity.Place;
import com.places.model.repository.PlacesRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;
import java.util.Optional;

/**
 * @author : Alexander Serebriyan
 */
public class Application {


    public static void main(String[] args) throws UnknownHostException {

        final PlacesRepository repository = getRepository();

//        final List<Place> places = PlacesFetcher.fetchPlacesLimitless(new Location(53.409919, -2.979781), 5000, Place.Type.BANK);
        final Optional<Place> place = com.places.parser.service.PlacesFetcher.fetchPlace("ChIJp9FD9LSmJ0ERVfQetGJx8QA");

        repository.save(place.get());
        final Place savedPlace = repository.find("ChIJp9FD9LSmJ0ERVfQetGJx8QA");
//        System.exit(0);
    }

    private static PlacesRepository getRepository() {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        return ctx.getBean(PlacesRepository.class);
    }
}
