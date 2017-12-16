package com.places.parser;


import com.places.parser.service.MigrationUtil;

import java.net.UnknownHostException;

/**
 * @author : Alexander Serebriyan
 */
public class PlacesParser {


    public static void main(String[] args) throws UnknownHostException {

//        final Optional<Place> place = new PlacesFetcher().fetchPlace("ChIJu2f9k7YcbkgRwrw4GGJIKoc");
//        final Optional<Place> place = new PlacesFetcher().fetchPlace("ChIJv9DDFm2m2EcRSEVmm54XqbI");
//
        MigrationUtil.addWeightedRating();
//        final List<Place> places = new PlacesFetcher().fetchPlaces(
//                new Location(52.907003, -1.503090), Place.Type.CAFE, Place.Type.BAR);
//        final long start = System.currentTimeMillis();

//        dumpAddressesCSV();
        /* final List<PredefinedLocation> predefinedLocations = PredefinedLocationReader.read();

        final PlacesFetcher fetcher = new PlacesFetcher();

        final List<Location> locations = predefinedLocations.stream()
                .map(l -> new Location(l.getLat(), l.getLng(), l.getRadius()))
                .collect(Collectors.toList());
        final List<Place> places = fetcher.fetchPlaces(locations, SHOE_STORE, CLOTHING_STORE);

        final PlacesRepository repository = getRepository();
        repository.save(places);

        System.out.println("Done in: " + (System.currentTimeMillis() - start));
        System.out.println("Total requests made: " + fetcher.getRequestsCount());*/
//
        System.out.println("done");
    }




}
