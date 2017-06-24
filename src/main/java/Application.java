import db.PlacesRepository;
import model.Location;
import model.Place;

import java.util.Optional;

/**
 * @author : Alexander Serebriyan
 */
public class Application {

    public static void main(String[] args) {
        final PlacesRepository repository = new PlacesRepository();
//        PlacesFetcher.fetchPlaces(new Location(50.034435, 36.220569), 100, Place.Type.BANK);
        final Optional<Place> place = PlacesFetcher.fetchPlace("ChIJp9FD9LSmJ0ERVfQetGJx8QA");

//        repository.save(place.get());
    }
}
