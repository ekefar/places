package com.places.parser.service;


import com.places.model.entity.Location;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Alexander Serebriyan
 */
public class CoordinatesCalculator {

    public static final double STEP_IN_COORDINATE_UNITS = 0.007d;
    public static final int STEP_IN_METERS = 500;


    public static Set<Location> calculateLocations(Location start, int radius) {
        final int iterations = radius / STEP_IN_METERS;
        int steps = 1;
        final HashSet<Location> locations = new HashSet<>();
        for (int i = 0; i < iterations; i++) {
            locations.addAll(calculateSquare(calculateNewStart(start), steps));
            steps += 2;
        }
        return locations;
    }



    private static Location calculateNewStart(Location location) {
        // got to left bottom corner
        return new Location(location.getLat() - STEP_IN_COORDINATE_UNITS, location.getLng() - STEP_IN_COORDINATE_UNITS);
    }

    private static Set<Location> calculateSquare(Location start, int steps) {
        final HashSet<Location> locations = new HashSet<>();
        locations.add(start);

        int i = 0;

        Location currentLocation = start;

        // go up
        for (i = 0; i < steps; i++) {
            currentLocation = new Location(currentLocation.getLat() + STEP_IN_COORDINATE_UNITS, currentLocation.getLng());
            locations.add(currentLocation);
        }

        // go right
        for (i = 0; i < steps; i++) {
            currentLocation = new Location(currentLocation.getLat(), currentLocation.getLng() + STEP_IN_COORDINATE_UNITS);
            locations.add(currentLocation);
        }

        // go down
        for (i = 0; i < steps; i++) {
            currentLocation = new Location(currentLocation.getLat() - STEP_IN_COORDINATE_UNITS, currentLocation.getLng());
            locations.add(currentLocation);
        }

        // go left
        for (i = 0; i < steps - 1; i++) {
            currentLocation = new Location(currentLocation.getLat(), currentLocation.getLng() - STEP_IN_COORDINATE_UNITS);
            locations.add(currentLocation);
        }

        return locations;
    }
}
