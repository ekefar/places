package com.places.photo.persist;

import com.places.model.entity.Photo;
import com.places.model.entity.Place;
import com.places.photo.fetch.PlacePhotosFetcher;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class PlacePhotosPersistenceManager {

    public final String EXTENSION = ".png";
    public final String PREFIX = "places-photos";

    private final PhotosPersisterFactory persisterFactory;

    @Inject
    public PlacePhotosPersistenceManager(PhotosPersisterFactory persisterFactory) {
        this.persisterFactory = persisterFactory;
    }

    public void manage(Place place) {
        final List<Photo> photos = place.getPhotos();
        for (Photo photo : photos) {
            final byte[] bytes = PlacePhotosFetcher.fetchPhoto(photo);
            persisterFactory.getPersister().persist(getPath(place, photo), bytes);
        }
    }

    private String getPath(Place place, Photo photo) {
        return PREFIX + "/" + place.getMapsId() + "/" + photo.getReference() + EXTENSION;
    }
}
