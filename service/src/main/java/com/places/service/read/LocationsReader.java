package com.places.service.read;

import com.places.model.repository.PlacesRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class LocationsReader {

    @Inject
    private PlacesRepository repository;

    public List<String> citiesByCountry(String country) {
        return null;
    }
}
