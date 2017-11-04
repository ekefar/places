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

    private final PhotosPersisterFactory persisterFactory;

    @Inject
    public PlacePhotosPersistenceManager(PhotosPersisterFactory persisterFactory) {
        this.persisterFactory = persisterFactory;
    }

    public void manage(Place place) {
        final List<Photo> photos = place.getPhotos();
        for (Photo photo : photos) {
            final byte[] bytes = PlacePhotosFetcher.fetchPhoto(photo);
            persisterFactory.getPersister().persist(getS3Path(place, photo), bytes);
        }
    }

    private String getS3Path(Place place, Photo photo) {
        return place.getMapsId() + "/" + photo.getReference() + ".png";
    }
}
