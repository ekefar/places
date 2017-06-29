package com.places.service.read;

import com.places.model.entity.Place;
import com.places.model.repository.PlacesRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class PlacesReader {

    @Inject
    private PlacesRepository repository;

    public List<Place> list() {
        return repository.findAll();
    }

    public Place byId(String id){
        return repository.find(id);
    }
}
