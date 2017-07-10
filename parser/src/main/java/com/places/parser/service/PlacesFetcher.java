package com.places.parser.service;

import com.google.maps.*;
import com.google.maps.model.*;
import com.places.model.entity.Location;
import com.places.model.entity.Place;
import com.places.parser.service.photo.PhotosPersister;
import com.places.parser.service.photo.PhotosPersisterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.*;

import static com.places.parser.service.ContextProvider.getGeoContext;


/**
 * @author : Alexander Serebriyan
 */
public class PlacesFetcher {

    private final PhotosPersisterFactory photosPersisterFactory;

    private static final Logger LOG = LoggerFactory.getLogger(PlacesFetcher.class);

    private static final long REQUST_DELAY = 5000;

    @Inject
    public PlacesFetcher(PhotosPersisterFactory photosPersisterFactory) {
        this.photosPersisterFactory = photosPersisterFactory;
    }

    public static List<Place> fetchPlacesLimitless(Location location, int radius, Place.Type... types) {
        LOG.info("# Fetching places details avoiding google API limits. Initial location: {}", location);
        final Set<Location> locations = CoordinatesCalculator.calculateLocations(location, radius);

        LOG.info("# Transformed initial location into: {}", locations);

        final HashMap<String, Place> placesMap = new HashMap<>();

        for (Location loc : locations) {
            final List<Place> placesFromLocation = fetchPlaces(loc, CoordinatesCalculator.STEP_IN_METERS, types);
            for (Place place : placesFromLocation) {
                placesMap.put(place.getMapsId(), place);
            }
        }

        return new LinkedList<>(placesMap.values());
    }


    public static List<Place> fetchPlaces(Location location, int radius, Place.Type... types) {
        LOG.info("# Fetching list of places near next location: {}", location);
        LOG.info("# Types to search: {}", types);

        GeoApiContext context = getGeoContext();
        final LatLng latLng = new LatLng(location.getLat(), location.getLng());
        final NearbySearchRequest request = PlacesApi.nearbySearchQuery(context, latLng);
        request.type(transformPlaceTypes(types)).radius(radius);

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

        if (placeDetailsOptional.isPresent()) {
            final PlaceDetails placeDetails = placeDetailsOptional.get();

            final Place place = PlaceDetailsTransformer.fromPlaceDetails(placeDetails);

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

    static PlaceType[] transformPlaceTypes(Place.Type... types) {
        final PlaceType[] placeTypes = new PlaceType[types.length];
        for (int i = 0; i < types.length; i++) {
            Place.Type type = types[i];
            placeTypes[i] = PlaceType.valueOf(type.name());
        }
        return placeTypes;
    }

    private void storePhoto(String photoReference) {

        try {
            final PhotosPersister persister = photosPersisterFactory.instance();
            final PhotoRequest photoRequest = PlacesApi.photo(getGeoContext(), photoReference);
            final PhotoResult photo = photoRequest.await();
            persister.persist("~/photos/" + photoReference, photo.imageData);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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
            while (response.nextPageToken != null) {
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

}
