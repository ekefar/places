package com.places.photo.persist;

import com.places.model.entity.Photo;
import com.places.model.entity.Place;
import com.places.photo.fetch.PlacePhotosFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class PlacePhotosPersistenceManager {


    private static final Logger LOG = LoggerFactory.getLogger(PlacePhotosPersistenceManager.class);

    public final String EXTENSION = ".png";
    public final String PREFIX = "places-photos";

    private final PhotosPersisterFactory persisterFactory;

    private long requestsCount = 0;

    @Inject
    public PlacePhotosPersistenceManager(PhotosPersisterFactory persisterFactory) {
        this.persisterFactory = persisterFactory;
    }

    public long getRequestsCount() {
        return requestsCount;
    }

    public void manage(Place place) {
        final List<Photo> photos = place.getPhotos();

        int maxRetries = 3;
        int retries = 0;
        boolean fetched = false;

        for (Photo photo : photos) {
            fetched = false;
            retries = 0;
            while (!fetched && retries < maxRetries) {

                try {
                    requestsCount++;
                    final byte[] bytes = PlacePhotosFetcher.fetchPhoto(photo);
                    fetched = true;
                    persisterFactory.getPersister().persist(getPath(place, photo), bytes);
                } catch (Exception e) {
                    LOG.error(" Couldn't fetch photo: " + photo, e);
                    LOG.info("Retrying attempt: " + retries);
                    retries++;
                }
            }

        }
    }

    private String getPath(Place place, Photo photo) {
        return PREFIX + "/" + place.getMapsId() + "/" + photo.getReference() + EXTENSION;
    }
}
