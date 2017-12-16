package com.places.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
    @Indexed
    private String state;
    @Indexed
    private String district;

    // google maps specific
    @Indexed
    private String mapsId;
    private String name;
    private String address;
    private String phoneNumber;
    private Location location;
    private Map<String, String> openingHours = new LinkedHashMap<>();
    private String mapUrl;
    private String websiteUrl;
    private float rating;
    private float weightedRating;
    private List<String> types = new ArrayList<>();
    private List<Photo> photos = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();

    private List<Object> addressComponents = new ArrayList<>();


    public Place() {
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Object> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<Object> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public float getWeightedRating() {
        return weightedRating;
    }

    public void setWeightedRating(float weightedRating) {
        this.weightedRating = weightedRating;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", district='" + district + '\'' +
                ", mapsId='" + mapsId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", location=" + location +
                ", openingHours=" + openingHours +
                ", mapUrl='" + mapUrl + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", rating=" + rating +
                ", weightedRating=" + weightedRating +
                ", types=" + types +
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
        SPA("spa"),
        SHOE_STORE("shoe_store"),
        CLOTHING_STORE("clothing_store");

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
