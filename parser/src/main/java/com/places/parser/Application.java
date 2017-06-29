package com.places.parser;


import com.places.model.entity.Location;
import com.places.model.entity.Place;
import com.places.model.repository.PlacesRepository;
import com.places.parser.service.PlacesFetcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.UnknownHostException;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class Application {


    public static void main(String[] args) throws UnknownHostException {

        final PlacesRepository repository = getRepository();

        final List<Place> places = PlacesFetcher.fetchPlacesLimitless(new Location(53.409919, -2.979781), 500, Place.Type.BANK);
        repository.save(places);

//        final Optional<Place> place = PlacesFetcher.fetchPlace("ChIJMQr5yighe0gRaX65MXb98lQ");
//        repository.save(place.get());

//        final Place savedPlace = repository.find("ChIJp9FD9LSmJ0ERVfQetGJx8QA");
//        System.exit(0);
    }

    private static PlacesRepository getRepository() {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        return ctx.getBean(PlacesRepository.class);
    }
}
