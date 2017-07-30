package com.places.parser.service;


import com.places.model.entity.Location;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Alexander Serebriyan
 */
public class CoordinatesCalculator {

    public static final double STEP_IN_COORDINATE_UNITS = 0.0045d;
    public static final int STEP_IN_METERS = 500;


    public static Set<Location> calculateLocations(Location start, int radius) {
        final int steps = (radius / STEP_IN_METERS) * 2 + 1;
        return calculateSquare(calculateNewStart(start, steps), steps);
    }

    private static Set<Location> calculateSquare(Location start, int steps) {
        double currentLat = start.getLat();
        double currentLng = start.getLng();
        final Set<Location> locations = new HashSet<>();
        for (int i = 0; i < steps; i++) {
            for (int j = 0; j < steps; j++) {
                locations.add(new Location(currentLat, currentLng));
                currentLat += STEP_IN_COORDINATE_UNITS;
            }
            currentLng += STEP_IN_COORDINATE_UNITS;
        }
        return locations;
    }

    private static Location calculateNewStart(Location start, int steps) {
        return new Location(start.getLat() - STEP_IN_COORDINATE_UNITS*steps,
                start.getLng()-STEP_IN_COORDINATE_UNITS*steps);
    }



}
