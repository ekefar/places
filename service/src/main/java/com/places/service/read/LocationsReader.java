package com.places.service.read;

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

    private final PlacesRepository repository;

    private static Map<String, String> mapping = new HashMap<>();

    static {
        mapping.put("uk", "United Kingdom");
    }

    @Inject
    public LocationsReader(PlacesRepository repository) {
        this.repository = repository;
    }

    public Set<String> citiesByCountry(String country) {
        final String mapped = mapping.get(country);
        return repository.findCitiesByCountry(mapped != null ? mapped : country);
    }

    public Set<String> citiesByState(String state) {
        final long start = System.currentTimeMillis();
        final Set<String> citiesByState = repository.findCitiesByState(state);
        LOG.info("# Cities by country fetched in: " + (System.currentTimeMillis() - start));
        return citiesByState;
    }

}
