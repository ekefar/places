import model.Location;
import model.Place;

/**
 * @author : Alexander Serebriyan
 */
public class Application {

    public static void main(String[] args) {
        PlacesFetcher.fetchPlaces(new Location(50.034435, 36.220569),
                2000, Place.Type.BANK);

//        PlacesFetcher.fetchPlace("ChIJp9FD9LSmJ0ERVfQetGJx8QA");
    }
}
