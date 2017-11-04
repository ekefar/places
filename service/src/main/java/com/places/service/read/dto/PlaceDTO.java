package com.places.service.read.dto;

import com.places.model.entity.Location;
import com.places.model.entity.Review;

import java.util.List;
import java.util.Map;

public class PlaceDTO {

    private final String id;
    private final String mapsId;
    private final String name;
    private final String country;
    private final String state;
    private final String city;
    private final Location location;
    private final String phoneNumber;
    private final String address;
    private final String mapUrl;
    private final String websiteUrl;
    private final float rating;
    private final String thumbnailUrl;
    private final Map<String, String> openingHours;
    private final List<String> photoUrls;
    private final List<Review> reviews;

    private PlaceDTO(String id, String mapsId, String name, String country, String state, String city,
                     Location location, String phoneNumber,
                     String address, String mapUrl, String websiteUrl, float rating, Map<String, String> openingHours,
                     String thumbnailUrl, List<String> photoUrls, List<Review> reviews) {
        this.id = id;
        this.mapsId = mapsId;
        this.name = name;
        this.country = country;
        this.state = state;
        this.city = city;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.mapUrl = mapUrl;
        this.websiteUrl = websiteUrl;
        this.rating = rating;
        this.openingHours = openingHours;
        this.thumbnailUrl = thumbnailUrl;
        this.photoUrls = photoUrls;
        this.reviews = reviews;
    }

    public String getId() {
        return id;
    }

    public String getMapsId() {
        return mapsId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public Location getLocation() {
        return location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public float getRating() {
        return rating;
    }

    public Map<String, String> getOpeningHours() {
        return openingHours;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public static class Builder {
        private String id;
        private String mapsId;
        private String name;
        private String country;
        private String state;
        private String city;
        private Location location;
        private String phoneNumber;
        private String address;
        private String mapUrl;
        private String websiteUrl;
        private float rating;
        private String thumbnailUrl;
        private Map<String, String> openingHours;
        private List<String> photoUrls;
        private List<Review> reviews;


        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setMapsId(String mapsId) {
            this.mapsId = mapsId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setMapUrl(String mapUrl) {
            this.mapUrl = mapUrl;
            return this;
        }

        public Builder setOpeningHours(Map<String, String> openingHours) {
            this.openingHours = openingHours;
            return this;
        }

        public Builder setWebsiteUrl(String websiteUrl) {
            this.websiteUrl = websiteUrl;
            return this;
        }

        public Builder setRating(float rating) {
            this.rating = rating;
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
            return this;
        }

        public Builder setPhotoUrls(List<String> photoUrls) {
            this.photoUrls = photoUrls;
            return this;
        }

        public Builder setReviews(List<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public PlaceDTO build() {
            return new PlaceDTO(id, mapsId, name, country, state, city, location, phoneNumber,
                    address, mapUrl, websiteUrl, rating, openingHours, thumbnailUrl, photoUrls, reviews);
        }
    }
}