package com.places.parser;


import com.places.model.entity.Place;
import com.places.model.repository.PlacesRepository;
import com.places.parser.service.PlacesFetcher;
import com.places.parser.service.photo.PlacePhotosFetcher;
import com.places.parser.service.photo.S3PhotosPersister;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.UnknownHostException;
import java.util.Optional;

/**
 * @author : Alexander Serebriyan
 */
public class Application {


    public static void main(String[] args) throws UnknownHostException {

        /*final long start = System.currentTimeMillis();

        final List<PredefinedLocation> locations = PredefinedLocationReader.read();

        final LinkedList<Place> places = new LinkedList<>();
        for (PredefinedLocation location : locations) {
            places.addAll(PlacesFetcher.fetchPlacesLimitless(
                    new Location(location.getLat(), location.getLng()),
                    location.getRadius(),
                    Place.Type.CASINO));
        }

        final PlacesRepository repository = getRepository();
        repository.save(places);

        System.out.println("Done in: " + (System.currentTimeMillis() - start));*/
        final Optional<Place> place = PlacesFetcher.fetchPlace("ChIJUSQbhSMhe0gRxQQboqAVjOw");
        final byte[] bytes = PlacePhotosFetcher.fetchPhoto(place.get().getPhotos().get(0));
        final S3PhotosPersister s3Persister = getS3Persister();
        s3Persister.persist("img.jpg", bytes);
//
//        final Place savedPlace = repository.find("ChIJp9FD9LSmJ0ERVfQetGJx8QA");
    }

    private static PlacesRepository getRepository() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        return ctx.getBean(PlacesRepository.class);
    }

    private static S3PhotosPersister getS3Persister() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        return ctx.getBean(S3PhotosPersister.class);
    }
}
