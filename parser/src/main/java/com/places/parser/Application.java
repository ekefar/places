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
import java.util.List;
import java.util.stream.Collectors;

import static com.places.model.entity.Place.Type.CLOTHING_STORE;
import static com.places.model.entity.Place.Type.SHOE_STORE;

/**
 * @author : Alexander Serebriyan
 */
public class Application {


    public static void main(String[] args) throws UnknownHostException {

//        final Optional<Place> place = new PlacesFetcher().fetchPlace("ChIJu2f9k7YcbkgRwrw4GGJIKoc");
//        final Optional<Place> place = new PlacesFetcher().fetchPlace("ChIJv9DDFm2m2EcRSEVmm54XqbI");
//
        final long start = System.currentTimeMillis();

        final List<PredefinedLocation> predefinedLocations = PredefinedLocationReader.read();

        final PlacesFetcher fetcher = new PlacesFetcher();

        final List<Location> locations = predefinedLocations.stream()
                .map(l -> new Location(l.getLat(), l.getLng(), l.getRadius()))
                .collect(Collectors.toList());
        final List<Place> places = fetcher.fetchPlaces(locations, SHOE_STORE, CLOTHING_STORE);

        final PlacesRepository repository = getRepository();
        repository.save(places);

        System.out.println("Done in: " + (System.currentTimeMillis() - start));
        System.out.println("Total requests made: " + fetcher.getRequestsCount());
//
        System.out.println("done");
    }

    private static PlacesRepository getRepository() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        return ctx.getBean(PlacesRepository.class);
    }


}
