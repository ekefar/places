package com.places.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Alexander Serebriyan
 */

@Document(collection = "places")
public class Place {

    @Id
    private String id;
    @Indexed
    private String country;
    @Indexed
    private String city;

    // google maps specific
    @Indexed
    private String mapsId;
    private String name;
    private String address;
    private String phoneNumber;
    private Location location;
    private Map<String, String> openingHours = new HashMap<>();
    private String mapUrl;
    private String websiteUrl;
    private float rating;
    private List<String> types = new ArrayList<>();
    private List<String> photos = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();


    public Place() {
    }

    public Place(String country, String city, String mapsId, String name, String address,
                 String phoneNumber, Location location, Map<String, String> openingHours, String mapUrl,
                 String websiteUrl, float rating) {
        this.country = country;
        this.city = city;
        this.mapsId = mapsId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.openingHours = openingHours;
        this.mapUrl = mapUrl;
        this.websiteUrl = websiteUrl;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMapsId() {
        return mapsId;
    }

    public void setMapsId(String mapsId) {
        this.mapsId = mapsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Map<String, String> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(Map<String, String> openingHours) {
        this.openingHours = openingHours;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", mapsId='" + mapsId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", location=" + location +
                ", openingHours='" + openingHours + '\'' +
                ", mapUrl='" + mapUrl + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", rating=" + rating +
                ", types=" + types +
                ", photos=" + photos +
                ", reviews=" + reviews +
                '}';
    }


    public enum Type {

        ACCOUNTING("accounting"),
        ATM("atm"),
        BANK("bank"),
        BAR("bar"),
        BEAUTY_SALON("beauty_salon"),
        CAFE("cafe"),
        CASINO("casino"),
        DENTIST("dentist"),
        DOCTOR("doctor"),
        ESTABLISHMENT("establishment"),
        FINANCE("finance"),
        FOOD("food"),
        HAIR_CARE("hair_care"),
        HEALTH("health"),
        HOSPITAL("hospital"),
        INSURANCE_AGENCY("insurance_agency"),
        LAWYER("lawyer"),
        NIGHT_CLUB("night_club"),
        PHARMACY("pharmacy"),
        PHYSIOTHERAPIST("physiotherapist"),
        RESTAURANT("restaurant"),
        SPA("spa");

        Type(final String type) {
            this.type = type;
        }

        private String type;

        @Override
        public String toString() {
            return type;
        }
    }

}
