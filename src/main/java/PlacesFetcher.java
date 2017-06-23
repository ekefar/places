import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;

import java.util.Optional;

/**
 * @author : Alexander Serebriyan
 */
public class PlacesFetcher {

    private static final String KEY = "AIzaSyAd-eoNEpt5faRRvZribmZxha6VrPRcOIY";

    public static void fetchPlaces() {
        GeoApiContext context = getGeoContext();

        final LatLng location = new LatLng(50.034490, 36.220569);
        final NearbySearchRequest request = PlacesApi.nearbySearchQuery(context, location);
        request.type(PlaceType.BANK).radius(1000);

        final Optional<PlacesSearchResponse> placesSearchResponse = searchForPlaces(request);

        System.out.println(placesSearchResponse.get());
    }



    public static void fetchPlace(final String id) {
        final GeoApiContext context = getGeoContext();
        final PlaceDetailsRequest request = PlacesApi.placeDetails(context, id);
        final Optional<PlaceDetails> placeDetails = getPlaceDetails(request);
        System.out.println(placeDetails.get());

    }

    private static Optional<PlaceDetails> getPlaceDetails(PlaceDetailsRequest request) {
        try {
            final PlaceDetails details = request.await();
            return Optional.of(details);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private static Optional<PlacesSearchResponse> searchForPlaces(NearbySearchRequest request) {
        try {
            final PlacesSearchResponse response = request.await();
            return Optional.of(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }


    private static GeoApiContext getGeoContext() {
        return new GeoApiContext().setApiKey(KEY);
    }

}
