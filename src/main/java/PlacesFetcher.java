import com.google.common.base.Joiner;
import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.*;
import com.sun.tools.javac.util.ArrayUtils;
import model.Place;
import model.Location;
import model.Place.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


/**
 * @author : Alexander Serebriyan
 */
public class PlacesFetcher {

    private static final long REQUST_DELAY = 2000;
    private static final Logger LOG = LoggerFactory.getLogger(PlacesFetcher.class);

    private static final String KEY = "AIzaSyAd-eoNEpt5faRRvZribmZxha6VrPRcOIY";

    public static List<Place> fetchPlaces(Location location, int radius, Type... types) {
        LOG.info("# Fetching list of places near next location: {}", location);
        LOG.info("# Types to search: {}", types);

        GeoApiContext context = getGeoContext();
        final LatLng latLng = new LatLng(location.getLat(), location.getLng());
        final NearbySearchRequest request = PlacesApi.nearbySearchQuery(context, latLng);
        request.type(getPlaceTypes(types)).radius(radius);

        List<PlacesSearchResult> basicPlacesDetails = retrieveBasicPlacesDetails(request);

        LOG.info("# Search complete. Items found: {}", basicPlacesDetails.size());
        LOG.info("# Retrieving detailed info for each item...");

        final List<Place> places = retrieveFullPlacesDetails(basicPlacesDetails);

        return places;
    }


    public static Optional<Place> fetchPlace(final String id) {
        LOG.info("# Fetching details for place with id: {}", id);
        final GeoApiContext context = getGeoContext();
        final PlaceDetailsRequest request = PlacesApi.placeDetails(context, id);
        final Optional<PlaceDetails> placeDetailsOptional = getPlaceDetails(request);

        if(placeDetailsOptional.isPresent()) {
            final PlaceDetails placeDetails = placeDetailsOptional.get();
            final LatLng location = placeDetails.geometry.location;
            final Place place = new Place.Builder().setId(id)
                    .setAddress(placeDetails.formattedAddress)
                    .setLocation(new Location(location.lat, location.lng))
                    .setName(placeDetails.name)
                    .setPhoneNumber(placeDetails.formattedPhoneNumber)
                    .setOpeningHours(placeDetails.openingHours != null ? Joiner.on("\n").join(placeDetails.openingHours.weekdayText): "")
                    .setMapUrl(placeDetails.url != null ? placeDetails.url.toString():"")
                    .setWebsiteUrl(placeDetails.website != null ? placeDetails.website.toString():"")
                    .build();

            LOG.info("# Returning next details: {}", place);

            return Optional.ofNullable(place);
        }

        return Optional.empty();
    }

    private static List<Place> retrieveFullPlacesDetails(List<PlacesSearchResult> basicDetailsList) {

        final LinkedList<Place> places = new LinkedList<>();
        for (PlacesSearchResult placeDetails : basicDetailsList) {
            fetchPlace(placeDetails.placeId).ifPresent(places::add);
        }
        return places;
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

    private static List<PlacesSearchResult> retrieveBasicPlacesDetails(NearbySearchRequest initialRequest) {
        final LinkedList<PlacesSearchResult> placeDetails = new LinkedList<>();

        try {
            PlacesSearchResponse response = initialRequest.await();
            placeDetails.addAll(Arrays.asList(response.results));
            while(response.nextPageToken != null) {
                Thread.sleep(REQUST_DELAY);
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
