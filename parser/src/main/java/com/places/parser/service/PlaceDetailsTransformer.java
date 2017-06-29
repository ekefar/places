package com.places.parser.service;

import com.google.common.base.Joiner;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceDetails;
import com.places.model.entity.Location;
import com.places.model.entity.Place;
import com.places.model.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Alexander Serebriyan
 */
public class PlaceDetailsTransformer {


    private static final Logger LOG = LoggerFactory.getLogger(PlaceDetailsTransformer.class);

    public static Place fromPlaceDetails(PlaceDetails details) {
        final String openingHours = details.openingHours != null ? Joiner.on("\n").join(details.openingHours.weekdayText) : "";

        final LatLng location = details.geometry.location;
        final Place place = new Place();
        place.setId(details.placeId);
        place.setAddress(details.formattedAddress);
        place.setLocation(new Location(location.lat, location.lng));
        place.setName(details.name);
        place.setPhoneNumber(details.formattedPhoneNumber);
        place.setOpeningHours(openingHours);
        place.setMapUrl(details.url != null ? details.url.toString() : "");
        place.setWebsiteUrl(details.website != null ? details.website.toString() : "");
        place.setRating(details.rating);
        place.setPhotos(Arrays.stream(details.photos).map(p -> p.photoReference).collect(Collectors.toList()));
        place.setReviews(fromPlaceDetailsReviewArray(details.reviews));

        return place;
    }

    private static List<Review> fromPlaceDetailsReviewArray(PlaceDetails.Review[] detailsReview) {
        return Arrays.stream(detailsReview)
                .map(PlaceDetailsTransformer::fromPlaceDetailsReview)
                .collect(Collectors.toList());
    }

    private static Review fromPlaceDetailsReview(PlaceDetails.Review detailsReview) {
        final Review review = new Review();
        review.setAuthorName(detailsReview.authorName);
        review.setAuthorUrl(detailsReview.authorUrl.toString());
        review.setLanguage(detailsReview.language);
        review.setRating(detailsReview.rating);
        review.setText(detailsReview.text);
        review.setTimestamp(detailsReview.time.getMillis());

        return review;
    }
}
