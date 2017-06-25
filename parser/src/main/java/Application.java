import db.PlacesRepository;
import model.Location;
import model.Place;
import service.PlacesFetcher;

import java.util.List;
import java.util.Optional;

/**
 * @author : Alexander Serebriyan
 */
public class Application {

    public static void main(String[] args) {
        final PlacesRepository repository = new PlacesRepository();
//        final List<Place> places = PlacesFetcher.fetchPlacesLimitless(new Location(53.409919, -2.979781), 5000, Place.Type.BANK);
        final Optional<Place> place = service.PlacesFetcher.fetchPlace("ChIJp9FD9LSmJ0ERVfQetGJx8QA");

//        repository.save(places);
//        System.exit(0);
    }
}
