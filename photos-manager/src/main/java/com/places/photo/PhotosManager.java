package com.places.photo;

import com.places.model.entity.Place;
import com.places.model.repository.PlacesRepository;
import com.places.photo.persist.PlacePhotosPersistenceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class PhotosManager {

    private static final Logger LOG = LoggerFactory.getLogger(PhotosManager.class);

    public static void main(String[] args) {

        final long start = System.currentTimeMillis();
//        final Place place = placesRepository().find("59f9717ccb91bd68e1527db7");
//        final Place place = placesRepository().find("59f9717ccb91bd68e152b7a1");

        final List<Place> places = placesRepository().findAll();
        final PlacePhotosPersistenceManager photosManager = photosManager();

//        ChIJi2yscOMbdkgRl3vW_LSHEZ4

/*        int index = 0;
        for (Place place : places) {

            if (place.getMapsId().equals("ChIJi2yscOMbdkgRl3vW_LSHEZ4")) {
                break;
            }
            index++;
        }

        final List<Place> unhandled = places.subList(index, places.size());*/


        photosManager.manage(places);

        LOG.info("# Fetching done in: " + (System.currentTimeMillis() - start));
        LOG.info("# Total requests made: " + photosManager.getRequestsCount());

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
