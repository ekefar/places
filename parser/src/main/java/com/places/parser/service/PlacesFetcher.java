package com.places.parser.service;

import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.*;
import com.places.model.entity.Location;
import com.places.model.entity.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.places.parser.service.ContextProvider.getGeoContext;


/**
 * @author : Alexander Serebriyan
 */
public class PlacesFetcher {


    private static final Logger LOG = LoggerFactory.getLogger(PlacesFetcher.class);

    private static final long REQUST_DELAY = 2000;

    private Set<String> fetchedPlaceIds = new HashSet<>();

    private int requestsCount = 0;

    public List<Place> fetchPlaces(List<Location> locations, Place.Type... types) {


        final LinkedList<Place> result = new LinkedList<>();
        try {
            for (Location location : locations) {
                final List<Place> places = fetchPlaces(location, types);
                result.addAll(places);
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();

        }

        return result;
    }

    public List<Place> fetchPlaces(Location location, Place.Type... types) {
        LOG.info("# Fetching places details avoiding google API limits. Initial location: {}", location);
        final Set<Location> locations = CoordinatesCalculator.calculateLocations(location);

        LOG.info("# Transformed initial location into: {}", locations);

        final HashMap<String, Place> placesMap = new HashMap<>();

        for (Location loc : locations) {
            final List<Place> placesFromLocation = fetchPlaces(loc,
                    CoordinatesCalculator.STEP_IN_METERS,
                    this.fetchedPlaceIds, types);
            for (Place place : placesFromLocation) {
                placesMap.put(place.getMapsId(), place);
                this.fetchedPlaceIds.add(place.getMapsId());
            }
        }
        LOG.info("# Fetch complete. Total requests made: " + this.requestsCount);
        return new LinkedList<>(placesMap.values());
    }

    public int getRequestsCount() {
        return requestsCount;
    }

    private List<Place> fetchPlaces(Location location, int radius,
                                    Set<String> exclusions,
                                    Place.Type... types) {
        LOG.info("# Fetching list of places near next location: {}", location);
        LOG.info("# Types to search: {}", types);

        GeoApiContext context = getGeoContext();
        final LatLng latLng = new LatLng(location.getLat(), location.getLng());
        final NearbySearchRequest request = PlacesApi.nearbySearchQuery(context, latLng);
        request.type(transformPlaceTypes(types)).radius(radius);

        List<PlacesSearchResult> basicPlacesDetails = retrieveBasicPlacesDetails(request);

        LOG.info("# Search complete. Items found: {}", basicPlacesDetails.size());
        LOG.info("# Retrieving detailed info for each item...");


        final List<Place> places = retrieveFullPlacesDetails(basicPlacesDetails, exclusions);

        return places;
    }


    public Optional<Place> fetchPlace(final String id) {
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

    private List<Place> retrieveFullPlacesDetails(List<PlacesSearchResult> basicDetailsList,
                                                  Set<String> exclusions) {

        final LinkedList<Place> places = new LinkedList<>();
        for (PlacesSearchResult placeDetails : basicDetailsList) {
            if (exclusions.contains(placeDetails.placeId)) {
                continue;
            }
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

    private Optional<PlaceDetails> getPlaceDetails(PlaceDetailsRequest request) {
        try {
            final PlaceDetails details = request.await();
            this.requestsCount++;
            return Optional.of(details);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private List<PlacesSearchResult> retrieveBasicPlacesDetails(NearbySearchRequest initialRequest) {
        final LinkedList<PlacesSearchResult> placeDetails = new LinkedList<>();

        try {
            PlacesSearchResponse response = initialRequest.await();
            this.requestsCount++;
            placeDetails.addAll(Arrays.asList(response.results));
            while (response.nextPageToken != null) {
                Thread.sleep(REQUST_DELAY);
                response = PlacesApi.nearbySearchNextPage(getGeoContext(), response.nextPageToken).await();
                this.requestsCount++;
                placeDetails.addAll(Arrays.asList(response.results));
            }
            return placeDetails;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return placeDetails;
    }

}
