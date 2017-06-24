import db.PlacesRepository;
import model.Location;
import model.Place;

import java.util.List;
import java.util.Optional;

/**
 * @author : Alexander Serebriyan
 */
public class Application {

    public static void main(String[] args) {
        final PlacesRepository repository = new PlacesRepository();
        final List<Place> places = PlacesFetcher.fetchPlaces(new Location(50.034435, 36.220569), 1500, Place.Type.BANK);
//        final Optional<Place> place = PlacesFetcher.fetchPlace("ChIJp9FD9LSmJ0ERVfQetGJx8QA");

        repository.save(places);
//        System.exit(0);
    }
}
