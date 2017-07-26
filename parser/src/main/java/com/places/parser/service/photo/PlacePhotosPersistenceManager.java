package com.places.parser.service.photo;

import com.places.model.entity.Photo;
import com.places.model.entity.Place;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class PlacePhotosPersistenceManager {

    private final S3PhotosPersister persister;

    @Inject
    public PlacePhotosPersistenceManager(S3PhotosPersister persister) {
        this.persister = persister;
    }

    public void manage(Place place) {
        final List<Photo> photos = place.getPhotos();
        for (Photo photo : photos) {
            final byte[] bytes = PlacePhotosFetcher.fetchPhoto(photo);
            persister.persist(getS3Path(place, photo), bytes);
        }
    }

    private String getS3Path(Place place, Photo photo) {
        return place.getMapsId() + "/" + photo.getReference() + ".jpg";
    }
}
