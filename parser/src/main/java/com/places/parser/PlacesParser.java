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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author : Alexander Serebriyan
 */
public class PlacesParser {


    public static void main(String[] args) throws UnknownHostException {

//        final Optional<Place> place = new PlacesFetcher().fetchPlace("ChIJu2f9k7YcbkgRwrw4GGJIKoc");
//        final Optional<Place> place = new PlacesFetcher().fetchPlace("ChIJv9DDFm2m2EcRSEVmm54XqbI");
//

//        final List<Place> places = new PlacesFetcher().fetchPlaces(
//                new Location(52.907003, -1.503090), Place.Type.CAFE, Place.Type.BAR);
//        final long start = System.currentTimeMillis();

        specifyDistrictForExistingPlaces();
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


    private static void dumpAddressesCSV() {
        final PlacesRepository repository = placesRepository();
        final List<Place> places = repository.findAll();

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
        final Map<String, Address> zipToDistrictMap = loadAddressesFromGeonames("/Users/ekefar/work/places/GB_full.csv");
        final PlacesRepository repository = placesRepository();
        final List<Place> places = repository.findAll();

        final LinkedList<Place> notMatched = new LinkedList<>();
        for (Place place : places) {
            final List<Object> addressComponents = place.getAddressComponents();
            final String zip = parseAddressComponent(addressComponents, AddressComponentType.POSTAL_CODE);
            if (zip == null) {
                notMatched.add(place);
                continue;
            }
            final Address address = zipToDistrictMap.get(zip.toUpperCase());
            if (address == null) {
                notMatched.add(place);
                continue;
            }
//            place.setCity(address.city);
            String cleanDistrict = address.district
                    .replace(" District (B)", "")
                    .replace(" District", "")
                    .replace(" London Boro", "")
                    .replace(" (B)", "");

            if (cleanDistrict.startsWith("City") || cleanDistrict.equals("")) {
                cleanDistrict = null;
            }

            place.setDistrict(cleanDistrict);
            repository.saveOrUpdate(place);
        }
    }



    private static Map<String, Address> loadAddressesFromGeonames(String path) {
        final HashMap<String, Address> zipToAddress = new HashMap<>();
        final HashSet<String> duplicates = new HashSet<>();
        try {
            final List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                final String[] split = line.split("\t");
                final String zip = split[1];
                final String district = split[7];
                final String city = split[2];

                if(zipToAddress.containsKey(zip)) {
                     duplicates.add(zip);
                }
                zipToAddress.put(zip, new Address(city, district));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String duplicate : duplicates) {
            zipToAddress.remove(duplicate);
        }

        return zipToAddress;
    }

    static class Address {
        public final String city;
        public final String district;

        public Address(String city, String district) {
            this.city = city;
            this.district = district;
        }
    }

    private static String parseAddressComponent(List<Object> addressComponents, AddressComponentType targetAddressType) {
        for (Object addressComponentObj : addressComponents) {
            AddressComponent addressComponent = (AddressComponent) addressComponentObj;
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
