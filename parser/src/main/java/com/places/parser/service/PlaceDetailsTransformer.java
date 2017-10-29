package com.places.parser.service;

import com.google.maps.model.*;
import com.places.model.entity.Location;
import com.places.model.entity.Photo;
import com.places.model.entity.Place;
import com.places.model.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : Alexander Serebriyan
 */
public class PlaceDetailsTransformer {


    private static final Logger LOG = LoggerFactory.getLogger(PlaceDetailsTransformer.class);

    public static Place fromPlaceDetails(PlaceDetails details) {
        final Map<String, String> openingHours = parseOpeningHours(details);

        final LatLng location = details.geometry.location;
        final Place place = new Place();

        place.setCountry(parseCountry(details));
        place.setCity(parseCity(details));
        place.setState(parseState(details));

        place.setMapsId(details.placeId);
        place.setAddress(details.formattedAddress);
        place.setLocation(new Location(location.lat, location.lng));
        place.setName(details.name);
        place.setPhoneNumber(details.formattedPhoneNumber);
        place.setOpeningHours(openingHours);
        place.setMapUrl(details.url != null ? details.url.toString() : "");
        place.setWebsiteUrl(details.website != null ? details.website.toString() : "");
        place.setRating(details.rating);
        place.setTypes(Arrays.asList(details.types));
        if (details.photos != null) {
            place.setPhotos(Arrays.stream(details.photos)
                    .map(p -> new Photo(p.photoReference, p.width, p.height))
                    .collect(Collectors.toList()));
        }

        if (details.reviews != null) {
            place.setReviews(fromPlaceDetailsReviewArray(details.reviews));
        }

        return place;
    }

    private static Map<String, String> parseOpeningHours(PlaceDetails placeDetails) {
        final LinkedHashMap<String, String> hoursMap = new LinkedHashMap<>();
        final OpeningHours openingHours = placeDetails.openingHours;
        if(openingHours == null ) {
            return hoursMap;
        }

        for (String dayString : openingHours.weekdayText) {
            final String[] split = dayString.split(": ");
            final String day = split[0];
            final String openingTime = split[1];
            hoursMap.put(day, openingTime);
        }
        return hoursMap;
    }

    private static String parseState(PlaceDetails placeDetails) {
        return parseAddressComponent(placeDetails, AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1);
    }

    private static String parseCity(PlaceDetails placeDetails) {
        final String postalTown = parseAddressComponent(placeDetails, AddressComponentType.POSTAL_TOWN);

        return "".equals(postalTown) ?  parseAddressComponent(placeDetails, AddressComponentType.LOCALITY):postalTown;
    }

    private static String parseCountry(PlaceDetails placeDetails) {
        return parseAddressComponent(placeDetails, AddressComponentType.COUNTRY);
    }

    private static String parseAddressComponent(PlaceDetails placeDetails, AddressComponentType targetAddressType) {
        for (AddressComponent addressComponent : placeDetails.addressComponents) {
            for (AddressComponentType type : addressComponent.types) {
                if (type == targetAddressType) {
                    return asTitle(addressComponent.longName);
                }
            }
        }

        return "";
    }

    // to lower case with initial capital
    private static String asTitle(String str) {
        final String lowerCased = str.toLowerCase();
        final String firstChar = String.valueOf(lowerCased.charAt(0));
        return lowerCased.replaceFirst(firstChar, firstChar.toUpperCase());
    }

    private static List<Review> fromPlaceDetailsReviewArray(PlaceDetails.Review[] detailsReview) {
        return Arrays.stream(detailsReview)
                .map(PlaceDetailsTransformer::fromPlaceDetailsReview)
                .collect(Collectors.toList());
    }

    private static Review fromPlaceDetailsReview(PlaceDetails.Review detailsReview) {
        final Review review = new Review();
        review.setAuthorName(detailsReview.authorName);
        review.setAuthorUrl(detailsReview.authorUrl != null ? detailsReview.authorUrl.toString() : null);
        review.setLanguage(detailsReview.language);
        review.setRating(detailsReview.rating);
        review.setText(detailsReview.text);
        review.setDate(detailsReview.time != null ? detailsReview.time.toDate() : null);

        return review;
    }
}
