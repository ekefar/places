import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.*;
import model.Place;
import model.Location;
import model.Place.Type;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


/**
 * @author : Alexander Serebriyan
 */
public class PlacesFetcher {

    private static final String KEY = "AIzaSyAd-eoNEpt5faRRvZribmZxha6VrPRcOIY";

    public static List<Place> fetchPlaces(Location location, int radius, Type... type) {
        GeoApiContext context = getGeoContext();

        final LatLng latLng = new LatLng(location.getLat(), location.getLng());
        final NearbySearchRequest request = PlacesApi.nearbySearchQuery(context, latLng);
        request.type(getPlaceTypes(type)).radius(radius);

        List<PlacesSearchResult> places = retrievePlacesDetails(request);

        System.out.println(places);

        return new LinkedList<>();
    }


    public static Optional<Place> fetchPlace(final String id) {
        final GeoApiContext context = getGeoContext();
        final PlaceDetailsRequest request = PlacesApi.placeDetails(context, id);
        final Optional<PlaceDetails> placeDetails = getPlaceDetails(request);

        if(placeDetails.isPresent()) {
            final PlaceDetails place = placeDetails.get();
            final LatLng location = place.geometry.location;
            return Optional.ofNullable(new Place.Builder().setId(id)
                    .setAddress(place.formattedAddress)
                    .setLocation(new Location(location.lat, location.lng))
                    .setName(place.name)
                    .setPhoneNumber(place.formattedPhoneNumber)
                    .setOpeningHours(place.openingHours.toString())
                    .setMapUrl(place.url.toString())
                    .setWebsiteUrl(place.website.toString())
                    .build());
        }

        return Optional.empty();
    }

    static PlaceType [] getPlaceTypes(Type... types) {
        return new PlaceType[] {PlaceType.BANK};
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

    private static List<PlacesSearchResult> retrievePlacesDetails(NearbySearchRequest request) {
        final LinkedList<PlacesSearchResult> placeDetails = new LinkedList<>();

        try {
            PlacesSearchResponse response = request.await();
            placeDetails.addAll(Arrays.asList(response.results));
            while(response.nextPageToken != null) {
                response = PlacesApi.nearbySearchNextPage(getGeoContext(), response.nextPageToken).await();
                placeDetails.addAll(Arrays.asList(response.results));
            }
            return placeDetails;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return placeDetails;
    }


    private static GeoApiContext getGeoContext() {
        return new GeoApiContext().setApiKey(KEY);
    }

}
