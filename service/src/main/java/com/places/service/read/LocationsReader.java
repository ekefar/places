package com.places.service.read;

import com.places.model.repository.LocationsRepository;
import com.places.model.repository.PlacesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class LocationsReader {

    private static final Logger LOG = LoggerFactory.getLogger(LocationsReader.class);

    private final PlacesRepository placesRepository;
    private final LocationsRepository locationsRepository;

    private static Map<String, String> mapping = new HashMap<>();

    static {
        mapping.put("uk", "United Kingdom");
    }

    @Inject
    public LocationsReader(PlacesRepository placesRepository,
                           LocationsRepository locationsRepository) {
        this.placesRepository = placesRepository;
        this.locationsRepository = locationsRepository;
    }

    public Set<String> citiesByCountry(String country) {
        final String mapped = mapping.get(country);
        return locationsRepository.findCitiesByCountry(mapped != null ? mapped : country);
    }

    public Set<String> citiesByState(String state) {
        return citiesByState(state, "");
    }

    public Set<String> citiesByState(String state, String startsWith) {
        final long start = System.currentTimeMillis();
        String query = startsWith == null ? "" : startsWith;
        final Set<String> citiesByState = placesRepository.findCitiesByState(state, query);
        LOG.info("# Cities by country fetched in: " + (System.currentTimeMillis() - start));
        return citiesByState;
    }

    public Set<String> districtsByCity(String city) {
        final long start = System.currentTimeMillis();
        final Set<String> citiesByState = locationsRepository.findDistrictsByCity(city);
        LOG.info("# Districts by city fetched in: " + (System.currentTimeMillis() - start));
        return citiesByState;
    }

}
