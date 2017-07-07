package com.places.service.read;

import com.places.model.repository.PlacesRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class LocationsReader {


    @Inject
    private PlacesRepository repository;

    public List<String> citiesByCountry(String country) {
        return null;
    }
}
