package com.places.photo.persist;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.places.model.entity.Photo;
import com.places.model.entity.Place;
import com.places.photo.fetch.PlacePhotosFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Alexander Serebriyan
 */
@Service
public class PlacePhotosPersistenceManager {


    private static final Logger LOG = LoggerFactory.getLogger(PlacePhotosPersistenceManager.class);

    public final String EXTENSION = ".png";
    public final String PREFIX = "places-photos/";

    @Value("${photos.bucket}")
    private String bucket;

    private final PhotosPersisterFactory persisterFactory;
    private final AmazonS3 amazonS3;

    private long requestsCount = 0;

    @Inject
    public PlacePhotosPersistenceManager(PhotosPersisterFactory persisterFactory,
                                         AmazonS3 amazonS3) {
        this.persisterFactory = persisterFactory;
        this.amazonS3 = amazonS3;
    }

    public long getRequestsCount() {
        return requestsCount;
    }

    public void manage(List<Place> places) {

        ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
                .withBucketName(bucket).withPrefix(PREFIX)
                .withDelimiter("/");

        final LinkedList<String> allManagedPlaceIds = new LinkedList<>();
        ObjectListing managedPlaces = amazonS3.listObjects(listObjectsRequest);
        allManagedPlaceIds.addAll(extractPlaceIds(managedPlaces));

        while (managedPlaces.isTruncated()) {
            managedPlaces = amazonS3.listNextBatchOfObjects(managedPlaces);
            allManagedPlaceIds.addAll(extractPlaceIds(managedPlaces));
        }


        for (Place place : places) {

            if (allManagedPlaceIds.contains(place.getMapsId())) {
                continue;
            }

            try {
                manage(place);
            } catch (Exception e) {
                LOG.error("# Couldn't manage place: " + place.getMapsId(), e);
            }
        }
    }

    public List<String> extractPlaceIds(ObjectListing listing) {
        final List<String> managedPlacePrefixes = listing.getCommonPrefixes();
        return managedPlacePrefixes.stream()
                .map(id -> id.split("/")[1])
                .collect(Collectors.toList());
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
        return PREFIX + place.getMapsId() + "/" + photo.getReference() + EXTENSION;
    }
}
