package com.places.service.read;

import com.places.model.entity.Place;
import com.places.model.repository.PlacesRepository;

import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class PlacesReader {

    private PlacesRepository repository = new PlacesRepository();

    public List<Place> list() {
        return repository.find();
    }

    public Place byId(String id){
        return repository.find(id);
    }
}
