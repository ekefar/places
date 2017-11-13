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
import java.io.IOException;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author : Alexander Serebriyan
 */
public class PlacesParser {


    public static void main(String[] args) throws UnknownHostException {

//        final Optional<Place> place = new PlacesFetcher().fetchPlace("ChIJu2f9k7YcbkgRwrw4GGJIKoc");
//        final Optional<Place> place = new PlacesFetcher().fetchPlace("ChIJv9DDFm2m2EcRSEVmm54XqbI");
//
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);
        testCSV(10000000);

//        final List<Place> places = new PlacesFetcher().fetchPlaces(
//                new Location(52.907003, -1.503090), Place.Type.CAFE, Place.Type.BAR);
//        final long start = System.currentTimeMillis();

//        specifyDistrictForExistingPlaces();
//        prepareAddressesCSV();
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

    private static void testCSV(long rowsNumber) {

        final long nameWithoutExtension = System.currentTimeMillis();
        File csv = new File(nameWithoutExtension + ".csv");
        BufferedWriter writer = null;
        try {


            writer = new BufferedWriter(new FileWriter(csv));

            long i = 0;

            while (i < rowsNumber) {
                i++;
                final double mz = BigDecimal.valueOf(new Random().nextDouble()).setScale(5, BigDecimal.ROUND_DOWN).doubleValue();
                final double rt = BigDecimal.valueOf(new Random().nextDouble()).setScale(5,BigDecimal.ROUND_DOWN).doubleValue();
                final double x = BigDecimal.valueOf(new Random().nextDouble()).setScale(5,BigDecimal.ROUND_DOWN).doubleValue();
                final double y = BigDecimal.valueOf(new Random().nextDouble()).setScale(5,BigDecimal.ROUND_DOWN).doubleValue();
                final double charge = BigDecimal.valueOf(new Random().nextDouble()).setScale(5,BigDecimal.ROUND_DOWN).doubleValue();
                final String[] row = {
                        String.valueOf(i),
                        String.valueOf(mz),
                        String.valueOf(rt),
                        String.valueOf(charge),
                        String.valueOf(x),
                        String.valueOf(y)
                };

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
                e.printStackTrace();
            }
        }


        try {
            ConvertUtils.convertCsvToParquet(csv, new File(nameWithoutExtension + ".par"));
            csv.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void prepareAddressesCSV() {
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
        for (Place place : places) {
            final List<Object> addressComponents = place.getAddressComponents();
            final String zip = parseAddressComponent(addressComponents, AddressComponentType.POSTAL_CODE);
            if (zip == null) {
                continue;
            }
            final Address address = zipToDistrictMap.get(zip.toUpperCase());
            if (address == null) {
                continue;
            }
            place.setCity(address.city);
            place.setDistrict(address.district);
            repository.save(place);
        }
    }

    private static Map<String, Address> loadAddressesFromGeonames(String path) {
        final HashMap<String, Address> zipToDistrict = new HashMap<>();
        try {
            final List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                final String[] split = line.split("\t");
                final String zip = split[1];
                final String district = split[7];
                final String city = split[2];
                zipToDistrict.put(zip, new Address(city, district));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return zipToDistrict;
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
