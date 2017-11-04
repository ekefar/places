package com.places.photo;

import com.places.model.entity.Place;
import com.places.model.repository.PlacesRepository;
import com.places.photo.persist.PlacePhotosPersistenceManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Alexander Serebriyan
 */
public class PhotosManager {

    public static void main(String[] args) {
//        final Place place = placesRepository().find("59f9717ccb91bd68e1527db7");
        final Place place = placesRepository().find("59f9717ccb91bd68e152b7a1");
        photosManager().manage(place);
//        final Place savedPlace = repository.find("ChIJp9FD9LSmJ0ERVfQetGJx8QA");

    }

    private static PlacePhotosPersistenceManager photosManager() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        return ctx.getBean(PlacePhotosPersistenceManager.class);
    }

    private static PlacesRepository placesRepository() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        return ctx.getBean(PlacesRepository.class);
    }
}
