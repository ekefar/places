package com.places.parser;


import com.places.model.entity.Location;
import com.places.model.entity.Place;
import com.places.model.repository.PlacesRepository;
import com.places.parser.service.PlacesFetcher;
import com.places.parser.service.location.PredefinedLocation;
import com.places.parser.service.location.PredefinedLocationReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class Application {


    public static void main(String[] args) throws UnknownHostException {

        final long start = System.currentTimeMillis();

        final List<PredefinedLocation> locations = PredefinedLocationReader.read();

        final LinkedList<Place> places = new LinkedList<>();
        for (PredefinedLocation location : locations) {
            places.addAll(PlacesFetcher.fetchPlacesLimitless(
                    new Location(location.getLat(), location.getLng()),
                    location.getRadius(),
                    Place.Type.CASINO));
        }

        final PlacesRepository repository = getRepository();
        repository.save(places);

        System.out.println("Done in: " + (System.currentTimeMillis() - start));
//        final Optional<Place> place = PlacesFetcher.fetchPlace("ChIJMQr5yighe0gRaX65MXb98lQ");
//        repository.save(place.get());

//        final Place savedPlace = repository.find("ChIJp9FD9LSmJ0ERVfQetGJx8QA");
    }

    private static PlacesRepository getRepository() {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        return ctx.getBean(PlacesRepository.class);
    }
}
