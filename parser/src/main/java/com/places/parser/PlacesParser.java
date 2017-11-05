package com.places.parser;


import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.places.model.entity.Place;
import com.places.model.repository.PlacesRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Alexander Serebriyan
 */
public class PlacesParser {


    public static void main(String[] args) throws UnknownHostException {

//        final Optional<Place> place = new PlacesFetcher().fetchPlace("ChIJu2f9k7YcbkgRwrw4GGJIKoc");
//        final Optional<Place> place = new PlacesFetcher().fetchPlace("ChIJv9DDFm2m2EcRSEVmm54XqbI");
//
       final long start = System.currentTimeMillis();
        prepareAddressesCSV();
//        specifyDistrictForExistingPlaces();
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


    private static void prepareAddressesCSV() {
        final PlacesRepository repository = placesRepository();
        final List<Place> places = repository.findAll().stream()
                .filter(p->p.getCity().equals("London")).collect(Collectors.toList());

        BufferedWriter writer = null;
        try {
            //create a temporary file

            File logFile = new File("addresses.csv");

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());
            writer = new BufferedWriter(new FileWriter(logFile));


            writer.write("name,POSTAL_TOWN,LOCALITY,NEIGHBORHOOD,POLITICAL,ADMINISTRATIVE_AREA_LEVEL_2,maps_url");
            writer.newLine();

            for (Place place : places) {
                final List<Object> addressComponents = place.getAddressComponents();

                final String postal = parseAddressComponent(addressComponents, AddressComponentType.POSTAL_TOWN);
                final String locality = parseAddressComponent(addressComponents, AddressComponentType.LOCALITY);
                final String neighberhood = parseAddressComponent(addressComponents, AddressComponentType.NEIGHBORHOOD);
                final String political = parseAddressComponent(addressComponents, AddressComponentType.POLITICAL);
                final String lev_2 = parseAddressComponent(addressComponents, AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_2);

                final String mapUrl = place.getMapUrl();
                final String name = place.getName();

                final String[] row = {name, postal, locality, neighberhood, political, lev_2, mapUrl};

                writer.write(String.join(",", row));
                writer.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }

    }

    private static void specifyDistrictForExistingPlaces() {
        final PlacesRepository repository = placesRepository();
        final List<Place> places = repository.findAll();

        for (Place place : places) {
            final List<Object> addressComponents = place.getAddressComponents();
            final String locality = parseAddressComponent(addressComponents, AddressComponentType.LOCALITY);
            final String neighberhood = parseAddressComponent(addressComponents, AddressComponentType.NEIGHBORHOOD);
            final String lev_2 = parseAddressComponent(addressComponents, AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_2);

            final boolean contains = addressContains(place, "Stratford");
            place.setDistrict(locality);
        }
    }

    private static boolean addressContains(Place place, String name) {
        final List<Object> addressComponents = place.getAddressComponents();
        for (Object addressComponentObj : addressComponents) {
            final AddressComponent addressComponent = (AddressComponent) addressComponentObj;
            final String longName = addressComponent.longName;
            return name.equals(longName);
        }

        return false;
    }

    private static String parseAddressComponent(List<Object> addressComponents, AddressComponentType targetAddressType) {
        for (Object addressComponentObj : addressComponents) {
            AddressComponent addressComponent = (AddressComponent)addressComponentObj;
            for (AddressComponentType type : addressComponent.types) {
                if (type == targetAddressType) {
                    return asTitle(addressComponent.longName);
                }
            }
        }

        return "";
    }

    // to lower case with initial capital
    private static String asTitle(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        final String lowerCased = str.toLowerCase();
        final String firstChar = String.valueOf(lowerCased.charAt(0));
        return lowerCased.replaceFirst(firstChar, firstChar.toUpperCase());
    }

    private static PlacesRepository placesRepository() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        return ctx.getBean(PlacesRepository.class);
    }

}
